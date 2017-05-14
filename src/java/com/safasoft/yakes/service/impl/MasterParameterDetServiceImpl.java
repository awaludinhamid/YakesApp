/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterParameterDet;
import com.safasoft.yakes.dao.MasterParameterDetDAO;
import com.safasoft.yakes.service.MasterParameterDetService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Feb 12, 2017
 * @author awal
 */
@Service("masterParameterDetService")
@Transactional(readOnly=true)
public class MasterParameterDetServiceImpl implements MasterParameterDetService {

  @Autowired
  private MasterParameterDetDAO masterParameterDetDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterParameterDet save(MasterParameterDet parameterDet) {
    return masterParameterDetDAO.save(parameterDet);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterParameterDet delete(MasterParameterDet parameterDet) {
    return masterParameterDetDAO.delete(parameterDet);
  }

  @Override
  public List<MasterParameterDet> getAll() {
    return masterParameterDetDAO.getAll();
  }

  @Override
  public List<MasterParameterDet> getByPage(int pageNo) {
    return masterParameterDetDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterParameterDet> getByPageInputFind(String inputFind, int pageNo) {
    return masterParameterDetDAO.getByRangeInputFind(inputFind, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterParameterDetDAO.count();
  }

  @Override
  public int countByInputFind(String inputFind) {
    return masterParameterDetDAO.countByInputFind(inputFind);
  }

  @Override
  public MasterParameterDet getById(int parameterDetId) {
    return masterParameterDetDAO.getById(parameterDetId);
  }

  @Override
  public List<MasterParameterDet> getByParameterCode(String parameterCode) {
    return masterParameterDetDAO.getByParameterCode(parameterCode);
  }
}
