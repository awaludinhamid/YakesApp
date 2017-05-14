<%-- 
    Document   : coapage
    Created on : Apr 03, 2017, 11:58:08 AM
    Author     : awal
--%>

<!--%@include file="../support/application.jsp" %-->
<!DOCTYPE html>

<html>
  <head>
    <!--script src="../../js/application/coa.js"></script-->
    <script>
      localStorage.setItem("previousUrl",window.location.href);
      window.location.replace("../../apps/main/application");
    </script>
  </head>
<body>
  <div id="coa" class="target-div" hidden>
  <div id="page-content-wrapper">
    <div class="container">
      <div class="find-record form-group">
        <div class="col-sm-6">
          <input id="inputFind" class="form-control" placeholder="Local Code | Govern Code | Name | Description"
                 ng-model="inputFind" ng-init="inputFind=''">
        </div>
      </div>
      <div id="div-table" class="table-container">
        <table id="tbl-data" class="table table-bordered table-condensed">
          <thead>
            <tr>
              <th>             
              </th>
              <th>Local Code</th>
              <th>Government Code</th>
              <th>Name</th>
              <th>Description</th>
              <th>Parent COA</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="data in datatable" data-id="{{data.coaId}}">
              <td>
                <img id="img-edit-record" class="img-record img-record-small" src="../../img/icon/edit-icon.png" alt="Edit icon" title="Edit Record" ng-click="storearr(data)"/>
                <img id="img-delete-record" class="img-record img-record-small" src="../../img/icon/delete-icon.png" alt="Delete icon" title="Delete Record"/>
              </td>
              <td>{{data.coaLocalCode}}</td>
              <td>{{data.coaGovCode}}</td>
              <td>{{data.coaName}}</td>
              <td>{{data.coaDesc}}</td>
              <td>{{data.coaParent.coaName}}</td>
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
            <input type="hidden" id="coaId">
            <input type="hidden" id="createdBy">
            <div class="form-group">
              <label class="col-sm-4 control-label">Local Code*</label>
              <div class="col-sm-8">
                <input id="coaLocalCode" class="form-control" placeholder="[12-32345-10-09]" maxlength="100" tabindex="1" required autofocus>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Government Code</label>
              <div class="col-sm-8">
                <input id="coaGovCode" class="form-control" placeholder="[12345678]" maxlength="100" tabindex="2">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Name*</label>
              <div class="col-sm-8">
                <input id="coaName" class="form-control" placeholder="[Asset]" maxlength="255" tabindex="3" required>
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Description</label>
              <div class="col-sm-8">
                <input id="coaDesc" class="form-control" placeholder="[Kumpulan aset perusahaan]" maxlength="500" tabindex="4">
              </div>
            </div>
            <div class="form-group">
              <label class="col-sm-4 control-label">Parent COA</label>
              <div class="col-sm-8">
                <select id="coaParentId" class="form-control" tabindex="5">
                  <option ng-repeat="drop in datadrop.coa" value="{{drop.coaId}}">{{drop.coaName}}</option>
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
