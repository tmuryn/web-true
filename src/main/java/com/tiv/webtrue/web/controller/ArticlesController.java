package com.tiv.webtrue.web.controller;


import java.io.IOException;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tiv.webtrue.core.security.DigestGenerator;
import com.tiv.webtrue.core.service.bo.UserBO;
import com.tiv.webtrue.core.service.impl.AccountDuplicateException;
import com.tiv.webtrue.core.service.impl.InvalidInvantationCode;
import com.tiv.webtrue.web.controller.UserController.Actions;
import com.tiv.webtrue.web.controller.UserController.Views;

@Controller
public final class ArticlesController extends NavigationController {


  @RequestMapping(value = Actions.ARTICLES, method = RequestMethod.GET)
  public String articles(ModelMap map) throws IOException {
    action(HomeController.Views.HOME, HomeController.Actions.HOME);
    action("signin", UserController.Actions.SIGNIN);
    map.addAttribute("articles", true);
    if (SecurityContextHolder.getContext().getAuthentication() == null) {
      map.addAttribute("articlesnew", true);
    } else {
      map.addAttribute("articlesmy", true);
    }
    return Views.ARTICLES;
  }

  @RequestMapping(value = Actions.NEW_ARTICLE, method = RequestMethod.GET)
  public String newArticle(ModelMap model) throws IOException {
    ArticleForm registrationForm = new ArticleForm();
    model.addAttribute("articleForm", registrationForm);
    return Views.EDIT_ARTICLE;
  }

  // @RequestMapping(value = Actions.ARTICLES, method = RequestMethod.POST)
  // public String token(@RequestParam String token) throws IOException {
  // action(HomeController.Views.HOME,HomeController.Actions.HOME);
  // return Views.ARTICLES;
  // }

  @RequestMapping(value = Actions.SAVE_ARTICLE, method = RequestMethod.POST)
  public String registration(@Valid @ModelAttribute ArticleForm registrationForm,
      BindingResult result, Model model) {

    if (result.hasErrors()) {
      return Views.EDIT_ARTICLE;
    }

    return "redirect:" + Actions.ARTICLES;
  }

  public interface Actions {
    public static final String ARTICLES = "/article/list";
    public static final String NEW_ARTICLE = "/article/new";
    public static final String SAVE_ARTICLE = "/article/save";
  }

  public interface Views {
    public static final String ARTICLES = "pages/articles";
    public static final String EDIT_ARTICLE = "pages/article/edit";
  }



}
