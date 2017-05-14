/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
 
  //
  $("div#user-menu").hide();
  
  //
  if($("div>span#has-role").text() === "no") {
    $("div#validation-alert-mdl").modal("show");
  } else {
    // generate menu
    $.get(relativePath+"apps/data/usermenu/"+$("div>span#userid").text(), {}, function(data, status) {
      if(data.length === 0) {
        $("div#validation-alert-mdl").modal("show");
      } else {
        var prevparent = "";
        var urlredirect = "";
        var userMenuArr = [];
        $.each(data,function(idx,val) {
          if(val.parentMenu.parentMenuCode === prevparent) {
            userMenuArr.push({
              "idx": idx,
              "val":"<li data-save-url='"+val.menuPage.replace("/application/","/save/")+
                      "' data-data-url='"+val.menuPage.replace("/application/","/data/")+ 
                      "' data-js-url='"+val.menuPage.replace("apps/","js/")+".js"+ 
                      "' data-css-url='"+val.menuPage.replace("apps/","css/")+".css"+   
                      "' data-page='"+val.menuPage.replace("apps/application/","")+"'>"+                  
                      "<a href='"+relativePath+val.menuPage+"'>"+
                        "<img class='img-record img-record-medium' src='"+relativePath+"img/icon/"+val.iconPath+"' alt='"+val.iconPath+"'/>&nbsp;"+val.menuName+
                      "</a></li>"});
          } else {
            var separator = "";
            if(idx === 0)
              urlredirect = val.menuPage;
            else
              separator = "<li><hr/></li>";
            userMenuArr.push({
              "idx": idx,
              "val":separator +
                    "<li class='label-menu' id='"+val.parentMenu.parentMenuName.replace(" ","")+"'>"+val.parentMenu.parentMenuName+"</li>" +
                    "<li data-save-url='"+val.menuPage.replace("/application/","/save/")+
                      "' data-data-url='"+val.menuPage.replace("/application/","/data/")+ 
                      "' data-js-url='"+val.menuPage.replace("apps/","js/")+".js"+ 
                      "' data-css-url='"+val.menuPage.replace("apps/","css/")+".css"+   
                      "' data-page='"+val.menuPage.replace("apps/application/","")+"'>"+                    
                      "<a href='"+relativePath+val.menuPage+"'>"+
                        "<img class='img-record img-record-medium' src='"+relativePath+"img/icon/"+val.iconPath+"' alt='"+val.iconPath+"'/>&nbsp;"+val.menuName+
                      "</a></li>"});
            prevparent = val.parentMenu.parentMenuCode;
          }      
        });
        //save menu
        localStorage.setItem("userMenuArr", JSON.stringify(userMenuArr));
        //save default menu and redirect
        localStorage.setItem("defaultAppUrl",relativePath+urlredirect);
        window.location.replace(relativePath+urlredirect);
      }
    });
  }
  //
  $("div#validation-alert-mdl").on("hidden.bs.modal",function() {
    $("#form-logout>form").submit();
  });
  
});
