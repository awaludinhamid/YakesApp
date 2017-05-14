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
 * @created Apr 11, 2017
 */
public class MasterRumahSakitDTO extends RecordAuditBeanDTO {

  private int rumahSakitId;
  private String rumahSakitCode;
  private String rumahSakitName;
  private String rumahSakitPic;
  private String rumahSakitAddress;
  private String rumahSakitPhone;
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
