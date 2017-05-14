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
 * @created Mar 25, 2017
 */
public class MasterCustomerDTO extends RecordAuditBeanDTO {

  private int customerId;
  private String polisNo;
  private String polisHolder;
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date polisIssueDate;
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date polisCloseDate;
  private String isValidReimburse;
  private Integer golonganId;

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

  /**
   * @return the polisNo
   */
  public String getPolisNo() {
    return polisNo;
  }

  /**
   * @param polisNo the polisNo to set
   */
  public void setPolisNo(String polisNo) {
    this.polisNo = polisNo;
  }

  /**
   * @return the polisHolder
   */
  public String getPolisHolder() {
    return polisHolder;
  }

  /**
   * @param polisHolder the polisHolder to set
   */
  public void setPolisHolder(String polisHolder) {
    this.polisHolder = polisHolder;
  }

  /**
   * @return the polisIssueDate
   */
  public Date getPolisIssueDate() {
    return polisIssueDate;
  }

  /**
   * @param polisIssueDate the polisIssueDate to set
   */
  public void setPolisIssueDate(Date polisIssueDate) {
    this.polisIssueDate = polisIssueDate;
  }

  /**
   * @return the polisCloseDate
   */
  public Date getPolisCloseDate() {
    return polisCloseDate;
  }

  /**
   * @param polisCloseDate the polisCloseDate to set
   */
  public void setPolisCloseDate(Date polisCloseDate) {
    this.polisCloseDate = polisCloseDate;
  }

  /**
   * @return the isValidReimburse
   */
  public String getIsValidReimburse() {
    return isValidReimburse;
  }

  /**
   * @param isValidReimburse the isValidReimburse to set
   */
  public void setIsValidReimburse(String isValidReimburse) {
    this.isValidReimburse = isValidReimburse;
  }

  /**
   * @return the golonganId
   */
  public Integer getGolonganId() {
    return golonganId;
  }

  /**
   * @param golonganId the golonganId to set
   */
  public void setGolonganId(Integer golonganId) {
    this.golonganId = golonganId;
  }
}
