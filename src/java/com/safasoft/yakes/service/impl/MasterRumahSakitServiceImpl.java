/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterRumahSakit;
import com.safasoft.yakes.dao.MasterRumahSakitDAO;
import com.safasoft.yakes.service.MasterRumahSakitService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author awal
 * @created Apr 11, 2017
 */
@Service("masterRumahSakitService")
@Transactional(readOnly=true)
public class MasterRumahSakitServiceImpl implements MasterRumahSakitService {

  @Autowired
  private MasterRumahSakitDAO masterRumahSakitDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterRumahSakit save(MasterRumahSakit domain) {
    return masterRumahSakitDAO.save(domain);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterRumahSakit delete(MasterRumahSakit domain) {
    return masterRumahSakitDAO.delete(domain);
  }

  @Override
  public MasterRumahSakit getById(int golonganId) {
    return masterRumahSakitDAO.getById(golonganId);
  }

  @Override
  public List<MasterRumahSakit> getAll() {
    return masterRumahSakitDAO.getAll();
  }

  @Override
  public List<MasterRumahSakit> getByPage(int pageNo) {
    return masterRumahSakitDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterRumahSakit> getByPageInputFind(String inputFind, int pageNo) {
    return masterRumahSakitDAO.getByRangeInputFind(inputFind, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterRumahSakitDAO.count();
  }

  @Override
  public int countByInputFind(String inputFind) {
    return masterRumahSakitDAO.countByInputFind(inputFind);
  }
}
