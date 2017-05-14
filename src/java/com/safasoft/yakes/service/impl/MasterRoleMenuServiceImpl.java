/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterRoleMenu;
import com.safasoft.yakes.dao.MasterRoleMenuDAO;
import com.safasoft.yakes.service.MasterRoleMenuService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Feb 16, 2017
 * @author awal
 */
@Service("masterRoleMenuService")
@Transactional(readOnly=true) 
public class MasterRoleMenuServiceImpl implements MasterRoleMenuService {

  @Autowired
  private MasterRoleMenuDAO masterRoleMenuDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterRoleMenu save(MasterRoleMenu mrm) {
    return masterRoleMenuDAO.save(mrm);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterRoleMenu delete(MasterRoleMenu mrm) {
    return masterRoleMenuDAO.delete(mrm);
  }

  @Override
  public List<MasterRoleMenu> getAll() {
    return masterRoleMenuDAO.getAll();
  }

  @Override
  public List<MasterRoleMenu> getByPage(int pageNo) {
    return masterRoleMenuDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }
  
  @Override
  public int count() {
    return masterRoleMenuDAO.count();
  }

  @Override
  public List<MasterRoleMenu> getByPageInputFind(String inputFind, int pageNo) {
    return masterRoleMenuDAO.getByRangeInputFind(inputFind, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByInputFind(String inputFind) {
    return masterRoleMenuDAO.countByInputFind(inputFind);
  }
}
