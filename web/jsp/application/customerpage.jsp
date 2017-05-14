<%-- 
    Document   : customerpage
    Created on : Mar 25, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/customer.js"></script-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="customer" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-6">
          <input id="inputFind" class="form-control" placeholder="Golongan | Polis No | Polis Holder"
                 ng-model="inputFind" ng-init="inputFind=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Golongan</th>
              <th>No Polis</th>
              <th>Pemilik Polis</th>
              <th>Polis Issue Date</th>
              <th>Polis Close Date</th>
              <th>Is Valid</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.customerId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.golongan.golonganName}}</td>
              <td>{{data.polisNo}}</td>
              <td>{{data.polisHolder}}</td>
              <td>{{data.polisIssueDate}}</td>
              <td>{{data.polisCloseDate}}</td>
              <td><img src="../../img/icon/ok-icon.png" alt="Ok" ng-show="data.isValidReimburse==='Y'"/></td>
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
            <input type="hidden" id="customerId">
            <input type="hidden" id="createdBy">
            <div class="form-group">
              <label class="col-sm-4 control-label">Golongan*</label>
              <div class="col-sm-8">
                <select id="golonganId" class="form-control" tabindex="1" required autofocus>
                  <option ng-repeat="drop in datadrop.golongan" value="{{drop.golonganId}}">{{drop.golonganName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">No Polis*</label>
              <div class="col-sm-8">
                <input id="polisNo" class="form-control" placeholder="[4030080808098]" maxlength="100" tabindex="2" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Pemilik Polis*</label>
              <div class="col-sm-8">
                <input id="polisHolder" class="form-control" placeholder="[Awaludin]" maxlength="100" tabindex="3" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Polis Issue Date</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="polisIssueDate" class="form-control" placeholder="[2017-03-07]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="4">
                  <div class="input-group-btn">
                    <button id="btn-datepicker1" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Polis Close Date</label>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="polisCloseDate" class="form-control" placeholder="[2017-03-07]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="5">
                  <div class="input-group-btn">
                    <button id="btn-datepicker2" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Is Valid*</label>
              <div class="col-sm-1">
                <input type="checkbox" id="isValidReimburse" class="form-control checkbox" tabindex="6" required ng-checked="isValid==='Y'" ng-model="isValid" ng-true-value="Y" ng-false-value="N">
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
