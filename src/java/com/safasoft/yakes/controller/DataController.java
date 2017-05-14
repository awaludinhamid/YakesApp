/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.controller;

import com.safasoft.yakes.bean.MasterCoa;
import com.safasoft.yakes.bean.MasterCustomer;
import com.safasoft.yakes.bean.MasterGolongan;
import com.safasoft.yakes.bean.MasterMenu;
import com.safasoft.yakes.bean.MasterObat;
import com.safasoft.yakes.bean.MasterParameter;
import com.safasoft.yakes.bean.MasterParentMenu;
import com.safasoft.yakes.bean.MasterPeserta;
import com.safasoft.yakes.bean.MasterRole;
import com.safasoft.yakes.bean.MasterTindakan;
import com.safasoft.yakes.bean.MasterUser;
import com.safasoft.yakes.service.MasterCoaService;
import com.safasoft.yakes.service.MasterCustomerService;
import com.safasoft.yakes.service.MasterGolonganService;
import com.safasoft.yakes.service.MasterMenuService;
import com.safasoft.yakes.service.MasterObatService;
import com.safasoft.yakes.service.MasterParameterDetService;
import com.safasoft.yakes.service.MasterParameterService;
import com.safasoft.yakes.service.MasterParentMenuService;
import com.safasoft.yakes.service.MasterPesertaService;
import com.safasoft.yakes.service.MasterRoleMenuService;
import com.safasoft.yakes.service.MasterRoleService;
import com.safasoft.yakes.service.MasterRumahSakitService;
import com.safasoft.yakes.service.MasterTindakanService;
import com.safasoft.yakes.service.MasterUserRoleService;
import com.safasoft.yakes.service.MasterUserService;
import com.safasoft.yakes.service.TransReimburseService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Data controller, requested via AJAX
 * Handles and retrieves the data page depending on the URI template
 * A user must be log-in first he can access these pages
 * @created Feb 19, 2017
 * @author awal
 */
@Controller
@RequestMapping("/data")
public class DataController {

 private final Logger logger = Logger.getLogger("controller");
 private final String basicDate = "2000-01-01";
 private final String basicEndDate = "2999-12-31";
 
 //        
 @Autowired
 private MasterCoaService mcoServ;         
 @Autowired
 private MasterCustomerService mcServ; 
 @Autowired
 private MasterGolonganService mgServ;
 @Autowired
 private MasterMenuService mmServ;
 @Autowired
 private MasterObatService moServ;
 @Autowired
 private MasterParameterDetService mpdServ;
 @Autowired
 private MasterParameterService mpServ;
 @Autowired
 private MasterParentMenuService mpmServ;   
 @Autowired
 private MasterPesertaService mpsServ;   
 @Autowired
 private MasterRoleMenuService mrmServ;
 @Autowired
 private MasterRoleService mrServ;
 @Autowired
 private MasterRumahSakitService mrsServ;
 @Autowired
 private MasterTindakanService mtServ;
 @Autowired
 private MasterUserRoleService murServ;
 @Autowired
 private MasterUserService muServ;
 @Autowired
 private TransReimburseService trServ;

 /**
  * Generate all parent menus data
  *
  * @return json data
  */
    @RequestMapping(value = "/parentmenu", method = RequestMethod.GET)
    public @ResponseBody List<MasterParentMenu> getAllParentMenu() {
     logger.debug("Received request to get all parent menus data");
     //retrieve all parent menus
     return mpmServ.getAll();
 }

 /**
  * Generate all menus data
  *
  * @return json data
  */
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public @ResponseBody List<MasterMenu> getAllMenu() {
     logger.debug("Received request to get all menus data");
     //retrieve all menus
     return mmServ.getAll();
 }

