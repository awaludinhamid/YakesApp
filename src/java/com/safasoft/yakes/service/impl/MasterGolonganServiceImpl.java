/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterGolongan;
import com.safasoft.yakes.dao.MasterGolonganDAO;
import com.safasoft.yakes.service.MasterGolonganService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author awal
 * @created Mar 25, 2017
 */
@Service("masterGolonganService")
@Transactional(readOnly=true)
public class MasterGolonganServiceImpl implements MasterGolonganService {

  @Autowired
  private MasterGolonganDAO masterGolonganDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterGolongan save(MasterGolongan domain) {
    return masterGolonganDAO.save(domain);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterGolongan delete(MasterGolongan domain) {
    return masterGolonganDAO.delete(domain);
  }

  @Override
  public MasterGolongan getById(int golonganId) {
    return masterGolonganDAO.getById(golonganId);
  }

  @Override
  public List<MasterGolongan> getByPage(int pageNo) {
    return masterGolonganDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterGolongan> getByPageInputFind(String inputFind, int pageNo) {
    return masterGolonganDAO.getByRangeInputFind(inputFind, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterGolonganDAO.count();
  }

  @Override
  public int countByInputFind(String inputFind) {
    return masterGolonganDAO.countByInputFind(inputFind);
  }

  @Override
  public List<MasterGolongan> getAll() {
    return masterGolonganDAO.getAll();
  }
}
