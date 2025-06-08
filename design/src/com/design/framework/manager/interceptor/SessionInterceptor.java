package com.design.framework.manager.interceptor;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter
{
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception
  {
    HttpSession session = request.getSession();
    if (session.getAttribute("session_manager") == null)
    {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      out.write("<script type='text/javascript'>");
      out.write("alert('您还没有登录,请登录后访问系统');");

      out.write("window.top.location.href='" + request.getContextPath() + "/sys/login';");
      out.write("</script>");
      out.flush();
      out.close();

      return false;
    }
    return true;
  }
}