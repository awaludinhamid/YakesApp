<%-- 
    Document   : rolemenupage
    Created on : Feb 21, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/rolemenu.js"></script-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="rolemenu" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-6">
          <input id="inputFind" class="form-control" placeholder="Role Code | Role Name | Menu Code | Menu Name | Parent Menu"
                 ng-model="inputFind" ng-init="inputFind=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Role Code</th>
              <th>Role Name</th>
              <th>Menu Code</th>
              <th>Menu Name</th>
              <th>Parent Menu</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.roleMenuId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.role.roleCode}}</td>
              <td>{{data.role.roleName}}</td>
              <td>{{data.menu.menuCode}}</td>
              <td>{{data.menu.menuName}}</td>
              <td>{{data.menu.parentMenu.parentMenuName}}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div id="pagination" style="text-align: center">
        <ul class="pagination"></ul>
      </div>
    </div>
  </div>
  
  <div class="modal fade" id="mdl-save-record" tabindex="-1" role="dialog" aria-labelledby="save-record-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="save-record-title">
            <img src="" alt="Save icon"/>&nbsp<span></span>
          </h4>
        </div>
        <div class="modal-body">
          <form id="form-save" class="form-horizontal">
            <input type="hidden" id="roleMenuId">
            <input type="hidden" id="createdBy">
            <div class="form-group">
              <label class="col-sm-3 control-label">Role*</label>
              <div class="col-sm-8">
                <select id="roleId" class="form-control" tabindex="1" required autofocus>
                  <option ng-repeat="drop in datadrop.role" value="{{drop.roleId}}">{{drop.roleName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Menu*</label>
              <div class="col-sm-8">
                <select id="menuId" class="form-control" tabindex="2" required>
                  <option ng-repeat="drop in datadrop.menu" value="{{drop.menuId}}">{{drop.menuName}}</option>
                </select>
              </div>
            </div>
            <div class="btn-form-save">
              <button id="btn-clear" class="btn btn-warning" type="reset">Clear</button>
              <button id="btn-save" class="btn btn-primary" type="submit" tabindex="10">Save</button>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button class="btn btn-danger" data-dismiss="modal">Cancel</button>
        </div>
      </div>
    </div>
  </div>
  </div>
  
</body>
</html>
