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
 * @created Feb 14, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_PARENT_MENU")
public class MasterParentMenu extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="PARENT_MENU_ID")
  private int parentMenuId;
  @Column(name="PARENT_MENU_NAME")
  private String parentMenuName;
  @Column(name="PARENT_MENU_CODE")
  private String parentMenuCode;

  /**
   * @return the parentMenuId
   */
  public int getParentMenuId() {
    return parentMenuId;
  }

  /**
   * @param parentMenuId the parentMenuId to set
   */
  public void setParentMenuId(int parentMenuId) {
    this.parentMenuId = parentMenuId;
  }

  /**
   * @return the parentMenuName
   */
  public String getParentMenuName() {
    return parentMenuName;
  }

  /**
   * @param parentMenuName the parentMenuName to set
   */
  public void setParentMenuName(String parentMenuName) {
    this.parentMenuName = parentMenuName;
  }

  /**
   * @return the parentMenuCode
   */
  public String getParentMenuCode() {
    return parentMenuCode;
  }

  /**
   * @param parentMenuCode the parentMenuCode to set
   */
  public void setParentMenuCode(String parentMenuCode) {
    this.parentMenuCode = parentMenuCode;
  }
}
