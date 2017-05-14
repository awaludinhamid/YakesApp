/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterPeserta;
import java.util.List;

/**
 *
 * @author awal
 */
public interface MasterPesertaService {

  MasterPeserta save(MasterPeserta domain);
  MasterPeserta delete(MasterPeserta domain);
  MasterPeserta getById(int customerId);
  List<MasterPeserta> getAll();
  List<MasterPeserta> getByPage(int pageNo);
  List<MasterPeserta> getByPageInputFind(String inputFind, int pageNo);
  int count();
  int countByInputFind(String inputFind);
}
