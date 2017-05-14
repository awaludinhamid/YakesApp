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
 *
 * @author awal
 * @created Apr 19, 2017
 */
@Entity
@Table(name="MASTER_TINDAKAN")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterTindakan extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="TINDAKAN_ID")
  private int tindakanId;
  @Column(name="TINDAKAN_CODE")
  private String tindakanCode;
  @Column(name="TINDAKAN_DESC")
  private String tindakanDesc;
  @Column(name="TINDAKAN_COST")
  private Double tindakanCost;

  /**
   * @return the tindakanId
   */
  public int getTindakanId() {
    return tindakanId;
  }

  /**
   * @param tindakanId the tindakanId to set
   */
  public void setTindakanId(int tindakanId) {
    this.tindakanId = tindakanId;
  }

  /**
   * @return the tindakanCode
   */
  public String getTindakanCode() {
    return tindakanCode;
  }

  /**
   * @param tindakanCode the tindakanCode to set
   */
  public void setTindakanCode(String tindakanCode) {
    this.tindakanCode = tindakanCode;
  }

  /**
   * @return the tindakanDesc
   */
  public String getTindakanDesc() {
    return tindakanDesc;
  }

  /**
   * @param tindakanDesc the tindakanDesc to set
   */
  public void setTindakanDesc(String tindakanDesc) {
    this.tindakanDesc = tindakanDesc;
  }

  /**
   * @return the tindakanCost
   */
  public Double getTindakanCost() {
    return tindakanCost;
  }

  /**
   * @param tindakanCost the tindakanCost to set
   */
  public void setTindakanCost(Double tindakanCost) {
    this.tindakanCost = tindakanCost;
  }

}
