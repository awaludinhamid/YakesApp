<%-- 
    Document   : userpage
    Created on : Feb 14, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/user.js"></script-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="user" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-6">
          <input id="inputFind" class="form-control" placeholder="User Code | User Name"
                 ng-model="inputFind" ng-init="inputFind=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>User Code</th>
              <th>User Name</th>
              <th>Password</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.userId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.userCode}}</td>
              <td>{{data.userName}}</td>
              <td>{{data.userPassword}}</td>
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
            <input type="hidden" id="userId">
            <input type="hidden" id="createdBy">
            <input type="hidden" id="userPassword" value="{{userPassword}}">
            <div class="form-group">
              <label class="col-sm-4 control-label">Code*</label>
              <div class="col-sm-8">
                <input id="userCode" class="form-control" placeholder="[admin]" pattern="[a-zA-Z0-9]+" maxlength="20" tabindex="1" required autofocus>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Name*</label>
              <div class="col-sm-8">
                <input id="userName" class="form-control" placeholder="[Administrator]" maxlength="255" tabindex="3" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Password*</label>
              <div class="col-sm-8">
                <input type="password" id="user-password" class="form-control" placeholder="[**********]" pattern=".{6,}" maxlength="10" tabindex="4" required ng-model="userPassword" title="min length: 6">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Confirm Password*</label>
              <div class="col-sm-8">
                <input type="password" id="con-user-password" class="form-control" placeholder="[**********]" pattern=".{6,}" maxlength="10" tabindex="5" required title="min length: 6">
              </div>
            </div>
            <div class="btn-form-save">
              <button id="btn-clear" class="btn btn-warning" type="reset">Clear</button>
              <button id="btn-save" class="btn btn-primary" type="submit" tabindex="11">Save</button>
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
