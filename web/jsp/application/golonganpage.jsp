<%-- 
    Document   : golonganpage
    Created on : Mar 25, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/golongan.js"></script-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="golongan" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-6">
          <input id="inputFind" class="form-control" placeholder="Golongan Code | Golongan Name | Position Desc"
                 ng-model="inputFind" ng-init="inputFind=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Golongan Code</th>
              <th>Golongan Name</th>
              <th>Position</th>
              <th>Kelas</th>
              <th>Maks Cover Kamar/Hari (Rp)</th>
              <th>Maks Cover Per Year (Rp)</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.golonganId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.golonganCode}}</td>
              <td>{{data.golonganName}}</td>
              <td>{{data.positionDesc}}</td>
              <td>{{data.classRoom}}</td>
              <td>{{data.roomdayCostMaxSupport}}</td>
              <td>{{data.yearCostMaxSupport}}</td>
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
            <input type="hidden" id="golonganId">
            <input type="hidden" id="createdBy">
            <div class="form-group">
              <label class="col-sm-4 control-label">Code*</label>
              <div class="col-sm-8">
                <input id="golonganCode" class="form-control" placeholder="[GOL1]" maxlength="20" tabindex="1" required autofocus>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Name</label>
              <div class="col-sm-8">
                <input id="golonganName" class="form-control" placeholder="[Golongan 1]" maxlength="255" tabindex="2">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Position</label>
              <div class="col-sm-8">
                <input id="positionDesc" class="form-control" placeholder="[Direksi/SPV]" maxlength="255" tabindex="3">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Kelas Kamar</label>
              <div class="col-sm-8">
                <input id="classRoom" class="form-control" placeholder="[VIP]" maxlength="100" tabindex="4">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Maks Cover Kamar/Hari (Rp)</label>
              <div class="col-sm-8">
                <input type="number" id="roomdayCostMaxSupport" class="form-control" placeholder="[450000]" maxlength="12" tabindex="5" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Maks Cover Per Year (Rp)</label>
              <div class="col-sm-8">
                <input type="number" id="yearCostMaxSupport" class="form-control" placeholder="[50000000]" maxlength="12" tabindex="6" required>
              </div>
            </div>
            <div class="btn-form-save">
              <button id="btn-clear" class="btn btn-warning" type="reset">Clear</button>
              <button id="btn-save" class="btn btn-primary" type="submit" tabindex="15">Save</button>
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
