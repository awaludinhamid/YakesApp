/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.TransReimburse;
import java.util.List;

/**
 *
 * @author awal
 */
public interface TransReimburseService {

  TransReimburse save(TransReimburse domain);
  TransReimburse delete(TransReimburse domain);
  TransReimburse getById(int transReimburseId);
  List<TransReimburse> getAll();
  List<TransReimburse> getByPage(int pageNo);
  List<TransReimburse> getByPageInputFindAndDate(String inputFind, String startDate, String endDate, int pageNo);
  int count();
  int countByInputFindAndDate(String inputFind, String startDate, String endDate);

}
