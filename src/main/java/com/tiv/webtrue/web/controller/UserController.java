package com.tiv.webtrue.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tiv.webtrue.core.security.DigestGenerator;
import com.tiv.webtrue.core.service.ProfileService;
import com.tiv.webtrue.core.service.bo.Email;
import com.tiv.webtrue.core.service.bo.InventationBO;
import com.tiv.webtrue.core.service.bo.UserBO;
import com.tiv.webtrue.core.service.impl.AccountDuplicateException;
import com.tiv.webtrue.core.service.impl.InvalidInvantationCode;

@Controller
public class UserController extends NavigationController {

  @Autowired
  private ProfileService profileService;

  @Autowired
  private HttpServletRequest request;

  @Autowired
  private DaoAuthenticationProvider authenticationProvider;

  private Logger logger = Logger.getLogger(UserController.class);

  @RequestMapping(value = Actions.SIGNIN, method = RequestMethod.GET)
  public String signin(ModelMap map) {
    map.addAttribute("articles", true);
    map.addAttribute("articlesmy", true);
    return ArticlesController.Views.ARTICLES;
  }

  @RequestMapping(value = Actions.LOGIN, method = RequestMethod.GET)
  public String login() {
    return Views.LOGIN;
  }

  @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
  public String loginerror(ModelMap model) {
    model.addAttribute("error", "true");
    return Views.LOGIN;
  }


  @RequestMapping(value = "/denied", method = RequestMethod.GET)
  public String denied() {
    return Views.DENIED;
  }



  @RequestMapping(value = "/invite", method = RequestMethod.POST)
  public String invite(@Valid @ModelAttribute InventationForm form, BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      return Views.INVENTATION;
    }

    InventationBO inventationBO = new InventationBO();
    inventationBO.setEmail(form.getEmail());

    profileService.invite(inventationBO);

    return Views.INVENTATION_SUCCESS;
  }

  @RequestMapping(value = Actions.REGISTRATION_INFORMATION, method = RequestMethod.GET)
  public String registrationInformation(ModelMap model) {
    return Views.REGISTRATION;
  }


  @RequestMapping(value = Actions.ACTIVATE, method = RequestMethod.GET)
  public String activated(@PathVariable String activationCode, ModelMap model) {
    UserBO dto = profileService.activate(activationCode);
    String view = Views.ACTIVATED;
    if (dto == null) {
      view = Views.ACTIVATED_ERROR;
    } else {
      doAutoLogin(dto.getEmail(), dto.getPassword());
    }

    model.addAttribute("registration", dto);

    return view;
  }

  @RequestMapping(value = Actions.REGISTRATION, method = RequestMethod.POST)
  public String registration(@Valid @ModelAttribute RegistrationForm registrationForm,
      BindingResult result, Model model) {
    if (result.hasErrors()) {
      return Views.SIGNUP;
    }

    UserBO bo = new UserBO();
    bo.setEmail(registrationForm.getEmail());
    bo.setFullName(registrationForm.getFullName());
    bo.setInvitation(registrationForm.getInvitation());
    bo.setPassword(registrationForm.getPassword());
    String genarateNumbers = DigestGenerator.genarateNumbers(1L);
    bo.setActivationCode(genarateNumbers);
    bo.setActivationUrl(getActivationUrl(genarateNumbers));

    try {
      profileService.register(bo);
    } catch (AccountDuplicateException e) {
      model.addAttribute("duplicate", "true");
      result.rejectValue("email", "duplicate");
      return Views.SIGNUP;
    } catch (InvalidInvantationCode e) {
      result.rejectValue("invitation", "invalid");
      return Views.SIGNUP;
    }

    return "redirect:" + Actions.REGISTRATION_INFORMATION;
  }

  private String getActivationUrl(String genarateNumbers) {
    String substring = getSitePath();
    return substring + Actions.ACTIVATE_PREFIX + genarateNumbers;
  }


  private String getSitePath() {
    String string = request.getRequestURL().toString();
    int indexOf = string.lastIndexOf("/");
    String substring = string.substring(0, indexOf);
    return substring;
  }


  @RequestMapping(value = Actions.SIGNUP, method = RequestMethod.GET)
  public String signup(ModelMap model) {
    RegistrationForm registrationForm = new RegistrationForm();
    model.addAttribute("registrationForm", registrationForm);
    return Views.SIGNUP;
  }


  @RequestMapping(value = Actions.SIGNUP_WITH_INVITE, method = RequestMethod.GET)
  public String signupWithInvite(@PathVariable String inventationCode, ModelMap model) {
    RegistrationForm registrationForm = new RegistrationForm();
    registrationForm.setInvitation(inventationCode);
    model.addAttribute("registrationForm", registrationForm);
    return Views.SIGNUP;
  }


  @RequestMapping(value = Actions.NEW_INVENTATION, method = RequestMethod.GET)
  public String newInvite(ModelMap model) {
    InventationForm registrationForm = new InventationForm();
    model.addAttribute("inventationForm", registrationForm);
    return Views.INVENTATION;
  }


  @RequestMapping(value = Actions.LOGOUT, method = RequestMethod.GET)
  public String logout(ModelMap map) {
    SecurityContextHolder.clearContext();
    map.addAttribute("articles", true);
    map.addAttribute("articlesnew", true);
    return ArticlesController.Views.ARTICLES;
  }


  private void doAutoLogin(String username, String password) {
    try {
      // Must be called from request filtered by Spring Security, otherwise SecurityContextHolder is
      // not updated
      UsernamePasswordAuthenticationToken token =
          new UsernamePasswordAuthenticationToken(username, password);
      token.setDetails(new WebAuthenticationDetails(request));
      Authentication authentication = this.authenticationProvider.authenticate(token);
      logger.debug("Logging in with" + authentication.getPrincipal());
      SecurityContextHolder.getContext().setAuthentication(authentication);
    } catch (Exception e) {
      SecurityContextHolder.getContext().setAuthentication(null);
      logger.error("Failure in autoLogin", e);
    }

  }

  public interface Actions {
    public static final String SIGNUP_WITH_INVITE = "/signup/{inventationCode}";
    public static final String NEW_INVENTATION = "/newinvite";
    public static final String ACTIVATE_PREFIX = "/activate/";
    public static final String ACTIVATION_CODE = "{activationCode}";
    public static final String ACTIVATE = ACTIVATE_PREFIX + ACTIVATION_CODE;
    public static final String SIGNIN = "/signin";
    public static final String LOGIN = "/login";
    public static final String SIGNUP = "/signup";
    public static final String LOGOUT = "/logout";
    public static final String REGISTRATION = "/registration";
    public static final String REGISTRATION_INFORMATION = "/registrationinfo";
  }

  public interface Views {
    public static final String INVENTATION_SUCCESS = "pages/invite_success";
    public static final String INVENTATION = "pages/invite";
    public static final String DENIED = "pages/denied";
    public static final String ACTIVATED_ERROR = "pages/activation_error";
    public static final String ACTIVATED = "pages/activated";
    public static final String LOGIN = "pages/login";
    public static final String SIGNUP = "pages/signup";
    public static final String REGISTRATION = "pages/registration";
  }
}