 /**
  * Generate all menus data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/menu/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getMenus(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get menus data");
      //
      String inputFind = httpRequest.getParameter("inputFind");
      Map<String,Object> mapMenu = new HashMap();
      //
      if(inputFind == null || inputFind.equals("")) {
        mapMenu.put("content", mmServ.getByPage(pageNo));
        mapMenu.put("count", mmServ.count());        
      } else {
        mapMenu.put("content", mmServ.getByPageInputFind(inputFind,pageNo));
        mapMenu.put("count", mmServ.countByInputFind(inputFind));
      }
      return mapMenu;
 }

 /**
  * Generate all roles data
  *
  * @return json data
  */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public @ResponseBody List<MasterRole> getAllRoles() {
      logger.debug("Received request to get all roles data");
      // 
      return mrServ.getAll();
 }

 /**
  * Generate all roles data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/role/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getRoles(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get roles data");
      //
      String inputFind = httpRequest.getParameter("inputFind");
      Map<String,Object> mapRole = new HashMap();
      //
      if(inputFind == null || inputFind.equals("")) {
        mapRole.put("content", mrServ.getByPage(pageNo));
        mapRole.put("count", mrServ.count());
      } else {
        mapRole.put("content", mrServ.getByPageInputFind(inputFind,pageNo));
        mapRole.put("count", mrServ.countByInputFind(inputFind));
      }
      return mapRole;
 }

 /**
  * Generate all roles data
  *
  * @return json data
  */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody List<MasterUser> getAllUsers() {
      logger.debug("Received request to get all users data");
      // 
      return muServ.getAll();
 }

 /**
  * Generate all users data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/user/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getUsersByCompany(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all users data");
      //
      String inputFind = httpRequest.getParameter("inputFind");
      Map<String,Object> mapUser = new HashMap();
      //
      if(inputFind == null || inputFind.equals("")) {
        mapUser.put("content", muServ.getByPage(pageNo));
        mapUser.put("count", muServ.count());
      } else {
        mapUser.put("content", muServ.getByPageInputFind(inputFind,pageNo));
        mapUser.put("count", muServ.countByInputFind(inputFind));
      }
      return mapUser;
 }

 /**
  * Generate all user role data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/userrole/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getUserRoles(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all user role data");
      //
      String inputFind = httpRequest.getParameter("inputFind");
      Map<String,Object> mapUserRole = new HashMap();
      //
      if(inputFind == null || inputFind.equals("")) {
        mapUserRole.put("content", murServ.getByPage(pageNo));
        mapUserRole.put("count", murServ.count());
      } else {
        mapUserRole.put("content", murServ.getByPageInputFind(inputFind,pageNo));
        mapUserRole.put("count", murServ.countByInputFind(inputFind));
      }
      return mapUserRole;
 }

 /**
  * Generate user menu data
  *
   * @param userId
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/usermenu/{userId}", method = RequestMethod.GET)
    public @ResponseBody List<MasterMenu> getUserMenus(@PathVariable("userId") int userId, HttpServletRequest httpRequest) {
     logger.debug("Received request to get user menu data");
     //retrieve user menu
     return mmServ.getListMenuByUserId(userId);
 }

 /**
  * Generate all role menu data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/rolemenu/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getRoleMenus(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all user role data");
      //
      String inputFind = httpRequest.getParameter("inputFind");
      Map<String,Object> mapRoleMenu = new HashMap();
      //
      if(inputFind == null || inputFind.equals("")) {
        mapRoleMenu.put("content", mrmServ.getByPage(pageNo));
        mapRoleMenu.put("count", mrmServ.count());
      } else {
        mapRoleMenu.put("content", mrmServ.getByPageInputFind(inputFind,pageNo));
        mapRoleMenu.put("count", mrmServ.countByInputFind(inputFind));
      }
      return mapRoleMenu;
 }

 /**
  * Generate all parameters data
  *
  * @return json data
  */
    @RequestMapping(value = "/parameter", method = RequestMethod.GET)
    public @ResponseBody List<MasterParameter> getAllParameters() {
      logger.debug("Received request to get all parameters data");
      // 
      return mpServ.getAll();
 }

