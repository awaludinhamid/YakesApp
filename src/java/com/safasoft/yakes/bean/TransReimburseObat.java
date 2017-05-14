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
 * @created Apr 19, 2017
 */
@Entity
@Table(name="TRANS_REIMBURSE_OBAT")
@SuppressWarnings("PersistenceUnitPresent")
public class TransReimburseObat extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="REIMBURSE_OBAT_ID")
  private int reimburseDetObatId;
  @Column(name="OBAT_PRICE_REV")
  private Double obatPriceRev;
  @ManyToOne
  @JoinColumn(name="OBAT_ID")
  private MasterObat obat;
  @ManyToOne
  @JoinColumn(name="REIMBURSE_ID")
  private TransReimburse reimburse;

  /**
   * @return the reimburseDetObatId
   */
  public int getReimburseDetObatId() {
    return reimburseDetObatId;
  }

  /**
   * @param reimburseDetObatId the reimburseDetObatId to set
   */
  public void setReimburseDetObatId(int reimburseDetObatId) {
    this.reimburseDetObatId = reimburseDetObatId;
  }

  /**
   * @return the obatPriceRev
   */
  public Double getObatPriceRev() {
    return obatPriceRev;
  }

  /**
   * @param obatPriceRev the obatPriceRev to set
   */
  public void setObatPriceRev(Double obatPriceRev) {
    this.obatPriceRev = obatPriceRev;
  }

  /**
   * @return the obat
   */
  public MasterObat getObat() {
    return obat;
  }

  /**
   * @param obat the obat to set
   */
  public void setObat(MasterObat obat) {
    this.obat = obat;
  }

  /**
   * @return the reimburse
   */
  public TransReimburse getReimburse() {
    return reimburse;
  }

  /**
   * @param reimburse the reimburse to set
   */
  public void setReimburse(TransReimburse reimburse) {
    this.reimburse = reimburse;
  }

}
