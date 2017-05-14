/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.bean.dto;

import com.safasoft.yakes.bean.dto.support.RecordAuditBeanDTO;


/**
 * @created Feb 18, 2017
 * @author awal
 */
public class MasterUserDTO extends RecordAuditBeanDTO {

  private int userId;
  private String userCode;
  private String userName;
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
  
}
