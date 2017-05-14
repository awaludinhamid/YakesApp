/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.bean.dto;

import com.safasoft.yakes.bean.dto.support.RecordAuditBeanDTO;


/**
 * @created Feb 26, 2017
 * @author awal
 */
public class MasterRoleMenuDTO extends RecordAuditBeanDTO {

  private int roleMenuId;
  private int roleId;
  private int menuId;  

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
   * @return the menuId
   */
  public int getMenuId() {
    return menuId;
  }

  /**
   * @param menuId the menuId to set
   */
  public void setMenuId(int menuId) {
    this.menuId = menuId;
  }
}
