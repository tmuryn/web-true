package com.tiv.webtrue.web.taglib;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.tiv.webtrue.web.controller.ArticlesController;
import com.tiv.webtrue.web.controller.NavigationController;

public class ActionTag extends SimpleTagSupport implements DynamicAttributes {

  private String action;

  private Map<String, String> map = new HashMap<String, String>();

  public void setAction(String action) {
    this.action = action.trim();
  }

  @Override
  public void doTag() throws JspException, IOException {
    
    
    @SuppressWarnings("unchecked")
    HashMap<String, String> hashMap =
        (HashMap<String, String>) getJspContext().findAttribute(NavigationController.ACTIONS);
    
    Set<Map.Entry<String, String>> entries = map.entrySet();
    String url = hashMap.get(action);
    
    if (url != null) {
      
      for (Map.Entry<String, String> entry : entries) {
        url = url.replaceAll("\\{"+entry.getKey()+"\\}", entry.getValue());
      }
      
    }else{
      url = "Invalid Url. Please specify correct url for action : "+action;
    }
    
    JspWriter out = getJspContext().getOut();
    out.println(url);
    
    super.doTag();
  }

  @Override
  public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
    map.put(localName, String.valueOf(value));

  }


}
