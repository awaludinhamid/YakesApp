/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterCustomer;
import java.util.List;

/**
 *
 * @author awal
 */
public interface MasterCustomerService {

  MasterCustomer save(MasterCustomer domain);
  MasterCustomer delete(MasterCustomer domain);
  MasterCustomer getById(int customerId);
  List<MasterCustomer> getAll();
  List<MasterCustomer> getByPage(int pageNo);
  List<MasterCustomer> getByPageInputFind(String inputFind, int pageNo);
  int count();
  int countByInputFind(String inputFind);
}
