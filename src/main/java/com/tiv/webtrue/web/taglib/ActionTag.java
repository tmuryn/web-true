package com.tiv.webtrue.web.taglib;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

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

    String url = null;

    if (hashMap != null) {
      Set<Map.Entry<String, String>> entries = map.entrySet();
      url = hashMap.get(action);

      if (url != null) {

        for (Map.Entry<String, String> entry : entries) {
          url = url.replaceAll("\\{" + entry.getKey() + "\\}", entry.getValue());
        }
        
        url = getHttpServletRequest().getContextPath() + url;

      } else {
        url = getHttpServletRequest().getContextPath() + "/" + action;
      }

    } else {
      url = getHttpServletRequest().getContextPath() + "/" + action;
    }

    JspWriter out = getJspContext().getOut();
    out.println(url);

    super.doTag();
  }

  private HttpServletRequest getHttpServletRequest() {
    return (HttpServletRequest) ((PageContext) getJspContext()).getRequest();
  }

  @Override
  public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
    map.put(localName, String.valueOf(value));

  }


}
