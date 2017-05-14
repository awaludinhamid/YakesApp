/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterParameterDet;
import java.util.List;

/**
 * @created Feb 12, 2017
 * @author awal
 */
public interface MasterParameterDetService {

  MasterParameterDet save(MasterParameterDet parameterDet);
  MasterParameterDet delete(MasterParameterDet parameterDet);
  MasterParameterDet getById(int parameterDetId);
  List<MasterParameterDet> getAll();
  List<MasterParameterDet> getByPage(int pageNo);
  List<MasterParameterDet> getByPageInputFind(String inputFind, int pageNo);
  int count();
  int countByInputFind(String inputFind);
  List<MasterParameterDet> getByParameterCode(String parameterCode);
}