 /**
  * Generate all parameters data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/parameter/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getParameters(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all parameters data");
      //
      String inputFind = httpRequest.getParameter("inputFind");
      Map<String,Object> mapParam = new HashMap();
      //
      if(inputFind == null || inputFind.equals("")) {
        mapParam.put("content", mpServ.getByPage(pageNo));
        mapParam.put("count", mpServ.count());
      } else {
        mapParam.put("content", mpServ.getByPageInputFind(inputFind,pageNo));
        mapParam.put("count", mpServ.countByInputFind(inputFind));
      }
      return mapParam;
 }

 /**
  * Generate all golongan data
  *
  * @return json data
  */
    @RequestMapping(value = "/golongan", method = RequestMethod.GET)
    public @ResponseBody List<MasterGolongan> getAllGolongan() {
      logger.debug("Received request to get all golongan data");
      // 
      return mgServ.getAll();
 }

 /**
  * Generate all golongan data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/golongan/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getGolongan(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all golongan data");
      //
      String inputFind = httpRequest.getParameter("inputFind");
      Map<String,Object> mapGol = new HashMap();
      //
      if(inputFind == null || inputFind.equals("")) {
        mapGol.put("content", mgServ.getByPage(pageNo));
        mapGol.put("count", mgServ.count());
      } else {
        mapGol.put("content", mgServ.getByPageInputFind(inputFind,pageNo));
        mapGol.put("count", mgServ.countByInputFind(inputFind));
      }
      return mapGol;
 }

 /**
  * Generate all customer data
  *
  * @return json data
  */
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public @ResponseBody List<MasterCustomer> getAllCustomer() {
      logger.debug("Received request to get all customer data");
      // 
      return mcServ.getAll();
 }

 /**
  * Generate all customer data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/customer/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getCustomer(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all customer data");
      //
      String inputFind = httpRequest.getParameter("inputFind");
      Map<String,Object> mapCust = new HashMap();
      //
      if(inputFind == null || inputFind.equals("")) {
        mapCust.put("content", mcServ.getByPage(pageNo));
        mapCust.put("count", mcServ.count());
      } else {
        mapCust.put("content", mcServ.getByPageInputFind(inputFind,pageNo));
        mapCust.put("count", mcServ.countByInputFind(inputFind));
      }
      return mapCust;
 }

 /**
  * Generate all peserta data
  *
  * @return json data
  */
    @RequestMapping(value = "/peserta", method = RequestMethod.GET)
    public @ResponseBody List<MasterPeserta> getAllPeserta() {
      logger.debug("Received request to get all peserta data");
      // 
      return mpsServ.getAll();
 }

 /**
  * Generate all peserta data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/peserta/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getPeserta(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all peserta data");
      //
      String inputFind = httpRequest.getParameter("inputFind");
      Map<String,Object> mapPes = new HashMap();
      //
      if(inputFind == null || inputFind.equals("")) {
        mapPes.put("content", mpsServ.getByPage(pageNo));
        mapPes.put("count", mpsServ.count());
      } else {
        mapPes.put("content", mpsServ.getByPageInputFind(inputFind,pageNo));
        mapPes.put("count", mpsServ.countByInputFind(inputFind));
      }
      return mapPes;
 }

 /**
  * Generate all obat data
  *
  * @return json data
  */
    @RequestMapping(value = "/obat", method = RequestMethod.GET)
    public @ResponseBody List<MasterObat> getAllObat() {
      logger.debug("Received request to get all obatdata");
      // 
      return moServ.getAll();
 }

