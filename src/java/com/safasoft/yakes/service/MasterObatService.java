/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterObat;
import java.util.List;

/**
 *
 * @author awal
 */
public interface MasterObatService {

  MasterObat save(MasterObat domain);
  MasterObat delete(MasterObat domain);
  MasterObat getById(int obatId);
  List<MasterObat> getAll();
  List<MasterObat> getByPage(int pageNo);
  List<MasterObat> getByPageInputFind(String inputFind, int pageNo);
  int count();
  int countByInputFind(String inputFind);
}
