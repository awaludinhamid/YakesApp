/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterTindakan;
import java.util.List;

/**
 *
 * @author awal
 * @created Apr 19, 2017
 */
public interface MasterTindakanService {

  MasterTindakan save(MasterTindakan domain);
  MasterTindakan delete(MasterTindakan domain);
  MasterTindakan getById(int tindakanId);
  List<MasterTindakan> getAll();
  List<MasterTindakan> getByPage(int pageNo);
  int count();
  
}
