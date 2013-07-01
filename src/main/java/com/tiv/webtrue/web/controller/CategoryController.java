package com.tiv.webtrue.web.controller;

import com.tiv.webtrue.core.service.CategoryService;
import com.tiv.webtrue.web.model.CategoryModel;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.tiv.webtrue.core.utils.MapperUtils.map;

@Controller
@RequestMapping("/category")
public class CategoryController extends NavigationController {

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private Mapper mapper;

  @RequestMapping(value = Actions.ALL, method = RequestMethod.GET)
  public String getAll(Model model) {
    action(HomeController.Views.HOME, HomeController.Actions.HOME);

    model.addAttribute("categories", map(mapper, categoryService.getAll(), CategoryModel.class));
    return Views.ARTICLES;
  }

  public interface Actions{
    public static final String ALL = "/all";
  }

  public interface Views{
    public static final String ARTICLES = "pages/articles";
  }
}
