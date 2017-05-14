/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterParentMenu;
import com.safasoft.yakes.dao.MasterParentMenuDAO;
import com.safasoft.yakes.service.MasterParentMenuService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Feb 14, 2017
 * @author awal
 */
@Service("masterParentMenuService")
@Transactional(readOnly=true)
public class MasterParentMenuServiceImpl implements MasterParentMenuService {

  @Autowired
  private MasterParentMenuDAO masterParentMenuDAO;

  @Override
  public MasterParentMenu save(MasterParentMenu mpm) {
    return masterParentMenuDAO.save(mpm);
  }

  @Override
  public MasterParentMenu delete(MasterParentMenu mpm) {
    return masterParentMenuDAO.delete(mpm);
  }

  @Override
  public MasterParentMenu getById(int id) {
    return masterParentMenuDAO.getById(id);
  }

  @Override
  public List<MasterParentMenu> getAll() {
    return masterParentMenuDAO.getAll();
  }

  @Override
  public List<MasterParentMenu> getByPage(int pageNo) {
    int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();
    return masterParentMenuDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }
}
