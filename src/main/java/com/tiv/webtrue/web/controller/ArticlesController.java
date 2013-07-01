package com.tiv.webtrue.web.controller;


import java.io.IOException;

import javax.persistence.PostPersist;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public final class ArticlesController extends NavigationController {
  
 
  @RequestMapping(value = Actions.ARTICLES, method = RequestMethod.GET)
  public String articles() throws IOException {
    action(HomeController.Views.HOME,HomeController.Actions.HOME);
    action("signin", UserController.Actions.SIGNIN);
    return Views.ARTICLES;
  }
  
  @RequestMapping(value = Actions.ARTICLES, method = RequestMethod.POST)
  public String token(@RequestParam String token) throws IOException {
    action(HomeController.Views.HOME,HomeController.Actions.HOME);
    return Views.ARTICLES;
  }
  
  public interface Actions {
    public static final String ARTICLES = "/articles";
  }

  public interface Views {
    public static final String ARTICLES = "pages/articles";
  }
  
  

}