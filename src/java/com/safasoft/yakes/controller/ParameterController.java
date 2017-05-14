/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.controller;

import com.safasoft.yakes.bean.MasterParameterDet;
import com.safasoft.yakes.service.MasterParameterDetService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @created Feb 12, 2017
 * @author awal
 */
@Controller
@RequestMapping("/data")
public class ParameterController {

 private final Logger logger = Logger.getLogger("controller");  
 @Autowired
 private MasterParameterDetService mpdServ;

 /**
  * Generate all identity type data
  *
  * @return json data
  */
    @RequestMapping(value = "/parameter_identitytype", method = RequestMethod.GET)
    public @ResponseBody List<MasterParameterDet> getIdentityTipes() {
      logger.debug("Received request to get all identity type data");
      // 
      return mpdServ.getByParameterCode("IT");
 }

 /**
  * Generate all doctor type data
  *
  * @return json data
  */
    @RequestMapping(value = "/parameter_dokter", method = RequestMethod.GET)
    public @ResponseBody List<MasterParameterDet> getAllDoctorType() {
      logger.debug("Received request to get all doctor type data");
      // 
      return mpdServ.getByParameterCode("DT");
 }

 /**
  * Generate all marital status data
  *
  * @return json data
  */
    @RequestMapping(value = "/parameter_maritalstatus", method = RequestMethod.GET)
    public @ResponseBody List<MasterParameterDet> getMaritalStatus() {
      logger.debug("Received request to get all marital status data");
      // 
      return mpdServ.getByParameterCode("MS");
 }

 /**
  * Generate all polis holder relation data
  *
  * @return json data
  */
    @RequestMapping(value = "/parameter_polisholderrelation", method = RequestMethod.GET)
    public @ResponseBody List<MasterParameterDet> getPolisHolderRelation() {
      logger.debug("Received request to get all polis holder relation data");
      // 
      return mpdServ.getByParameterCode("PHR");
 }

 /**
  * Generate all education data
  *
  * @return json data
  */
    @RequestMapping(value = "/parameter_education", method = RequestMethod.GET)
    public @ResponseBody List<MasterParameterDet> getEducation() {
      logger.debug("Received request to get all education data");
      // 
      return mpdServ.getByParameterCode("ED");
 }

 /**
  * Generate all obat unit data
  *
  * @return json data
  */
    @RequestMapping(value = "/parameter_obatunit", method = RequestMethod.GET)
    public @ResponseBody List<MasterParameterDet> getObatUnit() {
      logger.debug("Received request to get all obat unit data");
      // 
      return mpdServ.getByParameterCode("OU");
 }
}
