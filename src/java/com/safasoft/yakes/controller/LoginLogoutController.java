/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.controller;

import com.safasoft.yakes.bean.MasterUser;
import com.safasoft.yakes.service.MasterUserService;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Login controller
 * @created Jun 19, 2015
 * @author awal
 */

/**
 * Handles and retrieves the login or denied page depending on the URI template
 */
@Controller
@RequestMapping("/auth")
public class LoginLogoutController {
  
  @Autowired
  private MasterUserService muServ;

 private final Logger logger = Logger.getLogger("controller");

 /**
  * Handles and retrieves the login JSP page
  *
  * @param error
  * @param model
  * @return the name of the JSP page
  */
 @RequestMapping(value = "/login", method = RequestMethod.GET)
 public String getLoginPage(@RequestParam(value="error", required=false) boolean error,
   ModelMap model) {
  logger.debug("Received request to show login page");
  
  //we need logged user forward to default target url when he tried to login again
  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  if (!(auth instanceof AnonymousAuthenticationToken)) {
    return "redirect:/apps/main/validation";
    //return "welcomepage";  
  }

  // Add an error message to the model if login is unsuccessful
  // The 'error' parameter is set to true based on the when the authentication has failed.
  // We declared this under the authentication-failure-url attribute inside the spring-security.xml
  /* See below:
   <form-login
    login-page="/apps/auth/login"
    authentication-failure-url="/apps/auth/login?error=true"
    default-target-url="/apps/main/home"/>
   */
  if (error == true) {
   // Assign an error message
   model.put("error", "You have entered an invalid username, password or company code!");
  } else {
    model.put("error", "");
  }

  // This will resolve to /jsp/loginpage.jsp
  return "loginpage";
 }

 /**
  * Handles and retrieves the denied JSP page. This is shown whenever user tries to access the unauthorized page.
  *
  * @return the name of the JSP page
  */
 @RequestMapping(value = "/denied", method = RequestMethod.GET)
  public String getDeniedPage() {
  logger.debug("Received request to show denied page");

  // This will resolve to /jsp/deniedpage.jsp
  return "deniedpage";
 }

 /**
  * Process change password
  *
   * @param userId
   * @param request
   * @return 
  */
 @RequestMapping(value = "/password/{userId}", method = RequestMethod.POST)
  public String changePassword(@PathVariable("userId") int userId, HttpServletRequest request) {
    logger.debug("Received request to change password");
    //
    MasterUser mu = muServ.getById(userId);
    logger.info(request.getParameter("new-password"));
    mu.setUserPassword(request.getParameter("new-password"));
    muServ.save(mu);
    return "redirect:" + request.getHeader("Referer");
  }
  
  @RequestMapping(value = "/currentsession", method = RequestMethod.GET)
  public @ResponseBody String getCurrentSession(HttpServletRequest httpRequest) {
    logger.debug("Received request to get current session");
    return httpRequest.getSession().getId();
  }

}
