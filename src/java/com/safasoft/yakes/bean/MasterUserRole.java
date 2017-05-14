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
 * @created Feb 09, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_USER_ROLE")
public class MasterUserRole extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="USER_ROLE_ID")
  private int userRoleId;
  @ManyToOne
  @JoinColumn(name="ROLE_ID")
  private MasterRole role;
  @ManyToOne
  @JoinColumn(name="USER_ID")
  private MasterUser user;

  /**
   * @return the userRoleId
   */
  public int getUserRoleId() {
    return userRoleId;
  }

  /**
   * @param userRoleId the userRoleId to set
   */
  public void setUserRoleId(int userRoleId) {
    this.userRoleId = userRoleId;
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
   * @return the user
   */
  public MasterUser getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(MasterUser user) {
    this.user = user;
  }
}
