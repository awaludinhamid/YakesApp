/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterRole;
import java.util.List;

/**
 * @created Feb 09, 2017
 * @author awal
 */
public interface MasterRoleService {

  MasterRole save(MasterRole mr);
  MasterRole delete(MasterRole mr);
  MasterRole getById(int id);
  List<MasterRole> getAll();
  List<MasterRole> getByPage(int pageNo);
  int count();
  List<MasterRole> getByPageInputFind(String inputFind, int pageNo);
  int countByInputFind(String inputFind);
}
