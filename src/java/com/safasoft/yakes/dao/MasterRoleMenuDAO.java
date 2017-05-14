/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.dao;

import com.safasoft.yakes.bean.MasterRoleMenu;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @created Feb 16, 2017
 * @author awal
 */
@Service("masterRoleMenuDAO")
public class MasterRoleMenuDAO extends BaseDAO<MasterRoleMenu> {  
  
  public List<MasterRoleMenu> getByRangeInputFind(String inputFind, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " rolmnu " +
              "where (UPPER(rolmnu.role.roleCode) like :inputFind " +
                "or UPPER(rolmnu.role.roleName) like :inputFind " +
                "or UPPER(rolmnu.menu.menuCode) like :inputFind " +
                "or UPPER(rolmnu.menu.menuName) like :inputFind " +
                "or UPPER(rolmnu.menu.parentMenu.parentMenuName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByInputFind(String inputFind) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " rolmnu " +
              "where (UPPER(rolmnu.role.roleCode) like :inputFind " +
                "or UPPER(rolmnu.role.roleName) like :inputFind " +
                "or UPPER(rolmnu.menu.menuCode) like :inputFind " +
                "or UPPER(rolmnu.menu.menuName) like :inputFind " +
                "or UPPER(rolmnu.menu.parentMenu.parentMenuName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .iterate().next()).intValue();
  }
}
