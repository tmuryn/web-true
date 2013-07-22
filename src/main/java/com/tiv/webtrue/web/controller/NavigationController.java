package com.tiv.webtrue.web.controller;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * Base class for exception handling.
 * 
 * @author dmytro.plekhotkin
 * 
 */
public class NavigationController {

  public static final String ACTIONS =
      "com_tic_webtrue_web_exception_GlobalExceptionHandler_ACTIONS";
  private static final String REDIRECT_FORMAT = "redirect:/backend/%s";

  @Autowired
  private HttpServletRequest request;
  
  @Autowired
  protected Mapper mapper;

  /**
   * Slf4j logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(NavigationController.class);


  protected void action(String action, String link) {
    action(request, action, link);
  }

  public static void action(HttpServletRequest r, String action, String link) {
    Map<String, String> actions = (Map<String, String>) r.getAttribute(ACTIONS);
    if (actions == null) {
      actions = new HashMap<String, String>();
    }
    actions.put(action,link);
    r.setAttribute(ACTIONS, actions);
  }

  public static String formatUrl(String action, String toReplace, Long replaceBy) {
    return formatUrl(action, toReplace, replaceBy.toString());
  }

  public static String formatUrl(String action, String toReplace, String replaceBy) {
    return action.replace(toReplace, replaceBy);
  }


  public static String postRedirectGet(String redirectTo) {
    return String.format(REDIRECT_FORMAT, redirectTo);
  }

}
