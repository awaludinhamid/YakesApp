/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterMenu;
import com.safasoft.yakes.dao.MasterMenuDAO;
import com.safasoft.yakes.service.MasterMenuService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @created Oct 14, 2016
 * @author awal
 */
@Service("masterMenuService")
@Transactional(readOnly=true)
public class MasterMenuServiceImpl implements MasterMenuService {

  @Autowired
  private MasterMenuDAO masterMenuDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterMenu save(MasterMenu mm) {
    return masterMenuDAO.save(mm);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterMenu delete(MasterMenu mm) {
    return masterMenuDAO.delete(mm);
  }

  @Override
  public MasterMenu getById(int id) {
    return masterMenuDAO.getById(id);
  }

  @Override
  public List<MasterMenu> getAll() {
    return masterMenuDAO.getAll();
  }

  @Override
  public List<MasterMenu> getByPage(int pageNo) {
    return masterMenuDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterMenuDAO.count();
  }

  @Override
  public List<MasterMenu> getListMenuByUserId(int userId) {
    return masterMenuDAO.getListMenuByUserId(userId);
  }

  @Override
  public List<MasterMenu> getByPageInputFind(String inputFind, int pageNo) {
    return masterMenuDAO.getByRangeInputFind(inputFind, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int countByInputFind(String inputFind) {
    return masterMenuDAO.countByInputFind(inputFind);
  }
}
