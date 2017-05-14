/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterRole;
import com.safasoft.yakes.dao.MasterRoleDAO;
import com.safasoft.yakes.service.MasterRoleService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Feb 09, 2017
 * @author awal
 */
@Service("masterRoleService")
@Transactional(readOnly=true)
public class MasterRoleServiceImpl implements MasterRoleService {

  @Autowired
  private MasterRoleDAO masterRoleDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterRole save(MasterRole mr) {
    return masterRoleDAO.save(mr);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterRole delete(MasterRole mr) {
    return masterRoleDAO.delete(mr);
  }

  @Override
  public MasterRole getById(int id) {
    return masterRoleDAO.getById(id);
  }

  @Override
  public List<MasterRole> getByPage(int pageNo) {
    return masterRoleDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterRoleDAO.count();
  }

  @Override
  public List<MasterRole> getAll() {
    return masterRoleDAO.getAll();
  }

  @Override
  public List<MasterRole> getByPageInputFind(String inputFind, int pageNo) {
    return masterRoleDAO.getByRangeInputFind(inputFind, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByInputFind(String inputFind) {
    return masterRoleDAO.countByInputFind(inputFind);
  }
}
