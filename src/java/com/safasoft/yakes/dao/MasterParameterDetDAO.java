/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.dao;

import com.safasoft.yakes.bean.MasterParameterDet;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @created Feb 12, 2017
 * @author awal
 */
@Repository("masterParameterDetDAO")
public class MasterParameterDetDAO extends BaseDAO<MasterParameterDet> {
  
  public List<MasterParameterDet> getByRangeInputFind(String inputFind, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " pardet " +
              "where (UPPER(pardet.parameterDetCode) like :inputFind " +
                "or UPPER(pardet.parameterDetName) like :inputFind " +
                "or UPPER(pardet.parameter.parameterCode) like :inputFind " +
                "or UPPER(pardet.parameter.parameterName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByInputFind(String inputFind) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " pardet " +
              "where (UPPER(pardet.parameterDetCode) like :inputFind " +
                "or UPPER(pardet.parameterDetName) like :inputFind " +
                "or UPPER(pardet.parameter.parameterCode) like :inputFind " +
                "or UPPER(pardet.parameter.parameterName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .iterate().next()).intValue();
  }
  
  public List<MasterParameterDet> getByParameterCode(String parameterCode) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " pardet " +
              "where pardet.parameter.parameterCode = :parameterCode")
            .setString("parameterCode", parameterCode)
            .list();
  }

}
