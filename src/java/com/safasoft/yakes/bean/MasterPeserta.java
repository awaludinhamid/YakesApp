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
 * @created Mar 26, 2017
 */
@Entity
@Table(name="MASTER_PESERTA")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterPeserta extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="PESERTA_ID")
  private int pesertaId;
  @Column(name="PESERTA_NO")
  private String pesertaNo;
  @Column(name="PESERTA_NAME")
  private String pesertaName;
  @Column(name="IDENTITY_NO")
  private String identityNo;
  @Column(name="BIRTH_OF_DATE")
  @Temporal(TemporalType.DATE)
  private Date birthOfDate;
  @Column(name="PLACE_OF_BIRTH")
  private String placeOfBirth;
  @ManyToOne
  @JoinColumn(name="CUSTOMER_ID")
  private MasterCustomer customer;
  @ManyToOne
  @JoinColumn(name="IDENTITY_TYPE_ID")
  private MasterParameterDet identityType;
  @ManyToOne
  @JoinColumn(name="MARITAL_STATUS_ID")
  private MasterParameterDet maritalStatus;
  @ManyToOne
  @JoinColumn(name="POLIS_HOLDER_RELATION_ID")
  private MasterParameterDet polisHolderRelation;
  @ManyToOne
  @JoinColumn(name="EDUCATION_ID")
  private MasterParameterDet education;

  /**
   * @return the pesertaId
   */
  public int getPesertaId() {
    return pesertaId;
  }

  /**
   * @param pesertaId the pesertaId to set
   */
  public void setPesertaId(int pesertaId) {
    this.pesertaId = pesertaId;
  }

  /**
   * @return the pesertaNo
   */
  public String getPesertaNo() {
    return pesertaNo;
  }

  /**
   * @param pesertaNo the pesertaNo to set
   */
  public void setPesertaNo(String pesertaNo) {
    this.pesertaNo = pesertaNo;
  }

  /**
   * @return the pesertaName
   */
  public String getPesertaName() {
    return pesertaName;
  }

  /**
   * @param pesertaName the pesertaName to set
   */
  public void setPesertaName(String pesertaName) {
    this.pesertaName = pesertaName;
  }

  /**
   * @return the identityNo
   */
  public String getIdentityNo() {
    return identityNo;
  }

  /**
   * @param identityNo the identityNo to set
   */
  public void setIdentityNo(String identityNo) {
    this.identityNo = identityNo;
  }

  /**
   * @return the birthOfDate
   */
  public Date getBirthOfDate() {
    return birthOfDate;
  }

  /**
   * @param birthOfDate the birthOfDate to set
   */
  public void setBirthOfDate(Date birthOfDate) {
    this.birthOfDate = birthOfDate;
  }

  /**
   * @return the placeOfBirth
   */
  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  /**
   * @param placeOfBirth the placeOfBirth to set
   */
  public void setPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }
  
  /**
   * @return the customer
   */
  public MasterCustomer getCustomer() {
    return customer;
  }

  /**
   * @param customer the customer to set
   */
  public void setCustomer(MasterCustomer customer) {
    this.customer = customer;
  }

  /**
   * @return the identityType
   */
  public MasterParameterDet getIdentityType() {
    return identityType;
  }

  /**
   * @param identityType the identityType to set
   */
  public void setIdentityType(MasterParameterDet identityType) {
    this.identityType = identityType;
  }

  /**
   * @return the maritalStatus
   */
  public MasterParameterDet getMaritalStatus() {
    return maritalStatus;
  }

  /**
   * @param maritalStatus the maritalStatus to set
   */
  public void setMaritalStatus(MasterParameterDet maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  /**
   * @return the polisHolderRelation
   */
  public MasterParameterDet getPolisHolderRelation() {
    return polisHolderRelation;
  }

  /**
   * @param polisHolderRelation the polisHolderRelation to set
   */
  public void setPolisHolderRelation(MasterParameterDet polisHolderRelation) {
    this.polisHolderRelation = polisHolderRelation;
  }

  /**
   * @return the education
   */
  public MasterParameterDet getEducation() {
    return education;
  }

  /**
   * @param education the education to set
   */
  public void setEducation(MasterParameterDet education) {
    this.education = education;
  }
}
