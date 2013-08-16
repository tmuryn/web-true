package com.tiv.webtrue.web.controller;


import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 * 
 * @author dmytro.plekhotkin
 */
@Controller
public final class HomeController extends NavigationController {
  
   /**
   * Returns jsp page name that renders global navigation layout.
   *
   * @return jsp page name as string
   * @throws IOException Input/Output exception
   */
  @RequestMapping(value = Actions.ROOT, method = RequestMethod.GET)
  public String root(ModelMap map) throws IOException {
    return home(map);
  }
  
  
  @RequestMapping(value = Actions.HOME, method = RequestMethod.GET)
  public String home(ModelMap map) throws IOException {
    action("articles", ArticlesController.Actions.ARTICLES);
    return Views.HOME;
  }
  
  
  
  
  public interface Actions {
    public static final String ROOT = "/";
    public static final String HOME = "/home";
  }

  public interface Views {
    public static final String HOME = "home";
  }
  
  

}