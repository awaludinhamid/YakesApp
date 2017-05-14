/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterUserRole;
import java.util.List;

/**
 * @created Feb 09, 2017
 * @author awal
 */
public interface MasterUserRoleService {
  
  MasterUserRole save(MasterUserRole mur);
  MasterUserRole delete(MasterUserRole mur);
  List<MasterUserRole> getByPage(int pageNo);  
  int count();
  List<MasterUserRole> getByUser(int userId);
  List<MasterUserRole> getByPageInputFind(String inputFind, int pageNo);
  int countByInputFind(String inputFind);
}
