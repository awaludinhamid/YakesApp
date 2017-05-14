/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterUserRole;
import com.safasoft.yakes.dao.MasterUserRoleDAO;
import com.safasoft.yakes.service.MasterUserRoleService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Feb 09, 2017
 * @author awal
 */
@Service("masterUserRoleService")
@Transactional(readOnly=true)
public class MasterUserRoleServiceImpl implements MasterUserRoleService {

  @Autowired
  private MasterUserRoleDAO masterUserRoleDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterUserRole save(MasterUserRole mur) {
    return masterUserRoleDAO.save(mur);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterUserRole delete(MasterUserRole mur) {
    return masterUserRoleDAO.delete(mur);
  }

  @Override
  public List<MasterUserRole> getByPage(int pageNo) {
    return masterUserRoleDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterUserRoleDAO.count();
  }

  @Override
  public List<MasterUserRole> getByUser(int userId) {
    return masterUserRoleDAO.getByUser(userId);
  }

  @Override
  public List<MasterUserRole> getByPageInputFind(String inputFind, int pageNo) {
    return masterUserRoleDAO.getByRangeInputFind(inputFind, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByInputFind(String inputFind) {
    return masterUserRoleDAO.countByInputFind(inputFind);
  }
}
