/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Application controller
 * Handles and retrieves various page depending on the URI template.
 * A user must be log-in first he can access these pages.
 * Specific page can be accessed by specific user, however.
 * @created Feb 19, 2017
 * @author awal
 */
@Controller
@RequestMapping("/application")
public class ApplicationController {

  private final Logger logger = Logger.getLogger("controller");


  /**
    * Handles and retrieves the menu JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/menu", method = RequestMethod.GET)
  public String getMenuPage() {
    logger.debug("Received request to show menu page");
    // This will resolve to /jsp/application/menupage.jsp
    return "application/menupage";
  }

  /**
    * Handles and retrieves the role JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/role", method = RequestMethod.GET)
  public String getRolePage() {
    logger.debug("Received request to show role page");
    // This will resolve to /jsp/application/rolepage.jsp
    return "application/rolepage";
  }

  /**
    * Handles and retrieves the user JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public String getUserPage() {
    logger.debug("Received request to show user page");
    // This will resolve to /jsp/application/userpage.jsp
    return "application/userpage";
  }

  /**
    * Handles and retrieves the user role JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/userrole", method = RequestMethod.GET)
  public String getUserRolePage() {
    logger.debug("Received request to show user role page");
    // This will resolve to /jsp/application/userrolepage.jsp
    return "application/userrolepage";
  }

  /**
    * Handles and retrieves the role menu JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/rolemenu", method = RequestMethod.GET)
  public String getRoleMenuPage() {
    logger.debug("Received request to show role menu page");
    // This will resolve to /jsp/application/rolemenupage.jsp
    return "application/rolemenupage";
  }

  /**
    * Handles and retrieves the golongan JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/golongan", method = RequestMethod.GET)
  public String getGolonganPage() {
    logger.debug("Received request to show golongan page");
    // This will resolve to /jsp/application/golonganpage.jsp
    return "application/golonganpage";
  }

  /**
    * Handles and retrieves the customer JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/customer", method = RequestMethod.GET)
  public String getCustomerPage() {
    logger.debug("Received request to show customer page");
    // This will resolve to /jsp/application/customerpage.jsp
    return "application/customerpage";
  }

  /**
    * Handles and retrieves the peserta JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/peserta", method = RequestMethod.GET)
  public String getPesertaPage() {
    logger.debug("Received request to show peserta page");
    // This will resolve to /jsp/application/pesertapage.jsp
    return "application/pesertapage";
  }

  /**
    * Handles and retrieves the obat JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/obat", method = RequestMethod.GET)
  public String getObatPage() {
    logger.debug("Received request to show obat page");
    // This will resolve to /jsp/application/obatpage.jsp
    return "application/obatpage";
  }

  /**
    * Handles and retrieves the coa JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/coa", method = RequestMethod.GET)
  public String getCoaPage() {
    logger.debug("Received request to show coa page");
    // This will resolve to /jsp/application/coapage.jsp
    return "application/coapage";
  }

  /**
    * Handles and retrieves the rumah sakit JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/rumahsakit", method = RequestMethod.GET)
  public String getRumahSakitPage() {
    logger.debug("Received request to show rumahsakit page");
    // This will resolve to /jsp/application/rumahsakitpage.jsp
    return "application/rumahsakitpage";
  }

  /**
    * Handles and retrieves the reimburse JSP page
    *
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/reimburse", method = RequestMethod.GET)
  public String getReimbursePage() {
    logger.debug("Received request to show reimburse page");
    // This will resolve to /jsp/application/reimbursepage.jsp
    return "application/reimbursepage";
  }

  /**
    * Handles and retrieves the summary JSP page
    *
    * @param httpRequest
    * @param principal
    * @return the name of the JSP page
    */
  @RequestMapping(value = "/summary", method = RequestMethod.GET)
  public String getSummaryPage(HttpServletRequest httpRequest, Principal principal) {
    logger.debug("Received request to show summary page");
    // This will resolve to /jsp/application/summarypage.jsp
    return "application/summarypage";
  }
    
}
