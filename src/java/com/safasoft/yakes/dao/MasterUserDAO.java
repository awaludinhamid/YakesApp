/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.dao;

import com.safasoft.yakes.bean.MasterUser;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @created Feb 09, 2017
 * @author awal
 */
@Repository("masterUserDAO")
public class MasterUserDAO extends BaseDAO<MasterUser>{  

  /**
   * Retrieve record from database by String name
   * @param userName
   * @return class bean
   */
  public MasterUser getByCode(String userName) {
    return (MasterUser) sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() +
              " where userCode = :userCode")
            .setString("userCode", userName)
            .uniqueResult();
  } 
  
  public List<MasterUser> getByRangeInputFind(String inputFind, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usr " +
              "where (UPPER(usr.userCode) like :inputFind " +
                "or UPPER(usr.userName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByInputFind(String inputFind) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " usr " +
              "where (UPPER(usr.userCode) like :inputFind " +
                "or UPPER(usr.userName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .iterate().next()).intValue();
  }
}
