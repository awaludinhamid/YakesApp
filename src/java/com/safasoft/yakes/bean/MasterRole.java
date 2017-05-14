/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.bean;

import com.safasoft.yakes.bean.support.RecordAuditBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @created Feb 09, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_ROLE")
public class MasterRole extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ROLE_ID")
  private int roleId;
  @Column(name="ROLE_CODE")
  private String roleCode;
  @Column(name="ROLE_NAME")
  private String roleName;
  @Column(name="ROLE_LEVEL")
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
