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
 * @created Mar 26, 2017
 */
public class MasterObatDTO extends RecordAuditBeanDTO {

  private int obatId;
  private String obatCode;
  private String obatName;
  private String obatDesc;
  private Double obatPrice;
  private int obatUnitId;

  /**
   * @return the obatId
   */
  public int getObatId() {
    return obatId;
  }

  /**
   * @param obatId the obatId to set
   */
  public void setObatId(int obatId) {
    this.obatId = obatId;
  }

  /**
   * @return the obatCode
   */
  public String getObatCode() {
    return obatCode;
  }

  /**
   * @param obatCode the obatCode to set
   */
  public void setObatCode(String obatCode) {
    this.obatCode = obatCode;
  }

  /**
   * @return the obatName
   */
  public String getObatName() {
    return obatName;
  }

  /**
   * @param obatName the obatName to set
   */
  public void setObatName(String obatName) {
    this.obatName = obatName;
  }

  /**
   * @return the obatDesc
   */
  public String getObatDesc() {
    return obatDesc;
  }

  /**
   * @param obatDesc the obatDesc to set
   */
  public void setObatDesc(String obatDesc) {
    this.obatDesc = obatDesc;
  }

  /**
   * @return the obatPrice
   */
  public Double getObatPrice() {
    return obatPrice;
  }

  /**
   * @param obatPrice the obatPrice to set
   */
  public void setObatPrice(Double obatPrice) {
    this.obatPrice = obatPrice;
  }

  /**
   * @return the obatUnitId
   */
  public int getObatUnitId() {
    return obatUnitId;
  }

  /**
   * @param obatUnitId the obatUnitId to set
   */
  public void setObatUnitId(int obatUnitId) {
    this.obatUnitId = obatUnitId;
  }
}
