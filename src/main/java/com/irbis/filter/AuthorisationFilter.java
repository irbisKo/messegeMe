package com.irbis.filter;

import com.irbis.common.LoginBean;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
//@WebFilter("/user")
public class AuthorisationFilter implements Filter {

    public AuthorisationFilter() {
    }




    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        /**
         * checks if user is logged in. If not it redirects to the login.xhtml page.
         */

        LoginBean loginBean = (LoginBean) ((HttpServletRequest) request).getSession().getAttribute("LoginBean");
        // For the first application request there is no LoginBean in the session so user needs to log in
        // For other requests LoginBean is present but we need to check if user has logged in successfully
        if (loginBean == null || !loginBean.isLoggedIn()) {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + "/logIn.xhtml");
        }
        chain.doFilter(request, response);
    }


/*
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
try{
 HttpServletRequest reqt = (HttpServletRequest) request;
 HttpServletResponse resp = (HttpServletResponse) response;
 HttpSession ses = reqt.getSession(false);


 String reqURI =reqt.getRequestURI();
 //ses.setAttribute("logBean", user);
 if (reqURI.indexOf("/logIn.xhtml") >= 0
         ||  reqURI.indexOf("/signUp.xhtml") >=0

//his will always create a new HttpSession always because you have passed in the parameter 'true', if you pass in 'false'(which is also the default)
//an HttpSession will be created only once when the page is requested and no new sessions will be created and your filter can capture the correct user information.

         || (ses != null && ses.getAttribute("LoginBean") != null)

         || reqURI.contains("javax.faces.resource"))

  chain.doFilter(request, response);
 else if((ses.getAttribute("LoginBean")== null) && (!reqURI.contains(".faces"))){
  resp.sendRedirect("Page1.faces");
 }
 else

  resp.sendRedirect(reqt.getContextPath() + "/welcome.xhtml");
} catch (Exception e) {
 System.out.println(e.getMessage());
}
 }
*/


    public void destroy() {

    }
}
