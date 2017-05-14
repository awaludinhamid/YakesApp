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
 *
 * @author awal
 * @created Apr 11, 2017
 */
@Entity
@Table(name="MASTER_RUMAH_SAKIT")
@SuppressWarnings("PersistenceUnitPresent")
public class MasterRumahSakit extends RecordAuditBean {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="RUMAH_SAKIT_ID")
  private int rumahSakitId;
  @Column(name="RUMAH_SAKIT_CODE")
  private String rumahSakitCode;
  @Column(name="RUMAH_SAKIT_NAME")
  private String rumahSakitName;
  @Column(name="RUMAH_SAKIT_PIC")
  private String rumahSakitPic;
  @Column(name="RUMAH_SAKIT_ADDRESS")
  private String rumahSakitAddress;
  @Column(name="RUMAH_SAKIT_PHONE")
  private String rumahSakitPhone;
  @Column(name="RUMAH_SAKIT_TYPE")
  private String rumahSakitType;

  /**
   * @return the rumahSakitId
   */
  public int getRumahSakitId() {
    return rumahSakitId;
  }

  /**
   * @param rumahSakitId the rumahSakitId to set
   */
  public void setRumahSakitId(int rumahSakitId) {
    this.rumahSakitId = rumahSakitId;
  }

  /**
   * @return the rumahSakitCode
   */
  public String getRumahSakitCode() {
    return rumahSakitCode;
  }

  /**
   * @param rumahSakitCode the rumahSakitCode to set
   */
  public void setRumahSakitCode(String rumahSakitCode) {
    this.rumahSakitCode = rumahSakitCode;
  }

  /**
   * @return the rumahSakitName
   */
  public String getRumahSakitName() {
    return rumahSakitName;
  }

  /**
   * @param rumahSakitName the rumahSakitName to set
   */
  public void setRumahSakitName(String rumahSakitName) {
    this.rumahSakitName = rumahSakitName;
  }

  /**
   * @return the rumahSakitPic
   */
  public String getRumahSakitPic() {
    return rumahSakitPic;
  }

  /**
   * @param rumahSakitPic the rumahSakitPic to set
   */
  public void setRumahSakitPic(String rumahSakitPic) {
    this.rumahSakitPic = rumahSakitPic;
  }

  /**
   * @return the rumahSakitAddress
   */
  public String getRumahSakitAddress() {
    return rumahSakitAddress;
  }

  /**
   * @param rumahSakitAddress the rumahSakitAddress to set
   */
  public void setRumahSakitAddress(String rumahSakitAddress) {
    this.rumahSakitAddress = rumahSakitAddress;
  }

  /**
   * @return the rumahSakitPhone
   */
  public String getRumahSakitPhone() {
    return rumahSakitPhone;
  }

  /**
   * @param rumahSakitPhone the rumahSakitPhone to set
   */
  public void setRumahSakitPhone(String rumahSakitPhone) {
    this.rumahSakitPhone = rumahSakitPhone;
  }

  /**
   * @return the rumahSakitType
   */
  public String getRumahSakitType() {
    return rumahSakitType;
  }

  /**
   * @param rumahSakitType the rumahSakitType to set
   */
  public void setRumahSakitType(String rumahSakitType) {
    this.rumahSakitType = rumahSakitType;
  }

}
