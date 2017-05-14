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
 * @created Mar 25, 2017
 */
@Entity
@Table(name="MASTER_CUSTOMER")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterCustomer extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="CUSTOMER_ID")
  private int customerId;
  @Column(name="POLIS_NO")
  private String polisNo;
  @Column(name="POLIS_HOLDER")
  private String polisHolder;
  @Column(name="POLIS_ISSUE_DATE")
  @Temporal(TemporalType.DATE)
  private Date polisIssueDate;
  @Column(name="POLIS_CLOSE_DATE")
  @Temporal(TemporalType.DATE)
  private Date polisCloseDate;
  @Column(name="IS_VALID_REIMBURSE")
  private String isValidReimburse;
  @ManyToOne
  @JoinColumn(name="GOLONGAN_ID")
  private MasterGolongan golongan;

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
   * @return the golongan
   */
  public MasterGolongan getGolongan() {
    return golongan;
  }

  /**
   * @param golongan the golongan to set
   */
  public void setGolongan(MasterGolongan golongan) {
    this.golongan = golongan;
  }
}
