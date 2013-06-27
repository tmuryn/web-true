package com.tiv.webtrue.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

  @RequestMapping(value = Actions.REGISTRATION, method = RequestMethod.POST)
  public String registration(@Valid @ModelAttribute RegistrationForm form, BindingResult result, Model model) {
    
    if (result.hasErrors()) {
      return Views.SIGNUP;
    }
    
    try {
      profileService.register(form.getAccount(),form.getProfile());
    } catch (AccountDuplicateException e) {
      model.addAttribute("duplicate", "true");
      return Views.SIGNUP;
    }

    return "redirect:" + Views.REGISTRATION;
  }

  @RequestMapping(value = Actions.SIGNUP, method = RequestMethod.GET)
  public String signup() {
    return Views.SIGNUP;
  }

  public interface Actions {
    public static final String SIGNIN = "/signin";
    public static final String LOGIN = "/login";
    public static final String SIGNUP = "/signup";
    public static final String REGISTRATION = "/registration";
  }

  public interface Views {
    public static final String LOGIN = "pages/login";
    public static final String SIGNUP = "pages/signup";
    public static final String REGISTRATION = "pages/registration";
  }
}
