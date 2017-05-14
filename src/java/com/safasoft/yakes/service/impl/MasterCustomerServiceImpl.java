/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service.impl;

import com.safasoft.yakes.bean.MasterCustomer;
import com.safasoft.yakes.dao.MasterCustomerDAO;
import com.safasoft.yakes.service.MasterCustomerService;
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
@Service("masterCustomerService")
@Transactional(readOnly=true)
public class MasterCustomerServiceImpl implements MasterCustomerService {

  @Autowired
  private MasterCustomerDAO masterCustomerDAO;
  private final int pagingRecords = GlobalIntVariable.PAGING_RECORDS.getVar();

  @Override
  @Transactional(readOnly=false)
  public MasterCustomer save(MasterCustomer domain) {
    return masterCustomerDAO.save(domain);
  }

  @Override
  @Transactional(readOnly=false)
  public MasterCustomer delete(MasterCustomer domain) {
    return masterCustomerDAO.delete(domain);
  }

  @Override
  public MasterCustomer getById(int customerId) {
    return masterCustomerDAO.getById(customerId);
  }

  @Override
  public List<MasterCustomer> getByPage(int pageNo) {
    return masterCustomerDAO.getByRange((pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public List<MasterCustomer> getByPageInputFind(String inputFind, int pageNo) {
    return masterCustomerDAO.getByRangeInputFind(inputFind, (pageNo - 1) * pagingRecords, pagingRecords);
  }

  @Override
  public int count() {
    return masterCustomerDAO.count();
  }

  @Override
  public int countByInputFind(String inputFind) {
    return masterCustomerDAO.countByInputFind(inputFind);
  }

  @Override
  public List<MasterCustomer> getAll() {
    return masterCustomerDAO.getAll();
  }
}
