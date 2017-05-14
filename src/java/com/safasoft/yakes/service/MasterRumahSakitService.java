/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterRumahSakit;
import java.util.List;

/**
 *
 * @author awal
 */
public interface MasterRumahSakitService {

  MasterRumahSakit save(MasterRumahSakit domain);
  MasterRumahSakit delete(MasterRumahSakit domain);
  MasterRumahSakit getById(int golonganId);
  List<MasterRumahSakit> getAll();
  List<MasterRumahSakit> getByPage(int pageNo);
  List<MasterRumahSakit> getByPageInputFind(String inputFind, int pageNo);
  int count();
  int countByInputFind(String inputFind);
}
