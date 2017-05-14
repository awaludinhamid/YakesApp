<%-- 
    Document   : obatpage
    Created on : Mar 25, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/obat.js"></script-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="obat" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-6">
          <input id="inputFind" class="form-control" placeholder="Kode Obat | Nama Obat | Deskripsi"
                 ng-model="inputFind" ng-init="inputFind=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Kode Obat</th>
              <th>Nama Obat</th>
              <th>Deskripsi</th>
              <th>Harga</th>
              <th>Satuan</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.obatId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.obatCode}}</td>
              <td>{{data.obatName}}</td>
              <td>{{data.obatDesc}}</td>
              <td>{{data.obatPrice}}</td>
              <td>{{data.obatUnit.parameterDetName}}</td>
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
            <input type="hidden" id="obatId">
            <input type="hidden" id="createdBy">
            <div class="form-group">
              <label class="col-sm-4 control-label">Kode Obat*</label>
              <div class="col-sm-8">
                <input id="obatCode" class="form-control" placeholder="[PAR]" maxlength="20" tabindex="1" required autofocus>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Nama Obat</label>
              <div class="col-sm-8">
                <input id="obatName" class="form-control" placeholder="[Paracetamol]" maxlength="255" tabindex="2" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Deskripsi</label>
              <div class="col-sm-8">
                <textarea id="obatDesc" class="form-control" placeholder="[Obat penurun panas dengan kandungan eufenedrin 5mg]" maxlength="500" tabindex="3"></textarea>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Harga</label>
              <div class="col-sm-8">
                <input type="number" id="obatPrice" class="form-control" placeholder="[30000]" maxlength="12" tabindex="4">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Satuan</label>
              <div class="col-sm-8">
                <select id="obatUnitId" class="form-control" tabindex="5">
                  <option ng-repeat="drop in datadrop.parameter_obatunit" value="{{drop.parameterDetId}}">{{drop.parameterDetName}}</option>
                </select>
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
