/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.bean.dto;

import com.safasoft.yakes.bean.dto.support.RecordAuditBeanDTO;

/**
 *
 * @author awal
 * @created Apr 3, 2017
 */
public class MasterCoaDTO extends RecordAuditBeanDTO {

  private int coaId;
  private String coaLocalCode;
  private String coaGovCode;
  private String coaName;
  private String coaDesc;
  private int coaParentId;

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
   * @return the coaParentId
   */
  public int getCoaParentId() {
    return coaParentId;
  }

  /**
   * @param coaParentId the coaParentId to set
   */
  public void setCoaParentId(int coaParentId) {
    this.coaParentId = coaParentId;
  }
}
