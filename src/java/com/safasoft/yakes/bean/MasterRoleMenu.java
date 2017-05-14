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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @created Feb 16, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_ROLE_MENU")
public class MasterRoleMenu extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ROLE_MENU_ID")
  private int roleMenuId;
  @ManyToOne
  @JoinColumn(name="ROLE_ID")
  private MasterRole role;
  @ManyToOne
  @JoinColumn(name="MENU_ID")
  private MasterMenu menu;  

  /**
   * @return the roleMenuId
   */
  public int getRoleMenuId() {
    return roleMenuId;
  }

  /**
   * @param roleMenuId the roleMenuId to set
   */
  public void setRoleMenuId(int roleMenuId) {
    this.roleMenuId = roleMenuId;
  }

  /**
   * @return the role
   */
  public MasterRole getRole() {
    return role;
  }

  /**
   * @param role the role to set
   */
  public void setRole(MasterRole role) {
    this.role = role;
  }

  /**
   * @return the menu
   */
  public MasterMenu getMenu() {
    return menu;
  }

  /**
   * @param menu the menu to set
   */
  public void setMenu(MasterMenu menu) {
    this.menu = menu;
  }
}
