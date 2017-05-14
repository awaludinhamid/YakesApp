/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.TransReimburse;
import com.safasoft.yakes.dao.TransReimburseDAO;
import com.safasoft.yakes.service.TransReimburseService;
import com.safasoft.yakes.util.GlobalIntVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author awal
 * @created Apr 12, 2017
 */
@Service("transReimburseService")
@Transactional(readOnly=true)
public class TransReimburseServiceImpl implements TransReimburseService {

  @Autowired
  private TransReimburseDAO transReimburseDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public TransReimburse save(TransReimburse domain) {
    return transReimburseDAO.save(domain);
  }

  @Override
  @Transactional(readOnly=false)
  public TransReimburse delete(TransReimburse domain) {
    return transReimburseDAO.delete(domain);
  }

  @Override
  public TransReimburse getById(int transReimburseId) {
    return transReimburseDAO.getById(transReimburseId);
  }

  @Override
  public List<TransReimburse> getAll() {
    return transReimburseDAO.getAll();
  }

  @Override
  public List<TransReimburse> getByPage(int pageNo) {
    return transReimburseDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<TransReimburse> getByPageInputFindAndDate(String inputFind, String startDate, String endDate, int pageNo) {
   return transReimburseDAO.getByRangeInputFindAndDate(inputFind, startDate, endDate, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return transReimburseDAO.count();
  }

  @Override
  public int countByInputFindAndDate(String inputFind, String startDate, String endDate) {
    return transReimburseDAO.countByInputFindAndDate(inputFind, startDate, endDate);
  }
}
