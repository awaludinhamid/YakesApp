/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "reimburseId";
objRelMap = [{name: "peserta", field: [{column: "pesertaId", id: "pesertaId"}]}];
dropdownArr = ["peserta","parameter_dokter","obat","tindakan"];
hasExtraClass = true;

$(document).ready(function() {
  //
  var currDiv = "div#reimburse";
  var reimbursedatepicker;
  var scope = $(elementScope).scope();
  
  if($(currDiv).length) {
    scope.compileObject($("div#mdl-detail-record"));
    scope.compileObject($("div#mdl-obat-record"));
    scope.compileObject($("div#mdl-tindakan-record"));
    reimbursedatepicker = datePicker(currDiv + " input#reimburseTransDate");
  }
  
  //
  $(currDiv + " button#btn-reimbursedate").click(function() {
    reimbursedatepicker.datepicker("show");
  });
  
  //
  $(currDiv + " div.find-record, table ").on("click","div.img-container>img#img-new-record, td>img#img-edit-record",function() {
    var todayStr = $.format.date(new Date(), "yyyy-MM-dd");
    $(currDiv + " input#reimburseDate").val(todayStr);
    $(currDiv + " input#reimburseDate").prop("defaultValue",todayStr);
    $(currDiv + " input#reimburseTransDate").val(todayStr);
    $(currDiv + " input#reimburseTransDate").prop("defaultValue",todayStr);
  });
  
  //
  $(currDiv + " img#img-detail-record").click(function() {
    $("div#mdl-detail-record").modal("show");
  });
  
  //
  $(currDiv + " img#img-obat-record").click(function() {
    scope.obat = scope.datadrop.obat[0];
    scope.$apply();
    $("div#mdl-obat-record").modal("show");
  });
  
  //
  $(currDiv + " img#img-tindakan-record").click(function() {
    scope.tindakan = scope.datadrop.tindakan[0];
    scope.$apply();
    $("div#mdl-tindakan-record").modal("show");
  });
});