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
 * @created Mar 25, 2017
 */
public class MasterGolonganDTO extends RecordAuditBeanDTO {

  private int golonganId;
  private String golonganCode;
  private String golonganName;
  private String positionDesc;
  private String classRoom;
  private Double roomdayCostMaxSupport;
  private Double yearCostMaxSupport;

  /**
   * @return the golonganId
   */
  public int getGolonganId() {
    return golonganId;
  }

  /**
   * @param golonganId the golonganId to set
   */
  public void setGolonganId(int golonganId) {
    this.golonganId = golonganId;
  }

  /**
   * @return the golonganCode
   */
  public String getGolonganCode() {
    return golonganCode;
  }

  /**
   * @param golonganCode the golonganCode to set
   */
  public void setGolonganCode(String golonganCode) {
    this.golonganCode = golonganCode;
  }

  /**
   * @return the golonganName
   */
  public String getGolonganName() {
    return golonganName;
  }

  /**
   * @param golonganName the golonganName to set
   */
  public void setGolonganName(String golonganName) {
    this.golonganName = golonganName;
  }

  /**
   * @return the positionDesc
   */
  public String getPositionDesc() {
    return positionDesc;
  }

  /**
   * @param positionDesc the positionDesc to set
   */
  public void setPositionDesc(String positionDesc) {
    this.positionDesc = positionDesc;
  }

  /**
   * @return the classRoom
   */
  public String getClassRoom() {
    return classRoom;
  }

  /**
   * @param classRoom the classRoom to set
   */
  public void setClassRoom(String classRoom) {
    this.classRoom = classRoom;
  }

  /**
   * @return the roomdayCostMaxSupport
   */
  public Double getRoomdayCostMaxSupport() {
    return roomdayCostMaxSupport;
  }

  /**
   * @param roomdayCostMaxSupport the roomdayCostMaxSupport to set
   */
  public void setRoomdayCostMaxSupport(Double roomdayCostMaxSupport) {
    this.roomdayCostMaxSupport = roomdayCostMaxSupport;
  }

  /**
   * @return the yearCostMaxSupport
   */
  public Double getYearCostMaxSupport() {
    return yearCostMaxSupport;
  }

  /**
   * @param yearCostMaxSupport the yearCostMaxSupport to set
   */
  public void setYearCostMaxSupport(Double yearCostMaxSupport) {
    this.yearCostMaxSupport = yearCostMaxSupport;
  }
}
