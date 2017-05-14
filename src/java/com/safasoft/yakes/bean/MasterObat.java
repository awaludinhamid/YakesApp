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
 *
 * @author awal
 * @created Mar 26, 2017
 */
@Entity
@Table(name="MASTER_OBAT")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterObat extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="OBAT_ID")
  private int obatId;
  @Column(name="OBAT_CODE")
  private String obatCode;
  @Column(name="OBAT_NAME")
  private String obatName;
  @Column(name="OBAT_DESC")
  private String obatDesc;
  @Column(name="OBAT_PRICE")
  private Double obatPrice;
  @ManyToOne
  @JoinColumn(name="OBAT_UNIT_ID")
  private MasterParameterDet obatUnit;

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
   * @return the obatUnit
   */
  public MasterParameterDet getObatUnit() {
    return obatUnit;
  }

  /**
   * @param obatUnit the obatUnit to set
   */
  public void setObatUnit(MasterParameterDet obatUnit) {
    this.obatUnit = obatUnit;
  }
}