 /**
  * Generate all obat data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/obat/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getObat(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all obat data");
      //
      String inputFind = httpRequest.getParameter("inputFind");
      Map<String,Object> mapObat = new HashMap();
      //
      if(inputFind == null || inputFind.equals("")) {
        mapObat.put("content", moServ.getByPage(pageNo));
        mapObat.put("count", moServ.count());
      } else {
        mapObat.put("content", moServ.getByPageInputFind(inputFind,pageNo));
        mapObat.put("count", moServ.countByInputFind(inputFind));
      }
      return mapObat;
 }

 /**
  * Generate all coa data
  *
  * @return json data
  */
    @RequestMapping(value = "/coa", method = RequestMethod.GET)
    public @ResponseBody List<MasterCoa> getAllCoa() {
      logger.debug("Received request to get all coa data");
      // 
      return mcoServ.getAll();
 }

 /**
  * Generate all coa data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/coa/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getCoa(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all coa data");
      //
      String inputFind = httpRequest.getParameter("inputFind");
      Map<String,Object> mapCoa = new HashMap();
      //
      if(inputFind == null || inputFind.equals("")) {
        mapCoa.put("content", mcoServ.getByPage(pageNo));
        mapCoa.put("count", mcoServ.count());
      } else {
        mapCoa.put("content", mcoServ.getByPageInputFind(inputFind,pageNo));
        mapCoa.put("count", mcoServ.countByInputFind(inputFind));
      }
      return mapCoa;
 }

 /**
  * Generate all rumah sakit data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/rumahsakit/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getRumahSakit(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all rumah sakit data");
      //
      String inputFind = httpRequest.getParameter("inputFind");
      Map<String,Object> mapRs = new HashMap();
      //
      if(inputFind == null || inputFind.equals("")) {
        mapRs.put("content", mrsServ.getByPage(pageNo));
        mapRs.put("count", mrsServ.count());
      } else {
        mapRs.put("content", mrsServ.getByPageInputFind(inputFind,pageNo));
        mapRs.put("count", mrsServ.countByInputFind(inputFind));
      }
      return mapRs;
 }

 /**
  * Generate all reimburse data by page
  *
   * @param pageNo
  * @param httpRequest
  * @return json data
  */
    @RequestMapping(value = "/reimburse/{pageNo}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getReimburse(@PathVariable("pageNo") int pageNo, HttpServletRequest httpRequest) {
      logger.debug("Received request to get all reimburse data");
      //
      String inputFind = httpRequest.getParameter("inputFind");
      String startDate = emptyToValue(httpRequest.getParameter("startDate"),basicDate);
      String endDate = emptyToValue(httpRequest.getParameter("endDate"),basicEndDate);
      Map<String,Object> mapReim = new HashMap();
      //
      if((inputFind == null || inputFind.equals("")) && startDate.equals(basicDate) && endDate.equals(basicEndDate)) {
        mapReim.put("content", trServ.getByPage(pageNo));
        mapReim.put("count", trServ.count());
      } else {
        mapReim.put("content", trServ.getByPageInputFindAndDate(inputFind,startDate,endDate,pageNo));
        mapReim.put("count", trServ.countByInputFindAndDate(inputFind,startDate,endDate));
      }
      return mapReim;
 }

 /**
  * Generate all tindakan data
  *
  * @return json data
  */
    @RequestMapping(value = "/tindakan", method = RequestMethod.GET)
    public @ResponseBody List<MasterTindakan> getAllTindakan() {
      logger.debug("Received request to get all tindakan data");
      // 
      return mtServ.getAll();
 }
  
  @RequestMapping(value = "/currentsession", method = RequestMethod.GET)
  public @ResponseBody String getCurrentSession(HttpServletRequest httpRequest) {
    logger.debug("Received request to get current session");
    return httpRequest.getSession().getId();
  }
  
  private void setNoCache(HttpServletResponse httpResponse) {
    httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    httpResponse.setDateHeader("Expires", 0); // Proxies    
  }
  
  private String emptyToValue(String valueToBeChecked, String valueIfNull) {
    if(valueToBeChecked == null || valueToBeChecked.equals(""))
      return valueIfNull;
    return valueToBeChecked;
  }

}
