/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.bean;

import com.safasoft.yakes.bean.support.RecordAuditBean;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author awal
 * @created Apr 11, 2017
 */
@Entity
@Table(name="TRANS_REIMBURSE")
@SuppressWarnings("PersistenceUnitPresent")
public class TransReimburse extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="REIMBURSE_ID")
  private int reimburseId;
  @Column(name="REIMBURSE_DATE")
  @Temporal(TemporalType.DATE)
  private Date reimburseDate;
  @Column(name="REIMBURSE_TRANS_DATE")
  @Temporal(TemporalType.DATE)
  private Date reimburseTransDate;
  @Column(name="REIMBURSE_DESC")
  private String reimburseDesc;
  @ManyToOne
  @JoinColumn(name="PESERTA_ID")
  private MasterPeserta peserta;

  /**
   * @return the reimburseId
   */
  public int getReimburseId() {
    return reimburseId;
  }

  /**
   * @param reimburseId the reimburseId to set
   */
  public void setReimburseId(int reimburseId) {
    this.reimburseId = reimburseId;
  }

  /**
   * @return the reimburseDate
   */
  public Date getReimburseDate() {
    return reimburseDate;
  }

  /**
   * @param reimburseDate the reimburseDate to set
   */
  public void setReimburseDate(Date reimburseDate) {
    this.reimburseDate = reimburseDate;
  }

  /**
   * @return the reimburseTransDate
   */
  public Date getReimburseTransDate() {
    return reimburseTransDate;
  }

  /**
   * @param reimburseTransDate the reimburseTransDate to set
   */
  public void setReimburseTransDate(Date reimburseTransDate) {
    this.reimburseTransDate = reimburseTransDate;
  }

  /**
   * @return the reimburseDesc
   */
  public String getReimburseDesc() {
    return reimburseDesc;
  }

  /**
   * @param reimburseDesc the reimburseDesc to set
   */
  public void setReimburseDesc(String reimburseDesc) {
    this.reimburseDesc = reimburseDesc;
  }

  /**
   * @return the peserta
   */
  public MasterPeserta getPeserta() {
    return peserta;
  }

  /**
   * @param peserta the peserta to set
   */
  public void setPeserta(MasterPeserta peserta) {
    this.peserta = peserta;
  }

}
