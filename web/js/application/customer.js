/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "customerId";
objRelMap = [{name: "golongan", field: [{column: "golonganId", id: "golonganId"}]}];
dropdownArr = ["golongan"];

$(document).ready(function() {
  
  //date picker
  var datepicker1 = datePicker(".input-group input#polisIssueDate");
  var datepicker2 = datePicker(".input-group input#polisCloseDate");
  //
  $("button#btn-datepicker1").click(function() {
    datepicker1.datepicker("show");
  });
  $("button#btn-datepicker2").click(function() {
    datepicker2.datepicker("show");
  });
  
});