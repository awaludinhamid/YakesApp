/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterRoleMenu;
import java.util.List;

/**
 * @created Feb 16, 2017
 * @author awal
 */
public interface MasterRoleMenuService {

  MasterRoleMenu save(MasterRoleMenu mrm);
  MasterRoleMenu delete(MasterRoleMenu mrm);
  List<MasterRoleMenu> getAll();
  List<MasterRoleMenu> getByPage(int pageNo);
  int count();
  List<MasterRoleMenu> getByPageInputFind(String inputFind, int pageNo);
  int countByInputFind(String inputFind);
}
