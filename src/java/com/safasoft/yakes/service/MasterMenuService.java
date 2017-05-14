/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterMenu;
import java.util.List;

/**
 * @created Feb 14, 2017
 * @author awal
 */
public interface MasterMenuService {

  MasterMenu save(MasterMenu mm);
  MasterMenu delete(MasterMenu mm);
  MasterMenu getById(int id);
  List<MasterMenu> getAll();
  List<MasterMenu> getByPage(int pageNo);
  int count();
  List<MasterMenu> getListMenuByUserId(int userId);
  List<MasterMenu> getByPageInputFind(String inputFind, int pageNo);
  int countByInputFind(String inputFind);
}
