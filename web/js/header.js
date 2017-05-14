/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//
var csrfParamName;
var csrfToken;

$(document).ready(function() {

  //controlling user visibility
  if($("span#username").text().length > 0) {
    $("div#user-menu").show();  
    // records per page
    var recordsPerPage = localStorage.getItem("recordsPerPage");
    if(!recordsPerPage)
      localStorage.setItem("recordsPerPage",$("span#paging-records").text());
  } else {
    $("div#user-menu").hide();
    if(window.location.pathname.indexOf("/login") === -1) {
      $("div#form-logout>form").submit();
    }
  }
    
  //logout
  $("#btn-logout").click(function(evt) {
    evt.preventDefault();
    $.get(relativePath+"apps/auth/currentsession", {}, function(data) {
      if(data === $("span#sessionid").text())        
        $("div#form-logout>form").submit();
      else
        window.location.replace(relativePath+"apps/auth/login");
    });
  });
  
  //change password
  $("#change-pass").click(function() {
    var changePassMdl = $("div#change-pass-mdl");
    changePassMdl.find("input#new-password, input#con-new-password").val("");
    changePassMdl.find("input#old-password").val(localStorage.getItem("userPassword"));
    changePassMdl.modal("show");
  });
  
  //
  $("form#form-change-pass").on("submit",function() {
    if($(this).find("input#old-password").val() === $(this).find("input#new-password").val()) {
      alert("Password have not been changed");
      return false;
    }
    if($(this).find("input#new-password").val() !== $(this).find("input#con-new-password").val()) {
      alert("New password mismatch");
      return false;
    }
    localStorage.setItem("userPassword",$(this).find("input#new-password").val());
  });
  
  //keep current password
  $("form#form-login").on("submit", function() {
    localStorage.setItem("userPassword",$(this).find("input#password").val());
  });
});
