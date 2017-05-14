/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.dao;

import com.safasoft.yakes.bean.MasterRumahSakit;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author awal
 * @created Apr 11, 2017
 */
@Repository("masterRumahSakitDAO")
public class MasterRumahSakitDAO extends BaseDAO<MasterRumahSakit> {

  public List<MasterRumahSakit> getByRangeInputFind(String inputFind, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rs " +
              "where (UPPER(rs.rumahSakitCode) like :inputFind " +
                "or UPPER(rs.rumahSakitName) like :inputFind " +
                "or UPPER(rs.rumahSakitType) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByInputFind(String inputFind) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " rs " +
              "where (UPPER(rs.rumahSakitCode) like :inputFind " +
                "or UPPER(rs.rumahSakitName) like :inputFind " +
                "or UPPER(rs.rumahSakitType) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .iterate().next()).intValue();
  }

}
