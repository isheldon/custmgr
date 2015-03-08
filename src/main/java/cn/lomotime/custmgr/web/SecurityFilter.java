package cn.lomotime.custmgr.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import cn.lomotime.custmgr.domain.User;

public class SecurityFilter implements Filter {
  private static Logger logger = Logger.getLogger(SecurityFilter.class);

  @Override
  public void destroy() { }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp,
      FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest)req;   
    HttpServletResponse response  =(HttpServletResponse) resp;    
    
    String path = request.getRequestURI();
    if (path.contains("login") ||
        path.contains("logout") ||
        path.contains("doLogin") ||
        path.contains(".css") ||
        path.contains(".js") ||
        path.contains(".jpg") ||
        path.contains(".gif") ||
        path.contains(".png")
        ) {
      chain.doFilter(req, resp);
    } else {
      String ctx = request.getContextPath();
      HttpSession session = request.getSession(false);     
      if (session == null) {
        response.sendRedirect(ctx + "/login");
      } else {
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
          response.sendRedirect(ctx + "/login");
        } else {
          checkRole(user.getRole(), path);
          chain.doFilter(req, resp);
        }
      }
    }

  }

  @Override
  public void init(FilterConfig arg0) throws ServletException { }

  private void checkRole(String role, String path) {
    logger.debug("role: " + role + ", path: " + path);
    if ("MANAGER".equals(role) &&
        !path.contains("/index") &&
        !path.contains("/selfcustomers") &&
        !path.contains("/subcustomers") &&
        !path.contains("/customer/new") &&
        !path.contains("/customer/create") &&
        !path.contains("/memohistory") &&
        !path.contains("/password") &&
        !path.contains("/chgpwd") &&
        !path.contains("/customer/edit") &&
        !path.contains("/customer/update") &&
        !path.contains("/customer/delete")
        ) {
      throw new RuntimeException("NO_PERMISSION");
    }
    if ("SALES".equals(role) &&
        !path.contains("/index") &&
        !path.contains("/selfcustomers") &&
        !path.contains("/customer/new") &&
        !path.contains("/customer/create") &&
        !path.contains("/password") &&
        !path.contains("/chgpwd") &&
        !path.contains("/customer/edit") &&
        !path.contains("/customer/update") &&
        !path.contains("/customer/delete")
        ) {
      throw new RuntimeException("NO_PERMISSION");
    }
  }

}
