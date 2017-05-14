<%-- 
    Document   : menupage
    Created on : Feb 19, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/menu.js"></script-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="menu" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-6">
          <input id="inputFind" class="form-control" placeholder="Menu Code | Menu Name | Parent Menu | Menu Page "
                 ng-model="inputFind" ng-init="inputFind=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Code</th>
              <th>Name</th>
              <th>Parent Menu</th>
              <th>Page</th>
              <th>Sort</th>
              <th>Icon Path</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.menuId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.menuCode}}</td>
              <td>{{data.menuName}}</td>
              <td>{{data.parentMenu.parentMenuName}}</td>
              <td>{{data.menuPage}}</td>
              <td>{{data.sort}}</td>
              <td>{{data.iconPath}}</td>
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
            <input type="hidden" id="menuId">
            <input type="hidden" id="createdBy">
            <div class="form-group">
              <label class="col-sm-3 control-label">Parent Menu*</label>
              <div class="col-sm-9">
                <select id="parentMenuId" class="form-control" tabindex="1" required autofocus>
                  <option ng-repeat="drop in datadrop.parentmenu" value="{{drop.parentMenuId}}">{{drop.parentMenuName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Code*</label>
              <div class="col-sm-9">
                <input id="menuCode" class="form-control" placeholder="[MENU]" maxlength="20" tabindex="2" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Name*</label>
              <div class="col-sm-9">
                <input id="menuName" class="form-control" placeholder="[MENU]" maxlength="255" tabindex="3" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Page*</label>
              <div class="col-sm-9">
                <input id="menuPage" class="form-control" placeholder="[apps/application/company]" maxlength="100" tabindex="4" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Sort*</label>
              <div class="col-sm-9">
                <input type="number" id="sort" class="form-control" placeholder="[10]" tabindex="5" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Icon Path</label>
              <div class="col-sm-9">
                <input id="iconPath" class="form-control" placeholder="[menu-icon.png]" maxlength="100" tabindex="6">
              </div>
            </div>
            <div class="btn-form-save">
              <button id="btn-clear" class="btn btn-warning" type="reset">Clear</button>
              <button id="btn-save" class="btn btn-primary" type="submit" tabindex="12">Save</button>
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
