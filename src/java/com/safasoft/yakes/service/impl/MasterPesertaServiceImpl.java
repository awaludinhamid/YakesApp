/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterPeserta;
import com.safasoft.yakes.dao.MasterPesertaDAO;
import com.safasoft.yakes.service.MasterPesertaService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author awal
 * @created Mar 26, 2017
 */
@Service("masterPesertaService")
@Transactional(readOnly=true)
public class MasterPesertaServiceImpl implements MasterPesertaService {

  @Autowired
  private MasterPesertaDAO masterPesertaDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterPeserta save(MasterPeserta domain) {
    return masterPesertaDAO.save(domain);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterPeserta delete(MasterPeserta domain) {
    return masterPesertaDAO.delete(domain);
  }

  @Override
  public MasterPeserta getById(int customerId) {
    return masterPesertaDAO.getById(customerId);
  }

  @Override
  public List<MasterPeserta> getByPage(int pageNo) {
    return masterPesertaDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterPeserta> getByPageInputFind(String inputFind, int pageNo) {
    return masterPesertaDAO.getByRangeInputFind(inputFind, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterPesertaDAO.count();
  }

  @Override
  public int countByInputFind(String inputFind) {
    return masterPesertaDAO.countByInputFind(inputFind);
  }

  @Override
  public List<MasterPeserta> getAll() {
    return masterPesertaDAO.getAll();
  }
}
