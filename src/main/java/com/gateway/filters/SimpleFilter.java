package com.gateway.filters;



import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SimpleFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);
  @Autowired
  private HttpServletRequest rq;
  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
	  RequestContext ctx = RequestContext.getCurrentContext();
	  String header = rq.getHeader("Authorization");
      ctx.addZuulRequestHeader("Authorization", header);
    return null;
  }

}
