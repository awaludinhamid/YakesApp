/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.bean.dto;

import com.safasoft.yakes.bean.dto.support.RecordAuditBeanDTO;


/**
 * @created Feb 17, 2017
 * @author awal
 */
public class MasterRoleDTO extends RecordAuditBeanDTO {

  private int roleId;
  private String roleCode;
  private String roleName;
  private int roleLevel;

  /**
   * @return the roleId
   */
  public int getRoleId() {
    return roleId;
  }

  /**
   * @param roleId the roleId to set
   */
  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  /**
   * @return the roleCode
   */
  public String getRoleCode() {
    return roleCode;
  }

  /**
   * @param roleCode the roleCode to set
   */
  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode;
  }

  /**
   * @return the roleName
   */
  public String getRoleName() {
    return roleName;
  }

  /**
   * @param roleName the roleName to set
   */
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  /**
   * @return the roleLevel
   */
  public int getRoleLevel() {
    return roleLevel;
  }

  /**
   * @param roleLevel the roleLevel to set
   */
  public void setRoleLevel(int roleLevel) {
    this.roleLevel = roleLevel;
  }
}
