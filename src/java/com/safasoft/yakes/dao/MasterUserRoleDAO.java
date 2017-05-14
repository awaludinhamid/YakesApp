/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.dao;

import com.safasoft.yakes.bean.MasterUserRole;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @created Feb 09, 2017
 * @author awal
 */
@Repository("masterUserRoleDAO")
public class MasterUserRoleDAO extends BaseDAO<MasterUserRole> {
  
  public List<MasterUserRole> getByUser(int userId) {
      return sessionFactory.getCurrentSession().createQuery(
              "from " + domainClass.getName() + " usrrol " +
                "where usrrol.user.userId = :userId")
              .setInteger("userId", userId)
              .list();
  }
  
  public List<MasterUserRole> getByRangeInputFind(String inputFind, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " usrrol " +
              "where (UPPER(usrrol.user.userCode) like :inputFind " +
                "or UPPER(usrrol.user.userName) like :inputFind " +
                "or UPPER(usrrol.role.roleCode) like :inputFind " +
                "or UPPER(usrrol.role.roleName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByInputFind(String inputFind) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " usrrol " +
              "where (UPPER(usrrol.user.userCode) like :inputFind " +
                "or UPPER(usrrol.user.userName) like :inputFind " +
                "or UPPER(usrrol.role.roleCode) like :inputFind " +
                "or UPPER(usrrol.role.roleName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .iterate().next()).intValue();
  }
}
