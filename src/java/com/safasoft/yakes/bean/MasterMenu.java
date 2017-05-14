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
 * @created Feb 14, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_MENU")
public class MasterMenu extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="MENU_ID")
  private int menuId;
  @Column(name="MENU_NAME")
  private String menuName;
  @Column(name="MENU_CODE")
  private String menuCode;
  @Column(name="MENU_PAGE")
  private String menuPage;
  @Column(name="SORT")
  private int sort;
  @Column(name="ICON_PATH")
  private String iconPath;
  @ManyToOne
  @JoinColumn(name="PARENT_MENU_ID")
  private MasterParentMenu parentMenu;
  

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
   * @return the parentMenu
   */
  public MasterParentMenu getParentMenu() {
    return parentMenu;
  }

  /**
   * @param parentMenu the parentMenu to set
   */
  public void setParentMenu(MasterParentMenu parentMenu) {
    this.parentMenu = parentMenu;
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
}
