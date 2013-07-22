package com.tiv.webtrue.core.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiv.webtrue.core.security.DigestGenerator;
import com.tiv.webtrue.core.service.AccountService;
import com.tiv.webtrue.core.service.MailSender;
import com.tiv.webtrue.core.service.ProfileService;
import com.tiv.webtrue.core.service.bo.Email;
import com.tiv.webtrue.core.service.bo.InventationBO;
import com.tiv.webtrue.core.service.bo.UserBO;
import com.tiv.webtrue.dao.AbstractDao;
import com.tiv.webtrue.dao.InventationDao;
import com.tiv.webtrue.dao.ProfileDao;
import com.tiv.webtrue.dao.dto.AccountDTO;
import com.tiv.webtrue.dao.dto.InventationDTO;
import com.tiv.webtrue.dao.dto.ProfileDTO;
import com.tiv.webtrue.dao.dto.Role;


@Transactional
@Service
public class ProfileServiceImpl extends AbstractServiceImpl<ProfileDTO> implements ProfileService {

  private static final String TEMPLATE = "templates/email/registered.vm";
  
  private static final String TEMPLATE_INVITE = "templates/email/invite.vm";
  
  private static final String TEMPLATE_INVITED = "templates/email/invited.vm";

  @Autowired
  private ProfileDao profileDao;

  @Autowired
  private AccountService accountService;

  @Autowired
  private MailSender mailSender;
  
  @Autowired
  private InventationDao inventationDao;
  
  @Autowired
  private Mapper mapper;

  @Autowired
  @Value("${profile.service.email.subject}")
  private String subject;
  
  @Autowired
  @Value("${profile.service.invite.email.subject}")
  private String subjectInvite;
  
  @Autowired
  @Value("${profile.service.invited.email.subject}")
  private String subjectInvited;


  // TODO Move to configuration
  private Executor executor = Executors.newFixedThreadPool(3);

  private static Logger logger = Logger.getLogger(ProfileServiceImpl.class);

  @PostConstruct
  public void init() {

    UserBO bo = new UserBO();
    bo.setFullName("admin");
    bo.setEmail("admin@collaborator.com");
    bo.setPassword("admin12345");
    AccountDTO accountDTO = accountService.getByEmail(bo.getEmail());
    if (accountDTO == null) {
      save(bo, Role.ADMIN);
    }
  }

  @Override
  public void register(UserBO registrationBO) throws AccountDuplicateException,
      InvalidInvantationCode {
    AccountDTO savedAccount = accountService.getByEmail(registrationBO.getEmail());
    if (savedAccount != null) {
      throw new AccountDuplicateException();
    }

    Role role = Role.USER;

    if (registrationBO.getInvitation() != null && !registrationBO.getInvitation().isEmpty()) {
      // TODO change to InventationService
      if (!"555".contains(registrationBO.getInvitation())) {
        throw new InvalidInvantationCode();
      } else {
        role = Role.EXPERT;
      }
    }

    save(registrationBO, role);

    sendEmail(registrationBO);

  }


  private void save(UserBO registrationBO, Role role) {
    AccountDTO account = new AccountDTO();
    account.setEmail(registrationBO.getEmail());
    account.setPassword(registrationBO.getPassword());
    account.setActivationCode(registrationBO.getActivationCode());
    accountService.save(account, role);


    ProfileDTO profile = new ProfileDTO();
    profile.setAccountId(account.getId());
    profile.setFullName(registrationBO.getFullName());
    save(profile);
  }


  private void sendEmail(UserBO registrationBO) {
    // TODO move string to properties
    Email email = new Email(registrationBO.getEmail(), subject, TEMPLATE);
    email.setHtml(true);
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("fullName", registrationBO.getFullName());
    model.put("url", registrationBO.getActivationUrl());
    email.setModel(model);
    mailSender.send(email);
  }


  @Override
  AbstractDao<ProfileDTO, Long> getDao() {
    return profileDao;
  }


  @Override
  public UserBO activate(String activationCode) {
    AccountDTO accountDTO = accountService.getByActivationCode(activationCode);
    UserBO registrationBO = null;
    if (accountDTO != null) {
      registrationBO = getUserBO(accountDTO);
    }


    return registrationBO;
  }

  private UserBO getUserBO(AccountDTO accountDTO) {
    UserBO registrationBO;
    ProfileDTO profileDTO = getByAccountId(accountDTO.getId());
    accountService.activate(accountDTO.getId());
    registrationBO = new UserBO();
    registrationBO.setFullName(profileDTO.getFullName());
    registrationBO.setProfileId(profileDTO.getId());
    registrationBO.setEmail(accountDTO.getEmail());
    registrationBO.setPassword(accountDTO.getPassword());
    return registrationBO;
  }


  @Override
  public ProfileDTO getByAccountId(Long accountId) {
    return getDao().findFirst(Restrictions.eq("accountId", accountId));
  }


  @Override
  public void sendConfirmationEmail() {
    // TODO Auto-generated method stub

  }
  
  
  @Override
  public void invite(InventationBO bo) {
     String code = DigestGenerator.genarateNumbers(5L);
     bo.setCode(code);
     InventationDTO dto = mapper.map(bo,InventationDTO.class);
     inventationDao.save(dto);
     
     AccountDTO accountDTO = accountService.getByEmail(bo.getEmail());
     Email email = null;
     Map<String, Object> model = new HashMap<String, Object>();
     if (accountDTO==null){
       email = new Email(bo.getEmail(),subjectInvite,TEMPLATE_INVITE);
     }else{
       ProfileDTO profileDTO = getByAccountId(accountDTO.getId());
       accountService.save(accountDTO,Role.EXPERT);
       model.put("fullName", profileDTO.getFullName());
       email = new Email(bo.getEmail(),subjectInvited,TEMPLATE_INVITED);
     }
    
     model.put("url", bo.getRegistrationUrl());
     email.setModel(model);
     email.setHtml(true);
     mailSender.send(email);
  }

  @Override
  public UserBO getByInventationCode(String invantationCode) {
    InventationDTO dto = inventationDao.findFirst(Restrictions.eq("code", invantationCode));
    UserBO bo = null;
    
    if (dto!=null){
       bo = new UserBO();
       bo.setInvitation(dto.getCode());
       bo.setEmail(dto.getEmail());
    }
    
    return bo;
  }



}
