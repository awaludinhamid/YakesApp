/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterCoa;
import java.util.List;

/**
 *
 * @author awal
 */
public interface MasterCoaService {

  MasterCoa save(MasterCoa domain);
  MasterCoa delete(MasterCoa domain);
  MasterCoa getById(int coaId);
  List<MasterCoa> getAll();
  List<MasterCoa> getByPage(int pageNo);
  List<MasterCoa> getByPageInputFind(String inputFind, int pageNo);
  int count();
  int countByInputFind(String inputFind);
}
