/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.controller;

import com.safasoft.yakes.bean.MasterCoa;
import com.safasoft.yakes.bean.MasterCustomer;
import com.safasoft.yakes.bean.MasterGolongan;
import com.safasoft.yakes.bean.MasterMenu;
import com.safasoft.yakes.bean.MasterObat;
import com.safasoft.yakes.bean.MasterParameterDet;
import com.safasoft.yakes.bean.MasterPeserta;
import com.safasoft.yakes.bean.MasterRole;
import com.safasoft.yakes.bean.MasterRoleMenu;
import com.safasoft.yakes.bean.MasterRumahSakit;
import com.safasoft.yakes.bean.MasterUser;
import com.safasoft.yakes.bean.MasterUserRole;
import com.safasoft.yakes.bean.TransReimburse;
import com.safasoft.yakes.bean.dto.MasterCoaDTO;
import com.safasoft.yakes.bean.dto.MasterCustomerDTO;
import com.safasoft.yakes.bean.dto.MasterGolonganDTO;
import com.safasoft.yakes.bean.dto.MasterMenuDTO;
import com.safasoft.yakes.bean.dto.MasterObatDTO;
import com.safasoft.yakes.bean.dto.MasterPesertaDTO;
import com.safasoft.yakes.bean.dto.MasterRoleDTO;
import com.safasoft.yakes.bean.dto.MasterRoleMenuDTO;
import com.safasoft.yakes.bean.dto.MasterRumahSakitDTO;
import com.safasoft.yakes.bean.dto.MasterUserDTO;
import com.safasoft.yakes.bean.dto.MasterUserRoleDTO;
import com.safasoft.yakes.bean.dto.TransReimburseDTO;
import com.safasoft.yakes.service.MasterCoaService;
import com.safasoft.yakes.service.MasterCustomerService;
import com.safasoft.yakes.service.MasterGolonganService;
import com.safasoft.yakes.service.MasterMenuService;
import com.safasoft.yakes.service.MasterObatService;
import com.safasoft.yakes.service.MasterParameterDetService;
import com.safasoft.yakes.service.MasterParentMenuService;
import com.safasoft.yakes.service.MasterPesertaService;
import com.safasoft.yakes.service.MasterRoleMenuService;
import com.safasoft.yakes.service.MasterRoleService;
import com.safasoft.yakes.service.MasterRumahSakitService;
import com.safasoft.yakes.service.MasterUserRoleService;
import com.safasoft.yakes.service.MasterUserService;
import com.safasoft.yakes.service.TransReimburseService;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @created Feb 23, 2017
 * @author awal
 */
@Controller
@RequestMapping("/save")
public class SaveController {
    
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
  private MasterUserRoleService murServ;
  @Autowired
  private MasterUserService muServ;
 @Autowired
 private TransReimburseService trServ;

  private final Logger logger = Logger.getLogger("controller");

  @RequestMapping(value = "/menu", method = RequestMethod.POST)
  public @ResponseBody MasterMenuDTO saveMenu(
          @RequestBody MasterMenuDTO menuDTO,
          HttpSession session
          )
  {
    logger.info("request to save menu");
    //
    String username = (String) session.getAttribute("userName");
    if(menuDTO.getMenuId() == 0) {
      menuDTO.setCreatedBy(username);
    }
    menuDTO.setUpdatedBy(username);
    MasterMenu menu = new MasterMenu();
    BeanUtils.copyProperties(menuDTO, menu);
    menu.setParentMenu(mpmServ.getById(menuDTO.getParentMenuId()));
    mmServ.save(menu);
    return menuDTO;
  }

