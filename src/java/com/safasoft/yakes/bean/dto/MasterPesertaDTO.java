/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.bean.dto;

import com.safasoft.yakes.bean.dto.support.RecordAuditBeanDTO;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author awal
 * @created Mar 26, 2017
 */
public class MasterPesertaDTO extends RecordAuditBeanDTO {

  private int pesertaId;
  private String pesertaNo;
  private String pesertaName;
  private Integer identityTypeId;
  private String identityNo;
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern="yyyy-mm-dd")
  private Date birthOfDate;
  private String placeOfBirth;
  private Integer maritalStatusId;
  private Integer polisHolderRelationId;
  private Integer educationId;
  private int customerId;

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
   * @return the identityTypeId
   */
  public Integer getIdentityTypeId() {
    return identityTypeId;
  }

  /**
   * @param identityTypeId the identityTypeId to set
   */
  public void setIdentityTypeId(Integer identityTypeId) {
    this.identityTypeId = identityTypeId;
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
   * @return the maritalStatusId
   */
  public Integer getMaritalStatusId() {
    return maritalStatusId;
  }

  /**
   * @param maritalStatusId the maritalStatusId to set
   */
  public void setMaritalStatusId(Integer maritalStatusId) {
    this.maritalStatusId = maritalStatusId;
  }

  /**
   * @return the polisHolderRelationId
   */
  public Integer getPolisHolderRelationId() {
    return polisHolderRelationId;
  }

  /**
   * @param polisHolderRelationId the polisHolderRelationId to set
   */
  public void setPolisHolderRelationId(Integer polisHolderRelationId) {
    this.polisHolderRelationId = polisHolderRelationId;
  }

  /**
   * @return the educationId
   */
  public Integer getEducationId() {
    return educationId;
  }

  /**
   * @param educationId the educationId to set
   */
  public void setEducationId(Integer educationId) {
    this.educationId = educationId;
  }

  /**
   * @return the customerId
   */
  public int getCustomerId() {
    return customerId;
  }

  /**
   * @param customerId the customerId to set
   */
  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }
}
