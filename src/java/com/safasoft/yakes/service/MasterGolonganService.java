/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterGolongan;
import java.util.List;

/**
 *
 * @author awal
 */
public interface MasterGolonganService {

  MasterGolongan save(MasterGolongan domain);
  MasterGolongan delete(MasterGolongan domain);
  MasterGolongan getById(int golonganId);
  List<MasterGolongan> getAll();
  List<MasterGolongan> getByPage(int pageNo);
  List<MasterGolongan> getByPageInputFind(String inputFind, int pageNo);
  int count();
  int countByInputFind(String inputFind);
}
