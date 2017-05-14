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
 *
 * @author awal
 * @created Apr 2, 2017
 */
@Entity
@Table(name="MASTER_COA")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterCoa extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="COA_ID")
  private int coaId;
  @Column(name="COA_LOCAL_CODE")
  private String coaLocalCode;
  @Column(name="COA_GOV_CODE")
  private String coaGovCode;
  @Column(name="COA_NAME")
  private String coaName;
  @Column(name="COA_DESC")
  private String coaDesc;
  @ManyToOne
  @JoinColumn(name="COA_PARENT_ID")
  private MasterCoa coaParent;

  /**
   * @return the coaId
   */
  public int getCoaId() {
    return coaId;
  }

  /**
   * @param coaId the coaId to set
   */
  public void setCoaId(int coaId) {
    this.coaId = coaId;
  }

  /**
   * @return the coaLocalCode
   */
  public String getCoaLocalCode() {
    return coaLocalCode;
  }

  /**
   * @param coaLocalCode the coaLocalCode to set
   */
  public void setCoaLocalCode(String coaLocalCode) {
    this.coaLocalCode = coaLocalCode;
  }

  /**
   * @return the coaGovCode
   */
  public String getCoaGovCode() {
    return coaGovCode;
  }

  /**
   * @param coaGovCode the coaGovCode to set
   */
  public void setCoaGovCode(String coaGovCode) {
    this.coaGovCode = coaGovCode;
  }

  /**
   * @return the coaName
   */
  public String getCoaName() {
    return coaName;
  }

  /**
   * @param coaName the coaName to set
   */
  public void setCoaName(String coaName) {
    this.coaName = coaName;
  }

  /**
   * @return the coaDesc
   */
  public String getCoaDesc() {
    return coaDesc;
  }

  /**
   * @param coaDesc the coaDesc to set
   */
  public void setCoaDesc(String coaDesc) {
    this.coaDesc = coaDesc;
  }

  /**
   * @return the coaParent
   */
  public MasterCoa getCoaParent() {
    return coaParent;
  }

  /**
   * @param coaParent the coaParent to set
   */
  public void setCoaParent(MasterCoa coaParent) {
    this.coaParent = coaParent;
  }
}
