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
 * @created Apr 19, 2017
 */
@Entity
@Table(name="TRANS_REIMBURSE_TINDAKAN")
@SuppressWarnings("PersistenceUnitPresent")
public class TransReimburseTindakan extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="REIMBURSE_TINDAKAN_ID")
  private int reimburseDetTindakanId;
  @Column(name="TINDAKAN_COST_REV")
  private Double tindakanCostRev;
  @ManyToOne
  @JoinColumn(name="REIMBURSE_ID")
  private TransReimburse reimburse;
  @ManyToOne
  @JoinColumn(name="TINDAKAN_ID")
  private MasterTindakan tindakan;

  /**
   * @return the reimburseDetTindakanId
   */
  public int getReimburseDetTindakanId() {
    return reimburseDetTindakanId;
  }

  /**
   * @param reimburseDetTindakanId the reimburseDetTindakanId to set
   */
  public void setReimburseDetTindakanId(int reimburseDetTindakanId) {
    this.reimburseDetTindakanId = reimburseDetTindakanId;
  }

  /**
   * @return the tindakanCostRev
   */
  public Double getTindakanCostRev() {
    return tindakanCostRev;
  }

  /**
   * @param tindakanCostRev the tindakanCostRev to set
   */
  public void setTindakanCostRev(Double tindakanCostRev) {
    this.tindakanCostRev = tindakanCostRev;
  }

  /**
   * @return the tindakan
   */
  public MasterTindakan getTindakan() {
    return tindakan;
  }

  /**
   * @param tindakan the tindakan to set
   */
  public void setTindakan(MasterTindakan tindakan) {
    this.tindakan = tindakan;
  }

  /**
   * @return the reimburse
   */
  public TransReimburse getReimburse() {
    return reimburse;
  }

  /**
   * @param reimburse the reimburse to set
   */
  public void setReimburse(TransReimburse reimburse) {
    this.reimburse = reimburse;
  }

}
