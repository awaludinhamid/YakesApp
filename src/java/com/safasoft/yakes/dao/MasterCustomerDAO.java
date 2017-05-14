/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.dao;

import com.safasoft.yakes.bean.MasterCustomer;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author awal
 * @created Mar 25, 2017
 */
@Repository("masterCustomerDAO")
public class MasterCustomerDAO extends BaseDAO<MasterCustomer> {

  public List<MasterCustomer> getByRangeInputFind(String inputFind, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " cust " +
              "where (UPPER(cust.polisNo) like :inputFind " +
                "or UPPER(cust.polisHolder) like :inputFind " +
                "or UPPER(cust.golongan.golonganName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByInputFind(String inputFind) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " cust " +
              "where (UPPER(cust.polisNo) like :inputFind " +
                "or UPPER(cust.polisHolder) like :inputFind " +
                "or UPPER(cust.golongan.golonganName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .iterate().next()).intValue();
  }
}
