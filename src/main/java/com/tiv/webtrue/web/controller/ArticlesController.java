package com.tiv.webtrue.web.controller;


import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tiv.webtrue.core.service.ArticleSearchQuery;
import com.tiv.webtrue.core.service.ArticleSearchQuery.Type;
import com.tiv.webtrue.core.service.ArticleService;
import com.tiv.webtrue.dao.dto.ArticleDTO;

@Controller
public final class ArticlesController extends NavigationController {

  private static final int ITEMS_PER_PAGE = 12;
  @Autowired
  private ArticleService articleService;


  @RequestMapping(value = Actions.ARTICLES, method = RequestMethod.GET)
  public String articles(ModelMap map){
    return articles(map,Type.Author.name(), 1);
  }
  
  @RequestMapping(value = Actions.ARTICLES_TYPE, method = RequestMethod.GET)
  public String articles(ModelMap map, @PathVariable String type){
    return articles(map, type, 1);
  }

  @RequestMapping(value = Actions.ARTICLES_FULL, method = RequestMethod.GET)
  public String articles(ModelMap map, @PathVariable String type,
      @PathVariable int page) {
    
    action(HomeController.Views.HOME, HomeController.Actions.HOME);
    action("signin", UserController.Actions.SIGNIN);
    action("articlesfull", Actions.ARTICLES_FULL);
    action("articlestype", Actions.ARTICLES_TYPE);
    
    map.addAttribute("topic", "articles");

    Collection<ArticleDTO> articles = Collections.emptyList();
    ArticleSearchQuery query = new ArticleSearchQuery();
    query.setFirstResult((page - 1) * ITEMS_PER_PAGE);
    query.setMaximumResults(ITEMS_PER_PAGE);
    Type queryType = Type.getByName(type);


    if (queryType == null || queryType.equals(Type.Author)) {
      if (SecurityContextHolder.getContext().getAuthentication() != null && getCurrentAccount()!=null) {
        query.setAccountId(getCurrentAccount().getId());
        query.setType(Type.Author);
        articles = articleService.getArticles(query);
      } else {
        articles = articleService.getArticles(query);
      }
    } else {
      query.setType(queryType);
      articles = articleService.getArticles(query);
    }

    map.addAttribute("articles", articles);
    map.addAttribute("artyiclesType", query.getType().name());
    map.addAttribute("page", page);
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
  public String save(@Valid @ModelAttribute ArticleForm registrationForm, BindingResult result,
      Model model) {

    if (result.hasErrors()) {
      return Views.EDIT_ARTICLE;
    }

    ArticleDTO articleDTO = new ArticleDTO();
    articleDTO.setTitle(registrationForm.getTitle());
    articleDTO.setText(registrationForm.getText());
    articleDTO.setAccountId(getCurrentAccount().getId());
    articleDTO.setPublished(registrationForm.isPublish());
    articleDTO.setUpdateDate(new Date());

    articleService.save(articleDTO);

    return postRedirectGet(formatUrl(Actions.ARTICLES, "type", "articlemy"));
  }

  public interface Actions {
    public static final String ARTICLES = "/article/list";
    public static final String ARTICLES_TYPE = "/article/list/{type}";
    public static final String ARTICLES_FULL = "/article/list/{type}/{page}";
    public static final String NEW_ARTICLE = "/article/new";
    public static final String SAVE_ARTICLE = "/article/save";
  }

  public interface Views {
    public static final String ARTICLES = "pages/articles";
    public static final String EDIT_ARTICLE = "pages/article/edit";
  }



}
