/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.dao;

import com.safasoft.yakes.bean.MasterObat;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author awal
 * @created Mar 26, 2017
 */
@Repository("masterObatDAO")
public class MasterObatDAO extends BaseDAO<MasterObat> {

  public List<MasterObat> getByRangeInputFind(String inputFind, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " obat " +
              "where (UPPER(obat.obatCode) like :inputFind " +
                "or UPPER(obat.obatName) like :inputFind " +
                "or UPPER(obat.obatDesc) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByInputFind(String inputFind) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " obat " +
              "where (UPPER(obat.obatCode) like :inputFind " +
                "or UPPER(obat.obatName) like :inputFind " +
                "or UPPER(obat.obatDesc) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .iterate().next()).intValue();
  }
}
