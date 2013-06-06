package com.tiv.webtrue.web.controller;


import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public final class ArticlesController extends NavigationController {
  
 
  @RequestMapping(value = Actions.ARTICLES, method = RequestMethod.GET)
  public String articles() throws IOException {
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