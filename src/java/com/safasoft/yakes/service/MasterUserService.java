/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterUser;
import java.util.List;

/**
 * @created Feb 09, 2017
 * @author awal
 */
public interface MasterUserService {

  MasterUser save(MasterUser mu);
  MasterUser delete(MasterUser mu);
  MasterUser getById(int id);
  MasterUser getByCode(String userCode);
  List<MasterUser> getAll();
  List<MasterUser> getByPage(int pageNo);
  int count();
  List<MasterUser> getByPageInputFind(String inputFind, int pageNo);
  int countByInputFind(String inputFind);
}
