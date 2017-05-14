/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.safasoft.yakes.service;

import com.safasoft.yakes.bean.MasterParentMenu;
import java.util.List;

/**
 * @created Feb 14, 2017
 * @author awal
 */
public interface MasterParentMenuService {

  MasterParentMenu save(MasterParentMenu mpm);
  MasterParentMenu delete(MasterParentMenu mpm);
  MasterParentMenu getById(int id);
  List<MasterParentMenu> getAll();
  List<MasterParentMenu> getByPage(int pageNo);

}
