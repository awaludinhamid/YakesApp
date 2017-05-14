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
 * @created Feb 4, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_USER")
public class MasterUser extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="USER_ID")
  private int userId;
  @Column(name="USER_CODE")
  private String userCode;
  @Column(name="USER_NAME")
  private String userName;
  @Column(name="USER_PASSWORD")
  private String userPassword; 

  /**
   * @return the userId
   */
  public int getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(int userId) {
    this.userId = userId;
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the userPassword
   */
  public String getUserPassword() {
    return userPassword;
  }

  /**
   * @param userPassword the userPassword to set
   */
  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }
  
  /**
   * @return the userCode
   */
  public String getUserCode() {
    return userCode;
  }

  /**
   * @param userCode the userCode to set
   */
  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }
}
