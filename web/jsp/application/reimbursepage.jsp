<%-- 
    Document   : reimbursepage
    Created on : Apr 12, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/reimburse.js"></script-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="reimburse" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-4">
          <input id="inputFind" class="form-control" placeholder="Peserta | Deskripsi"
                 ng-model="inputFind" ng-init="inputFind=''">
        </div>
        <div class="col-sm-7">
          <div class="col-sm-6">
            <input id="startDateFind" class="form-control" placeholder="Trans Date From [yyyy-mm-dd]" ng-model="startDate" ng-init="startDate=''">
          </div>
          <div class="col-sm-6">
            <input id="endDateFind" class="form-control" placeholder="Trans Date To [yyyy-mm-dd]" ng-model="endDate" ng-init="endDate=''">
          </div>
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Input Date</th>
              <th>Trans Date</th>
              <th>Peserta</th>
              <th>Deskripsi</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.rumahSakitId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.reimburseDate}}</td>
              <td>{{data.reimburseTransDate}}</td>
              <td>{{data.peserta.pesertaName}}</td>
              <td>{{data.reimburseDesc}}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div id="pagination" style="text-align: center">
        <ul class="pagination"></ul>
      </div>
    </div>
  </div>
    
  <div class="modal fade modal-two-columns" id="mdl-save-record" tabindex="-1" role="dialog" aria-labelledby="save-record-title" aria-hidden="true">
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
            <input type="hidden" id="reimburseId">
            <input type="hidden" id="createdBy">
            <div class="form-group">
              <label class="col-sm-2 control-label">Input Date</label>
              <div class="col-sm-2">
                <input id="reimburseDate" class="form-control" tabindex="1" readonly>
              </div>
              <!--div class="col-sm-1 col-sm-offset-4">
                <img id="img-detail-record" class="img-record img-record-medium" src="../../img/icon/menu-icon.png" alt="Option icon" title="Detail"/>
              </div-->
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Trans Date*</label>
              <div class="col-sm-2">
                <div class="input-group">
                  <input id="reimburseTransDate" class="form-control" placeholder="[yyyy-mm-dd]" pattern="^(19|20)\d\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$" title="(yyyy-mm-dd)" tabindex="2" required>
                  <div class="input-group-btn">
                    <button id="btn-reimbursedate" class="btn btn-info" type="button"><span class="glyphicon glyphicon-calendar"></span></button>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Peserta*</label>
              <div class="col-sm-4">
                <select id="userId" class="form-control" tabindex="3" required>
                  <option ng-repeat="drop in datadrop.peserta" value="{{drop.pesertaId}}">{{drop.pesertaName}}</option>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-2 control-label">Deskripsi</label>
              <div class="col-sm-4">
                <textarea id="reimburseDesc" class="form-control" placeholder="[Pengobatan alternatif]" maxlength="255" tabindex="4"></textarea>
              </div>
            </div>
            <div>
              <ul class="nav nav-tabs nav-justified">
                <li class="active"><a href="#">Detail</a></li>
                <li id="obat-tab"><a href="#">Obat</a></li>
                <li id="tindakan-tab"><a href="#">Tindakan</a></li>
              </ul>
            </div>
            <div id="new-record-det">
              <div class="img-container">
                <img id="img-new-record-det">
              </div>
            </div>
            <div id="detail-tab" class="table-detail">
              <table class="table table-bordered table-condensed">
                <thead>
                  <tr>
                    <th>             
                    </th>
                    <th>Tipe Dokter</th>
                    <th>Is Emergency</th>
                    <th>Is Admin Fee</th>
                    <th>Revisi Admin Fee</th>
                  </tr>
                </thead>
                <tbody>
                  <tr ng-repeat="datadet in datatabledet" data-id="{{datadet.reimburseDetId}}">
                    <td>
                      <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(datadet)"/>
                      <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
                    </td>
                    <td>{{datadet.doctorType.parameterDetName}}</td>
                    <td>{{datadet.isEmergency}}</td>
                    <td>{{datadet.isAdminFee}}</td>
                    <td>{{datadet.adminFeeRev}}</td>
                  </tr>
                </tbody>
              </table>
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
    
  <div class="modal fade" id="mdl-detail-record" tabindex="-1" role="dialog" aria-labelledby="detail-record-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="detail-record-title">
            <img src="../../img/icon/menu-icon.png" alt="Detail icon"/>&nbsp<span>Detail Record</span>
          </h4>
        </div>
        <div class="modal-body">
          <form id="form-save" class="form-horizontal">
            <input type="hidden" id="reimburseDetId">
            <input type="hidden" id="reimburseId">
            <input type="hidden" id="createdBy">
            <div class="form-group">
              <label class="col-sm-4 control-label">Tipe Dokter*</label>
              <div class="col-sm-5">
                <select id="doctorTypeId" class="form-control" tabindex="1" required autofocus>
                  <option ng-repeat="drop in datadrop.parameter_dokter" value="{{drop.parameterDetId}}">{{drop.parameterDetName}}</option>
                </select>
              </div>
              <div class="col-sm-2 col-sm-offset-1">
                <img id="img-obat-record" class="img-record img-record-medium" src="../../img/icon/obat-icon.png" alt="Obat icon" title="Obat"/>&nbsp;
                <img id="img-tindakan-record" class="img-record img-record-medium" src="../../img/icon/tindakan-icon.png" alt="Tindakan icon" title="Tindakan"/>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Is Emergency*</label>
              <div class="col-sm-1">
                <input type="checkbox" id="isEmergency" class="form-control checkbox" value="true" tabindex="2">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Is Admin Fee*</label>
              <div class="col-sm-1">
                <input type="checkbox" id="isAdminFee" class="form-control checkbox" value="true" tabindex="3" checked>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Revisi Admin Fee</label>
              <div class="col-sm-8">
                <input type="number" id="adminFeeRev" class="form-control" placeholder="[250000]" pattern="^\d+(\.|\,)\d{2}$" tabindex="4">
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
    
  <div class="modal fade" id="mdl-obat-record" tabindex="-1" role="dialog" aria-labelledby="obat-record-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="obat-record-title">
            <img src="../../img/icon/obat-icon.png" alt="Obat icon"/>&nbsp<span>Obat Record</span>
          </h4>
        </div>
        <div class="modal-body">
          <form id="form-save" class="form-horizontal">
            <input type="hidden" id="reimburseObatId">
            <input type="hidden" id="reimburseId">
            <input type="hidden" id="createdBy">
            <div class="form-group">
              <label class="col-sm-3 control-label">Obat*</label>
              <div class="col-sm-9">
                <select id="obatId" class="form-control" tabindex="1" required autofocus ng-model="obat"
                      ng-options="drop.obatName for drop in datadrop.obat track by drop.obatId">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Deskripsi</label>
              <div class="col-sm-9">
                <label id="obatDesc" class="form-control" ng-bind="obat.obatDesc"></label>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Harga</label>
              <div class="col-sm-9">
                <label id="obatPrice" class="form-control" ng-bind="obat.obatPrice"></label>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Revisi Harga</label>
              <div class="col-sm-9">
                <input type="number" id="obatPriceRev" class="form-control" placeholder="[250000]" pattern="^\d+(\.|\,)\d{2}$" tabindex="2">
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
    
  <div class="modal fade" id="mdl-tindakan-record" tabindex="-1" role="dialog" aria-labelledby="tindakan-record-title" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="obat-tindakan-title">
            <img src="../../img/icon/tindakan-icon.png" alt="Tindakan icon"/>&nbsp<span>Tindakan Record</span>
          </h4>
        </div>
        <div class="modal-body">
          <form id="form-save" class="form-horizontal">
            <input type="hidden" id="reimburseTindakanId">
            <input type="hidden" id="reimburseId">
            <input type="hidden" id="createdBy">
            <div class="form-group">
              <label class="col-sm-3 control-label">Jenis Tindakan*</label>
              <div class="col-sm-9">
                <select id="tindakanId" class="form-control" tabindex="1" required autofocus ng-model="tindakan"
                      ng-options="drop.tindakanDesc for drop in datadrop.tindakan track by drop.tindakanId">
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Biaya</label>
              <div class="col-sm-9">
                <label id="obatDesc" class="form-control" ng-bind="tindakan.tindakanCost"></label>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-3 control-label">Revisi Biaya</label>
              <div class="col-sm-9">
                <input type="number" id="tindakanCostRev" class="form-control" placeholder="[250000]" pattern="^\d+(\.|\,)\d{2}$" tabindex="2">
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
