/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.auth;

import com.safasoft.yakes.bean.MasterUser;
import com.safasoft.yakes.service.MasterUserRoleService;
import com.safasoft.yakes.service.MasterUserService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * To do action when user have logged successfully
 * Currently used to create user session info and record user login
 * @created Feb 09, 2017
 * @author awal
 */
@Component("customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler { // SavedRequestAwareAuthenticationSuccessHandler
 
  private final Logger authLogger = Logger.getLogger("auth");
  
  @Autowired
  private MasterUserService muServ;
  @Autowired
  private MasterUserRoleService murServ;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
          throws IOException, ServletException {    
    authLogger.info("set login info");
    //login info 
    HttpSession session = request.getSession();
    String userName = (String) session.getAttribute("userName");
    if(userName == null || userName.equals("")) {        
      String name = auth.getName();
      MasterUser mstUser = muServ.getByCode(name);
      session.setAttribute("realName", mstUser.getUserName());
      session.setAttribute("userId", mstUser.getUserId());
      session.setAttribute("userName", name);
      session.setAttribute("sessionId", session.getId());
      session.setAttribute("hasRole", murServ.getByUser(mstUser.getUserId()) == null ? "no" : "yes");
      session.setAttribute("pagingRecords", GlobalIntVariable.PAGING_RECORDS.getVar());
    }
    //redirect
    setDefaultTargetUrl("/apps/main/validation");
    super.onAuthenticationSuccess(request, response, auth);
  }
}
