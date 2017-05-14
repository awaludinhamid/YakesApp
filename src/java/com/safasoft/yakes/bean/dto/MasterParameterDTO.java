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
public class MasterParameterDTO extends RecordAuditBeanDTO {

  private int parameterId;
  private String parameterCode;
  private String parameterName;

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

  /**
   * @return the parameterCode
   */
  public String getParameterCode() {
    return parameterCode;
  }

  /**
   * @param parameterCode the parameterCode to set
   */
  public void setParameterCode(String parameterCode) {
    this.parameterCode = parameterCode;
  }

  /**
   * @return the parameterName
   */
  public String getParameterName() {
    return parameterName;
  }

  /**
   * @param parameterName the parameterName to set
   */
  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }
}
