/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.dao;

import com.safasoft.yakes.bean.MasterRole;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @created Apr 4, 2016
 * @author awal
 */
@Repository("masterRoleDAO")
public class MasterRoleDAO extends BaseDAO<MasterRole> {
  
  public List<MasterRole> getByRangeInputFind(String inputFind, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rol " +
              "where (UPPER(rol.roleCode) like :inputFind " +
                "or UPPER(rol.roleName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByInputFind(String inputFind) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " rol " +
              "where (UPPER(rol.roleCode) like :inputFind " +
                "or UPPER(rol.roleName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .iterate().next()).intValue();
  }
  
}
