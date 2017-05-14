/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterParameter;
import java.util.List;

/**
 * @created Feb 12, 2017
 * @author awal
 */
public interface MasterParameterService {

  MasterParameter save(MasterParameter parameter);
  MasterParameter delete(MasterParameter parameter);
  MasterParameter getById(int parameterId);
  List<MasterParameter> getAll();
  List<MasterParameter> getByPage(int pageNo);
  List<MasterParameter> getByPageInputFind(String inputFind, int pageNo);
  int count();
  int countByInputFind(String inputFind);
}