  @RequestMapping(value = "/role", method = RequestMethod.POST)
  public @ResponseBody MasterRoleDTO saveRole(
          @RequestBody MasterRoleDTO roleDTO,
          HttpSession session
          )
  {
    logger.info("request to save role");
    //
    String username = (String) session.getAttribute("userName");
    if(roleDTO.getRoleId() == 0) {
      roleDTO.setCreatedBy(username);
    } 
    roleDTO.setUpdatedBy(username);
    MasterRole role = new MasterRole();
    BeanUtils.copyProperties(roleDTO, role);
    mrServ.save(role);
    return roleDTO;
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public @ResponseBody MasterUserDTO saveUser(
          @RequestBody MasterUserDTO userDTO,
          HttpSession session
          )
  {
    logger.info("request to save user");
    //
    String username = (String) session.getAttribute("userName");
    if(userDTO.getUserId() == 0) {
      userDTO.setCreatedBy(username);  
    }
    userDTO.setUpdatedBy(username);
    MasterUser user = new MasterUser();
    BeanUtils.copyProperties(userDTO, user);
    muServ.save(user);
    return userDTO;
  }

  @RequestMapping(value = "/userrole", method = RequestMethod.POST)
  public @ResponseBody MasterUserRoleDTO saveUserRole(
          @RequestBody MasterUserRoleDTO userRoleDTO,
          HttpSession session
          )
  {
    logger.info("request to save user role");
    //
    String username = (String) session.getAttribute("userName");
    if(userRoleDTO.getUserRoleId() == 0) {
      userRoleDTO.setCreatedBy(username);      
    }
    userRoleDTO.setUpdatedBy(username);
    MasterUserRole userRole = new MasterUserRole();
    BeanUtils.copyProperties(userRoleDTO, userRole);
    userRole.setUser(muServ.getById(userRoleDTO.getUserId()));
    userRole.setRole(mrServ.getById(userRoleDTO.getRoleId()));
    murServ.save(userRole);
    return userRoleDTO;
  }

  @RequestMapping(value = "/rolemenu", method = RequestMethod.POST)
  public @ResponseBody MasterRoleMenuDTO saveRoleMenu(
          @RequestBody MasterRoleMenuDTO roleMenuDTO,
          HttpSession session
          )
  {
    logger.info("request to save role menu");
    //
    String username = (String) session.getAttribute("userName");
    if(roleMenuDTO.getRoleMenuId() == 0) {
      roleMenuDTO.setCreatedBy(username);      
    }
    roleMenuDTO.setUpdatedBy(username);
    MasterRoleMenu roleMenu = new MasterRoleMenu();
    BeanUtils.copyProperties(roleMenuDTO, roleMenu);
    roleMenu.setRole(mrServ.getById(roleMenuDTO.getRoleId()));
    roleMenu.setMenu(mmServ.getById(roleMenuDTO.getMenuId()));
    mrmServ.save(roleMenu);
    return roleMenuDTO;
  }

  @RequestMapping(value = "/golongan", method = RequestMethod.POST)
  public @ResponseBody MasterGolonganDTO saveGolongan(
          @RequestBody MasterGolonganDTO golonganDTO,
          HttpSession session
          )
  {
    logger.info("request to save golongan");
    //
    String username = (String) session.getAttribute("userName");
    if(golonganDTO.getGolonganId() == 0) {
      golonganDTO.setCreatedBy(username);      
    }
    golonganDTO.setUpdatedBy(username);
    MasterGolongan golongan = new MasterGolongan();
    BeanUtils.copyProperties(golonganDTO, golongan);
    mgServ.save(golongan);
    return golonganDTO;
  }

  @RequestMapping(value = "/customer", method = RequestMethod.POST)
  public @ResponseBody MasterCustomerDTO saveCustomer(
          @RequestBody MasterCustomerDTO customerDTO,
          HttpSession session
          )
  {
    logger.info("request to save customer");
    //
    String username = (String) session.getAttribute("userName");
    if(customerDTO.getCustomerId() == 0) {
      customerDTO.setCreatedBy(username);      
    }
    customerDTO.setUpdatedBy(username);
    MasterCustomer customer = new MasterCustomer();
    BeanUtils.copyProperties(customerDTO, customer);
    customer.setGolongan(mgServ.getById(customerDTO.getGolonganId()));
    mcServ.save(customer);
    return customerDTO;
  }

  @RequestMapping(value = "/peserta", method = RequestMethod.POST)
  public @ResponseBody MasterPesertaDTO savePeserta(
          @RequestBody MasterPesertaDTO pesertaDTO,
          HttpSession session
          )
  {
    logger.info("request to save peserta");
    //
    String username = (String) session.getAttribute("userName");
    if(pesertaDTO.getCustomerId() == 0) {
      pesertaDTO.setCreatedBy(username);      
    }
    pesertaDTO.setUpdatedBy(username);
    MasterPeserta peserta = new MasterPeserta();
    BeanUtils.copyProperties(pesertaDTO, peserta);
    peserta.setCustomer(mcServ.getById(pesertaDTO.getCustomerId()));
    //
    MasterParameterDet mpd = mpdServ.getById(pesertaDTO.getEducationId());
    if(mpd != null)
      peserta.setEducation(mpd);
    mpd = mpdServ.getById(pesertaDTO.getIdentityTypeId());
    if(mpd != null)
      peserta.setIdentityType(mpd);
    mpd = mpdServ.getById(pesertaDTO.getMaritalStatusId());
    if(mpd != null)
      peserta.setMaritalStatus(mpd);
    mpd = mpdServ.getById(pesertaDTO.getPolisHolderRelationId());
    if(mpd != null)
      peserta.setPolisHolderRelation(mpd);
    //
    mpsServ.save(peserta);
    return pesertaDTO;
  }

  @RequestMapping(value = "/obat", method = RequestMethod.POST)
  public @ResponseBody MasterObatDTO saveObat(
          @RequestBody MasterObatDTO obatDTO,
          HttpSession session
          )
  {
    logger.info("request to save obat");
    //
    String username = (String) session.getAttribute("userName");
    if(obatDTO.getObatId() == 0) {
      obatDTO.setCreatedBy(username);      
    }
    obatDTO.setUpdatedBy(username);
    MasterObat obat = new MasterObat();
    BeanUtils.copyProperties(obatDTO, obat);
    obat.setObatUnit(mpdServ.getById(obatDTO.getObatUnitId()));
    moServ.save(obat);
    return obatDTO;
  }

  @RequestMapping(value = "/coa", method = RequestMethod.POST)
  public @ResponseBody MasterCoaDTO saveCoa(
          @RequestBody MasterCoaDTO coaDTO,
          HttpSession session
          )
  {
    logger.info("request to save coa");
    //
    String username = (String) session.getAttribute("userName");
    if(coaDTO.getCoaId() == 0) {
      coaDTO.setCreatedBy(username);      
    }
    coaDTO.setUpdatedBy(username);
    MasterCoa coa = new MasterCoa();
    BeanUtils.copyProperties(coaDTO, coa);
    coa.setCoaParent(mcoServ.getById(coaDTO.getCoaParentId()));
    mcoServ.save(coa);
    return  coaDTO;
  }

  @RequestMapping(value = "/rumahsakit", method = RequestMethod.POST)
  public @ResponseBody MasterRumahSakitDTO saveRumahSakit(
          @RequestBody MasterRumahSakitDTO rsDTO,
          HttpSession session
          )
  {
    logger.info("request to save rumah sakit");
    //
    String username = (String) session.getAttribute("userName");
    if(rsDTO.getRumahSakitId() == 0) {
      rsDTO.setCreatedBy(username);      
    }
    rsDTO.setUpdatedBy(username);
    MasterRumahSakit rs = new MasterRumahSakit();
    BeanUtils.copyProperties(rsDTO, rs);
    mrsServ.save(rs);
    return  rsDTO;
  }

  @RequestMapping(value = "/reimburse", method = RequestMethod.POST)
  public @ResponseBody TransReimburseDTO saveReimburse(
          @RequestBody TransReimburseDTO reimDTO,
          HttpSession session
          )
  {
    logger.info("request to save reimburse");
    //
    String username = (String) session.getAttribute("userName");
    if(reimDTO.getReimburseId() == 0) {
      reimDTO.setCreatedBy(username);      
    }
    reimDTO.setUpdatedBy(username);
    TransReimburse reim = new TransReimburse();
    BeanUtils.copyProperties(reimDTO, reim);
    trServ.save(reim);
    return  reimDTO;
  }
}
