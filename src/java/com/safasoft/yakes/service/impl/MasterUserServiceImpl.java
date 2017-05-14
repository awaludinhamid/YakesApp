/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterUser;
import com.safasoft.yakes.dao.MasterUserDAO;
import com.safasoft.yakes.service.MasterUserService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Feb 09, 2017
 * @author awal
 */
@Service("masterUserService")
@Transactional(readOnly=true)
public class MasterUserServiceImpl implements MasterUserService {

  @Autowired
  private MasterUserDAO masterUserDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterUser save(MasterUser mu) {
    return masterUserDAO.save(mu);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterUser delete(MasterUser mu) {
    return masterUserDAO.delete(mu);
  }

  @Override
  public MasterUser getById(int id) {
    return masterUserDAO.getById(id);
  }

  @Override
  public MasterUser getByCode(String userCode) {
    return masterUserDAO.getByCode(userCode);
  }

  @Override
  public List<MasterUser> getByPage(int pageNo) {
    return masterUserDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterUserDAO.count();
  }

  @Override
  public List<MasterUser> getByPageInputFind(String inputFind, int pageNo) {
    return masterUserDAO.getByRangeInputFind(inputFind, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByInputFind(String inputFind) {
    return masterUserDAO.countByInputFind(inputFind);
  }

  @Override
  public List<MasterUser> getAll() {
    return masterUserDAO.getAll();
  }
}
