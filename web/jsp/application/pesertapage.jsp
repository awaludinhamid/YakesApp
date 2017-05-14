<%-- 
    Document   : pesertapage
    Created on : Mar 25, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/peserta.js"></script-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="peserta" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-6">
          <input id="inputFind" class="form-control" placeholder="No Peserta | Nama Peserta"
                 ng-model="inputFind" ng-init="inputFind=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>No</th>
              <th>Nama</th>
              <th>Pemilik Polis</th>
              <th>Tipe Identitas</th>
              <th>No Identitas</th>
              <th>Tempat&comma;&nbsp;Tgl Lahir</th>
              <th>Status Pernikahan</th>
              <th>Hub dg Pemilik</th>
              <th>Pendidikan</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.pesertaId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.pesertaNo}}</td>
              <td>{{data.pesertaName}}</td>
              <td>{{data.customer.polisHolder}}</td>
              <td>{{data.identityType.parameterDetName}}</td>
              <td>{{data.identityNo}}</td>
              <td>{{data.placeOfBirth}}&comma;&nbsp;{{data.birthOfDate}}</td>
              <td>{{data.maritalStatus.parameterDetName}}</td>
              <td>{{data.polisHolderRelation.parameterDetName}}</td>
              <td>{{data.education.parameterDetName}}</td>
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
            <input type="hidden" id="pesertaId">
            <input type="hidden" id="createdBy">
            <div class="form-group">
              <label class="col-sm-4 control-label">Pemilik Polis*</label>
              <div class="col-sm-8">
                <select id="customerId" class="form-control" tabindex="1" required autofocus>
                  <option ng-repeat="drop in datadrop.customer" value="{{drop.customerId}}">{{drop.polisHolder}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">No Peserta*</label>
              <div class="col-sm-8">
                <input id="pesertaNo" class="form-control" placeholder="[4030080808098]" maxlength="100" tabindex="2" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Nama Peserta*</label>
              <div class="col-sm-8">
                <input id="pesertaName" class="form-control" placeholder="[Awaludin]" maxlength="100" tabindex="3" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Tipe Identitas</label>
              <div class="col-sm-8">
                <select id="identityTypeId" class="form-control" tabindex="4">
                  <option ng-repeat="drop in datadrop.parameter_identitytype" value="{{drop.parameterDetId}}">{{drop.parameterDetName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">No Identitas</label>
              <div class="col-sm-8">
                <input id="identityNo" class="form-control" placeholder="[459431919283892]" maxlength="100" tabindex="5">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Tempat, Tgl Lahir</label>
              <div class="col-sm-4">
                <input id="placeOfBirth" class="form-control" placeholder="[Jakarta]" maxlength="100" tabindex="6">
              </div>
              <div class="col-sm-4">
                <div class="input-group">
                  <input id="birthOfDate" class="form-control" placeholder="[1960-03-07]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="7" required>
                  <div class="input-group-btn">
                    <button id="btn-datepicker1" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Status Pernikahan</label>
              <div class="col-sm-8">
                <select id="maritalStatusId" class="form-control" tabindex="8">
                  <option ng-repeat="drop in datadrop.parameter_maritalstatus" value="{{drop.parameterDetId}}">{{drop.parameterDetName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Hub dg Pemilik</label>
              <div class="col-sm-8">
                <select id="polisHolderRelationId" class="form-control" tabindex="9">
                  <option ng-repeat="drop in datadrop.parameter_polisholderrelation" value="{{drop.parameterDetId}}">{{drop.parameterDetName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Pendidikan</label>
              <div class="col-sm-8">
                <select id="educationId" class="form-control" tabindex="8">
                  <option ng-repeat="drop in datadrop.parameter_education" value="{{drop.parameterDetId}}">{{drop.parameterDetName}}</option>
                </select>
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
