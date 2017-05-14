/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.dao;

import com.safasoft.yakes.bean.TransReimburse;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author awal
 * @created Apr 11, 2017
 */
@Repository("transReimburseDAO")
public class TransReimburseDAO extends BaseDAO<TransReimburse> { 

  public List<TransReimburse> getByRangeInputFindAndDate(String inputFind, String startDate, String endDate, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rs " +
              "where (UPPER(rs.peserta.pesertaName) like :inputFind " +
                "or UPPER(rs.rumahSakitDesc) like :inputFind) " +
                "and rs.reimburseTransDate between to_date(:startDate,'yyyy-mm-dd') and to_date(:endDate,'yyyy-mm-dd')")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByInputFindAndDate(String inputFind, String startDate, String endDate) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " rs " +
              "where (UPPER(rs.peserta.pesertaName) like :inputFind " +
                "or UPPER(rs.rumahSakitDesc) like :inputFind) " +
                "and rs.reimburseTransDate between to_date(:startDate,'yyyy-mm-dd') and to_date(:endDate,'yyyy-mm-dd')")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .setString("startDate", startDate)
            .setString("endDate", endDate)
            .iterate().next()).intValue();
  }

}
