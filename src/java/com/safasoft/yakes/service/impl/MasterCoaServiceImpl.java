/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterCoa;
import com.safasoft.yakes.dao.MasterCoaDAO;
import com.safasoft.yakes.service.MasterCoaService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author awal
 * @created Apr 2, 2017
 */
@Service("masterCoaService")
@Transactional(readOnly=true)
public class MasterCoaServiceImpl implements MasterCoaService {

  @Autowired
  private MasterCoaDAO masterCoaDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterCoa save(MasterCoa domain) {
    return masterCoaDAO.save(domain);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterCoa delete(MasterCoa domain) {
    return masterCoaDAO.delete(domain);
  }

  @Override
  public MasterCoa getById(int coaId) {
    return masterCoaDAO.getById(coaId);
  }

  @Override
  public List<MasterCoa> getAll() {
    return masterCoaDAO.getAll();
  }

  @Override
  public List<MasterCoa> getByPage(int pageNo) {
    return masterCoaDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterCoa> getByPageInputFind(String inputFind, int pageNo) {
    return masterCoaDAO.getByRangeInputFind(inputFind, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterCoaDAO.count();
  }

  @Override
  public int countByInputFind(String inputFind) {
    return masterCoaDAO.countByInputFind(inputFind);
  }
}
