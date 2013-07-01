package com.tiv.webtrue.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tiv.webtrue.core.dao.dto.AccountDTO;
import com.tiv.webtrue.core.service.ProfileService;
import com.tiv.webtrue.core.service.impl.AccountDuplicateException;

@Controller
public class UserController {

  @Autowired
  private ProfileService profileService;

  @RequestMapping(value = Actions.SIGNIN, method = RequestMethod.GET)
  public String signin() {
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
  
  @RequestMapping(value = Actions.REGISTRATION_INFORMATION, method = RequestMethod.GET)
  public String registrationInformation(ModelMap model) {
    return Views.REGISTRATION;
  }

  @RequestMapping(value = Actions.REGISTRATION, method = RequestMethod.POST)
  public String registration(@Valid @ModelAttribute RegistrationForm registrationForm, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return Views.SIGNUP;
    }
    
    
    
//  try {
//      
//      profileService.register(registrationForm.getAccount(),registrationForm.getProfile());
//    } catch (AccountDuplicateException e) {
//      model.addAttribute("duplicate", "true");
//      return Views.SIGNUP;
//    }

    return "redirect:" + Actions.REGISTRATION_INFORMATION;
  }

  @RequestMapping(value = Actions.SIGNUP, method = RequestMethod.GET)
  public String signup(ModelMap model) {
    RegistrationForm registrationForm = new RegistrationForm();
    model.addAttribute("registrationForm", registrationForm);  
    return Views.SIGNUP;
  }

  public interface Actions {
    public static final String SIGNIN = "/signin";
    public static final String LOGIN = "/login";
    public static final String SIGNUP = "/signup";
    public static final String REGISTRATION = "/registration";
    public static final String REGISTRATION_INFORMATION = "/registrationinfo";
  }

  public interface Views {
    public static final String LOGIN = "pages/login";
    public static final String SIGNUP = "pages/signup";
    public static final String REGISTRATION = "pages/registration";
  }
}
