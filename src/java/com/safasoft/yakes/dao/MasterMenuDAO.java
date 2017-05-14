/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.dao;

import com.safasoft.yakes.bean.MasterMenu;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @created Feb 14, 2017
 * @author awal
 */
@Repository("masterMenuDAO")
public class MasterMenuDAO extends BaseDAO<MasterMenu> {
  
  public List<MasterMenu> getListMenuByUserId(int userId) {
    return sessionFactory.getCurrentSession().createQuery(
            "select mnu from " + domainClass.getName() + " mnu, " +
              /*"join mnu.roleMenus rm " +
              "join rm.role.userRoles ur " +*/
              "MasterRoleMenu rm, " +
              "MasterUserRole ur " +
              "where ur.user.userId = :userId " +
                "and mnu.menuId = rm.menu.menuId " +
                "and rm.role.roleId = ur.role.roleId " +
              "order by mnu.parentMenu.parentMenuId, mnu.sort")
            .setInteger("userId", userId)
            .list();
  }
  
  public List<MasterMenu> getByRangeInputFind(String inputFind, int start, int num) {
    return sessionFactory.getCurrentSession().createQuery(
            "from " + domainClass.getName() + " mnu " +
              "where (UPPER(mnu.menuCode) like :inputFind " +
                "or UPPER(mnu.menuName) like :inputFind " +
                "or UPPER(mnu.menuPage) like :inputFind " +
                "or UPPER(mnu.parentMenu.parentMenuName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .setFirstResult(start)
            .setMaxResults(num)
            .list();
  }
  
  public int countByInputFind(String inputFind) {
    return ((Long) sessionFactory.getCurrentSession().createQuery(
            "select count(*) from " + domainClass.getName() + " mnu " +
              "where (UPPER(mnu.menuCode) like :inputFind " +
                "or UPPER(mnu.menuName) like :inputFind " +
                "or UPPER(mnu.menuPage) like :inputFind " +
                "or UPPER(mnu.parentMenu.parentMenuName) like :inputFind)")
            .setString("inputFind", "%" + inputFind.toUpperCase() + "%")
            .iterate().next()).intValue();
  }
}
