/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.dao;

import com.safasoft.yakes.bean.MasterCoa;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author awal
 * @created Apr 2, 2017
 */
@Repository("masterCoaDAO")
public class MasterCoaDAO extends BaseDAO<MasterCoa> {

  public List<MasterCoa> getByRangeInputFind(String inputFind, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " coa " +
              "where (UPPER(coa.coaLocalCode) like :inputFind " +
                "or UPPER(coa.coaGovCode) like :inputFind " +
                "or UPPER(coa.coaName) like :inputFind " +
                "or UPPER(coa.coaDesc) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .list();
  }
  
  public int countByInputFind(String inputFind) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " coa " +
              "where (UPPER(coa.coaLocalCode) like :inputFind " +
                "or UPPER(coa.coaGovCode) like :inputFind " +
                "or UPPER(coa.coaName) like :inputFind " +
                "or UPPER(coa.coaDesc) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .iterate().next()).intValue();
  }
}
