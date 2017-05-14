/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterParameter;
import com.safasoft.yakes.dao.MasterParameterDAO;
import com.safasoft.yakes.service.MasterParameterService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Feb 12, 2017
 * @author awal
 */
@Service("masterParameterService")
@Transactional(readOnly=true)
public class MasterParameterServiceImpl implements MasterParameterService {

  @Autowired
  private MasterParameterDAO masterParameterDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterParameter save(MasterParameter parameter) {
    return masterParameterDAO.save(parameter);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterParameter delete(MasterParameter parameter) {
    return masterParameterDAO.delete(parameter);
  }

  @Override
  public MasterParameter getById(int parameterId) {
    return masterParameterDAO.getById(parameterId);
  }

  @Override
  public List<MasterParameter> getAll() {
    return masterParameterDAO.getAll();
  }

  @Override
  public List<MasterParameter> getByPage(int pageNo) {
    return masterParameterDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterParameter> getByPageInputFind(String inputFind, int pageNo) {
    return masterParameterDAO.getByRangeInputFind(inputFind, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public int countByInputFind(String inputFind) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
