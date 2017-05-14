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
import javax.persistence.Table;

/**
 * @created Feb 12, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_PARAMETER")
public class MasterParameter extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="PARAMETER_ID")
  private int parameterId;
  @Column(name="PARAMETER_CODE")
  private String parameterCode;
  @Column(name="PARAMETER_NAME")
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
