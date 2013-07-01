package com.tiv.webtrue.web.controller;

import com.tiv.webtrue.core.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/category")
public class CategoryController extends NavigationController {

  @Autowired
  private CategoryService categoryService;

  @RequestMapping(value = Actions.ALL, method = RequestMethod.GET)
  public String getAll() {
    action(HomeController.Views.HOME, HomeController.Actions.HOME);
    return Views.ARTICLES;
  }

  public interface Actions{
    public static final String ALL = "/all";
  }
  public interface Views{
    public static final String ARTICLES = "pages/articles";
  }
}
