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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @created Feb 12, 2017
 * @author awal
 */
@Entity
@Table(name="MASTER_PARAMETER_DET")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterParameterDet extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="PARAMETER_DET_ID")
  private int parameterDetId;
  @Column(name="PARAMETER_DET_CODE")
  private String parameterDetCode;
  @Column(name="PARAMETER_DET_NAME")
  private String parameterDetName;
  @ManyToOne
  @JoinColumn(name="PARAMETER_ID")
  private MasterParameter parameter;

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
   * @return the parameter
   */
  public MasterParameter getParameter() {
    return parameter;
  }

  /**
   * @param parameter the parameter to set
   */
  public void setParameter(MasterParameter parameter) {
    this.parameter = parameter;
  }
}
