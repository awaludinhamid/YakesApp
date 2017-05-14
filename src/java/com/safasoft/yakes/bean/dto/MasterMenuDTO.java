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
public class MasterMenuDTO extends RecordAuditBeanDTO {  

  private int menuId;
  private String menuCode;
  private String menuName;
  private String menuPage;
  private int sort;
  private String iconPath;
  private int parentMenuId;

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

  /**
   * @return the menuName
   */
  public String getMenuName() {
    return menuName;
  }

  /**
   * @param menuName the menuName to set
   */
  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  /**
   * @return the menuCode
   */
  public String getMenuCode() {
    return menuCode;
  }

  /**
   * @param menuCode the menuCode to set
   */
  public void setMenuCode(String menuCode) {
    this.menuCode = menuCode;
  }

  /**
   * @return the menuPage
   */
  public String getMenuPage() {
    return menuPage;
  }

  /**
   * @param menuPage the menuPage to set
   */
  public void setMenuPage(String menuPage) {
    this.menuPage = menuPage;
  }

  /**
   * @return the sort
   */
  public int getSort() {
    return sort;
  }

  /**
   * @param sort the sort to set
   */
  public void setSort(int sort) {
    this.sort = sort;
  }

  /**
   * @return the iconPath
   */
  public String getIconPath() {
    return iconPath;
  }

  /**
   * @param iconPath the iconPath to set
   */
  public void setIconPath(String iconPath) {
    this.iconPath = iconPath;
  }

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
}
