/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.bean.dto;

import com.safasoft.yakes.bean.dto.support.RecordAuditBeanDTO;

/**
 * @created Feb 12, 2017
 * @author awal
 */
public class MasterParameterDetDTO extends RecordAuditBeanDTO {

  private int parameterDetId;
  private String parameterDetCode;
  private String parameterDetName;
  private int parameterId;

  /**
   * @return the parameterDetId
   */
  public int getParameterDetId() {
    return parameterDetId;
  }

  /**
   * @param parameterDetId the parameterDetId to set
   */
  public void setParameterDetId(int parameterDetId) {
    this.parameterDetId = parameterDetId;
  }

  /**
   * @return the parameterDetCode
   */
  public String getParameterDetCode() {
    return parameterDetCode;
  }

  /**
   * @param parameterDetCode the parameterDetCode to set
   */
  public void setParameterDetCode(String parameterDetCode) {
    this.parameterDetCode = parameterDetCode;
  }

  /**
   * @return the parameterDetName
   */
  public String getParameterDetName() {
    return parameterDetName;
  }

  /**
   * @param parameterDetName the parameterDetName to set
   */
  public void setParameterDetName(String parameterDetName) {
    this.parameterDetName = parameterDetName;
  }

  /**
   * @return the parameterId
   */
  public int getParameterId() {
    return parameterId;
  }

  /**
   * @param parameterId the parameterId to set
   */
  public void setParameterId(int parameterId) {
    this.parameterId = parameterId;
  }
}
