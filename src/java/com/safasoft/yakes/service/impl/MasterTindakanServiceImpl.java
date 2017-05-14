/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterTindakan;
import com.safasoft.yakes.dao.MasterTindakanDAO;
import com.safasoft.yakes.service.MasterTindakanService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author awal
 * @created Apr 19, 2017
 */
@Service("masterTindakanService")
@Transactional(readOnly=true)
public class MasterTindakanServiceImpl implements MasterTindakanService {

  @Autowired
  private MasterTindakanDAO masterTindakanDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  public MasterTindakan save(MasterTindakan domain) {
    return masterTindakanDAO.save(domain);
  }

  @Override
  public MasterTindakan delete(MasterTindakan domain) {
    return masterTindakanDAO.delete(domain);
  }

  @Override
  public MasterTindakan getById(int tindakanId) {
    return masterTindakanDAO.getById(tindakanId);
  }

  @Override
  public List<MasterTindakan> getAll() {
    return masterTindakanDAO.getAll();
  }

  @Override
  public List<MasterTindakan> getByPage(int pageNo) {
    return masterTindakanDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterTindakanDAO.count();
  }
}
