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
@Table(name="TRANS_REIMBURSE_DET")
@SuppressWarnings("PersistenceUnitPresent")
public class TransReimburseDet extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="REIMBURSE_DET_ID")
  private int reimburseDetId;
  @Column(name="IS_EMERGENCY")
  private String isEmergency;
  @Column(name="IS_ADMIN_FEE")
  private String isAdminFee;
  @Column(name="ADMIN_FEE_REV")
  private Double adminFeeRev;
  @ManyToOne
  @JoinColumn(name="DOCTOR_TYPE_ID")
  private MasterParameterDet doctorType;
  @ManyToOne
  @JoinColumn(name="REIMBURSE_ID")
  private TransReimburse reimburse;

  /**
   * @return the reimburseDetId
   */
  public int getReimburseDetId() {
    return reimburseDetId;
  }

  /**
   * @param reimburseDetId the reimburseDetId to set
   */
  public void setReimburseDetId(int reimburseDetId) {
    this.reimburseDetId = reimburseDetId;
  }

  /**
   * @return the isEmergency
   */
  public String getIsEmergency() {
    return isEmergency;
  }

  /**
   * @param isEmergency the isEmergency to set
   */
  public void setIsEmergency(String isEmergency) {
    this.isEmergency = isEmergency;
  }

  /**
   * @return the isAdminFee
   */
  public String getIsAdminFee() {
    return isAdminFee;
  }

  /**
   * @param isAdminFee the isAdminFee to set
   */
  public void setIsAdminFee(String isAdminFee) {
    this.isAdminFee = isAdminFee;
  }

  /**
   * @return the adminFeeRev
   */
  public Double getAdminFeeRev() {
    return adminFeeRev;
  }

  /**
   * @param adminFeeRev the adminFeeRev to set
   */
  public void setAdminFeeRev(Double adminFeeRev) {
    this.adminFeeRev = adminFeeRev;
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

  /**
   * @return the doctorType
   */
  public MasterParameterDet getDoctorType() {
    return doctorType;
  }

  /**
   * @param doctorType the doctorType to set
   */
  public void setDoctorType(MasterParameterDet doctorType) {
    this.doctorType = doctorType;
  }
}
