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

/**
 *
 * @author awal
 * @created Apr 12, 2017
 */
public class TransReimburseDTO extends RecordAuditBeanDTO {

  private int reimburseId;
  @Temporal(TemporalType.DATE)
  private Date reimburseDate;
  @Temporal(TemporalType.DATE)
  private Date reimburseTransDate;
  private String reimburseDesc;
  private int pesertaId;

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
}
