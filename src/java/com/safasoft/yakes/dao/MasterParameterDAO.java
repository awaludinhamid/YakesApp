/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.dao;

import com.safasoft.yakes.bean.MasterParameter;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @created Feb 12, 2017
 * @author awal
 */
@Repository("masterParameterDAO")
public class MasterParameterDAO extends BaseDAO<MasterParameter> {
  
  public List<MasterParameter> getByRangeInputFind(String inputFind, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " par " +
              "where (UPPER(par.parameterCode) like :inputFind " +
                "or UPPER(par.parameterName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByInputFind(String inputFind) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " par " +
              "where (UPPER(par.parameterCode) like :inputFind " +
                "or UPPER(par.parameterName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .iterate().next()).intValue();
  }
  
}
