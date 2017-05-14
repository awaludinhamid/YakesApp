/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
dataIdField = "pesertaId";
objRelMap = [{name: "customer", field: [{column: "customerId", id: "customerId"}]},
              {name: "identityType", field: [{column: "parameterDetId", id: "identityTypeId"}]},
              {name: "maritalStatus", field: [{column: "parameterDetId", id: "maritalStatusId"}]},
              {name: "polisHolderRelation", field: [{column: "parameterDetId", id: "polisHolderRelationId"}]},
              {name: "education", field: [{column: "parameterDetId", id: "educationId"}]}];
dropdownArr = ["customer","parameter_identitytype","parameter_maritalstatus","parameter_polisholderrelation","parameter_education"];

$(document).ready(function() {
  
  //date picker
  var datepicker1 = datePicker(".input-group input#birthOfDate");
  //
  $("button#btn-datepicker1").click(function() {
    datepicker1.datepicker("show");
  });
  
});