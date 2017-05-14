/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterObat;
import com.safasoft.yakes.dao.MasterObatDAO;
import com.safasoft.yakes.service.MasterObatService;
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
@Service("masterObatService")
@Transactional(readOnly=true)
public class MasterObatServiceImpl implements MasterObatService {

  @Autowired
  private MasterObatDAO masterObatDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterObat save(MasterObat domain) {
    return masterObatDAO.save(domain);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterObat delete(MasterObat domain) {
    return masterObatDAO.delete(domain);
  }

  @Override
  public MasterObat getById(int obatId) {
    return masterObatDAO.getById(obatId);
  }

  @Override
  public List<MasterObat> getAll() {
    return masterObatDAO.getAll();
  }

  @Override
  public List<MasterObat> getByPage(int pageNo) {
    return masterObatDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterObat> getByPageInputFind(String inputFind, int pageNo) {
    return masterObatDAO.getByRangeInputFind(inputFind, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterObatDAO.count();
  }

  @Override
  public int countByInputFind(String inputFind) {
    return masterObatDAO.countByInputFind(inputFind);
  }
}
