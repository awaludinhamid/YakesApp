/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


  
startAnimation();

/*** GLOBAL VARIABLE ***/

//id for identifier, ie. coyId for identify company object
var dataIdField; 

//object must be cast to scalar so it must be represented by its relation identifier
//ie. in json {id:1,name:"xxx",data:{id:1,name:"yyyy"}} object data represented by id of data
//format [name: "data", field: [{column: "id", id: "id"}]]
//column name in database may be different with id name in html tag
var objRelMap = []; 

//scope name and url last path of drop down menu
//ie. ["coy"] will ask apps to create scope named datadrop.coy and retrieve its data from [app_url_path]/coy
var dropdownArr = [];

//we create new record and edit record in the same form, so to distinct them while showing the html tag use this array
//ie. ["user-password"] will show html tag with id "user-password" showing on new record only not on edit record process
var hideFieldOnUpdateArr = [];

//if modul has file to upload create this object
//format and sample {name:"appname",field:"field1"}, ask app to upload file with html tag id = "field1" to url [app_url_path]/appname/file
var uploadFileObj = {};

//compare two field value to validate
//format and sample [{field1:"field1",field2:"field2",alert:"alert message"}]
//will ask app to compare the value of two field, if mismatch then show "alert message"
var fieldToCheckBeforeSaveArr = [];

//we have to count how many animations have been started
//so they only stop when all animations have been done
var animationCount = 0;

//sometime there is data with no predefined object, so we have to get all of its columns and separeted them w/ delimiter
var delimiter = "|";

//saving master-detail data in one process
var masterDetailObj = {};

//update master data list need to specify some objects
var masterListUpdateOnly = {};

//simple form page do not need this (table contain data with supported tools like find button, new button, etc)
var loadInitListObj = true;

//if we need to replace functional image (find & new) with save image (in selected modul)
var replaceWithSaveImage = false;

//show find image only
var showFindImgOnly = false;

//if modul is find only modul, we need to check some objects
//must be used together with showFindImgOnly variable
var masterFindOnlyArr = [];

//scope we used to execute the angular
var elementScope = "div#content";// "div#page-content-wrapper";

//check date entered through pattern
var datePattern = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";

//we need to disable records instead of delete them
//each object in the list has two field, its name (fieldName) and where to grab its value (fieldValue)
var disableObjArr = [];

//if modul has specific separated class set this to 'true'
var hasExtraClass = false;

//add some extra scripts to modul than the default (usually [modul-name].js)
var extraScriptArr = [];

//this is an additional function that will only be executed if the data generating has been completed
var cbFuncGenData = function() {};

//if we have list of detail and need to check specific checked field may not be empty before save
var extraCheckFieldDetail = {};

//list catch error and its message: errTxt=error text to capture, errMsg=error message to prompt
var errorCaptureArr = [];

//check date input must be equal or greater than today
var isDateCheckToToday = false;

//variable modal message
var messageMdl = $("div#message-mdl");
var messageMdlContent = messageMdl.find(".modal-content");
var messageMdlTitle = messageMdlContent.find(".modal-title");
var messageMdlBody = messageMdlContent.find(".modal-body");
var backColInfo = "rgba(16,64,112,0.8)";
var backColError = "rgba(10,20,40,0.8)";
var mdlTitleInfo = "&nbsp;Information";
var mdlTitleError = "&nbsp;Error";
var mdlTitleClassInfo = "glyphicon glyphicon-info-sign";
var mdlTitleClassError = "glyphicon glyphicon-exclamation-sign";
var colInfo = "white";
var colError = "red";



/*** GLOBAL FUNCTION ***/

//
function startAnimation() {
  animationCount += 1;
  $(".back-cover").show();
  $(".back-cover, .red-ball, .blue-ball, .green-ball, .loading-text").css("animation-play-state","running");
}

//
function endAnimation() {
  animationCount -= 1;
  if(animationCount < 1) {
    $(".back-cover").hide();
    $(".back-cover, .red-ball, .blue-ball, .green-ball, .loading-text").css("animation-play-state","paused");
  }
}

//check requested current session(active/inactive) before execution
function checkCurrSessAndExec() {
  $.get(relativePath + "apps/auth/currentsession",function(data,status) {
    if(status === "success") {
      if(data != $("span#sessionid").text()) {
        window.location.reload();
      }
    } else {
      showErrorMessage("Get current session unsuccessfully: status = " + status);
    }
  }).fail(function(d) {
      showErrorMessage("Get current session unsuccessfully: status = " + d.status);
  });
}
 
//show warning/error message 
function showErrorMessage(msg) {
  messageMdlTitle.children("span:first-child").attr("class",mdlTitleClassError);
  messageMdlTitle.children("span:last-child").html(mdlTitleError);
  messageMdlContent.css("background-color",backColError).css("color",colError);
  messageMdlBody.html(msg);
  messageMdl.modal("show");
}

//show info message
function showInfoMessage(msg) {
  messageMdlTitle.children("span:first-child").attr("class",mdlTitleClassInfo);
  messageMdlTitle.children("span:last-child").html(mdlTitleInfo);
  messageMdlContent.css("background-color",backColInfo).css("color",colInfo);
  messageMdlBody.html(msg);
  messageMdl.modal("show");
}


/*** EVENT DRIVEN ***/

$(document).ready(function() {
  checkCurrSessAndExec();
  var scope;// = $(elementScope).scope();
  var activePage = $("div#sidebar-wrapper ul.sidebar-nav>li.active-page");
  var formInputFile;
  var modalSave = "div#mdl-save-record";
  var currPage = "";
  
  //
  var switchMenu = function(href) {    
    if(href.split("/").pop().indexOf("application") !== -1) {
      href = localStorage.getItem("defaultAppUrl");
    }
    $("div#content").load(href + " div.target-div",function() {
      //init
      objRelMap = [];
      dropdownArr = [];
      hideFieldOnUpdateArr = [];
      uploadFileObj = {};
      fieldToCheckBeforeSaveArr = [];
      animationCount = 0;
      masterDetailObj = {};
      masterListUpdateOnly = {};
      loadInitListObj = true;
      replaceWithSaveImage = false;
      showFindImgOnly = false;
      masterFindOnlyArr = [];
      disableObjArr = [];
      hasExtraClass = false;
      extraScriptArr = [];
      extraCheckFieldDetail = {};
      errorCaptureArr = [];
      cbFuncGenData = function() {};
      isDateCheckToToday = false;
      //

      $.getScript(relativePath + activePage.data("js-url"), function() {  
        
        //
        var initFunc = function() {
          //preparation
          history.pushState(null,null,href);
          $("div#content").children("div").show();
          scope = $(elementScope).scope();
          formInputFile = $("form#form-save input:file");
          scope.datatable = [];
          scope.addTitleAndFind(activePage);
          scope.compileObject($(modalSave));
          if(hasExtraClass)
            $("link#link-temp").attr("href",relativePath + activePage.data("css-url"));

          //dropdown
          if(dropdownArr.length > 0)
            $.each(dropdownArr,function(idx,val) {
              scope.initDropdown(relativePath+"apps/data",val);
            });

          //load data
          if(loadInitListObj) {
            currPageNo = 1;
            gendata();        
          }
        };
      
        //extra script
        if(extraScriptArr.length > 0) {
          $.each(extraScriptArr,function(idx,val) {   
            $.getScript(val, function() {
              initFunc();
            });
          });
        } else {
          initFunc();
        }
      });
      
      //
      
      /* binding event */
      
      //
      $(".table-container").scroll(function() {
        $(this).find("td:first-child")
                .css("transform","translateX(" + $(this).scrollLeft() + "px)");
      });
  
      //
      $(".table-container-normal").scroll(function() {
        $(this).find("th")
                .css("transform","translateY(" + $(this).scrollTop() + "px)");
      });
  
      //
      $("div#pagination>ul").on("click","li>a",function(evt) {    
        evt.preventDefault();
        clickPageNo("div#pagination>ul>li",this.parentNode.id,{},gendata);
      });
  
      //
      $("div.find-record").on("click", "div.img-container>img#img-find-record", function() {
        //
        var breakProcess = false;

        //specific checked
        //general value checked
        if(showFindImgOnly) {
          $.each(masterFindOnlyArr,function(idx,val) {
            var continued = true;
            $.each(val.fieldToCheck,function(idx1,val1) {          
              if($(val1).val() === "0") {          
                showErrorMessage(val.message);
                $(val1).addClass("back-error");
                animateStyle($(val1),[]);
                breakProcess = true;
                continued = false;
                return false;
              }
            });
            return continued;
          });    
          //validation failed, cancel the process
          if(breakProcess)
            return false;
        }

        //date format checked
        $.each(["input#asOfDate","input#startDateFind","input#endDateFind"],function(idx,val) {
          var currInputVal = $(val).val();
          if(currInputVal) {
            var $tooltipDate = $("div.tooltip-date");
            //var currInputVal = currInput.val();
            if(!(currInputVal.match(datePattern) || currInputVal === "")) {
              var currInputOff = $(val).offset();
              animateStyle($tooltipDate,[{styleProp:"transform",styleVal:"translate("+currInputOff.left+"px,"+(currInputOff.top - 20)+"px)"}]);
              breakProcess = true;
              return false;
            }
          }      
        });   
        //validation failed, cancel the process
        if(breakProcess)
          return false;

        //date value checked
        var $startDate = $("input#startDateFind");
        var startDate = $startDate.val();
        if(startDate) {
          var endDate = $("input#endDateFind").val();
          if(endDate) {
            if(startDate > endDate) {
              showErrorMessage("Start date must be earlier than end date ..!");
              $startDate.addClass("back-error");
              animateStyle($startDate,[]);
              return false;
            }
          }        
        }

        //ready to execute
        currPageNo = 1;
        gendata();

        //separate function
        //animate style
        function animateStyle(element,addStyleArr) {
          $.each(addStyleArr,function(idx,val) {
            element.css(val.styleProp,val.styleVal);
            element.css("webkit-" + val.styleProp,val.styleVal);
          });
          element.css("animation-play-state","running");
          element.css("webkit-animation-play-state","running");
          element.on("animationend webkitAnimationEnd", function() {
            element.css("animation-play-state","paused");
            element.css("webkit-animation-play-state","paused");
            //element.replaceWith(element.clone(true));
            element.removeClass("back-error");
          });
        }
      });
  
      //
      $("div.find-record, table ").on("click","div.img-container>img#img-new-record, td>img#img-edit-record",function() { 
        //
        //$("form#form-save input:not(:radio), form#form-save textarea").val("");
        $("form#form-save").trigger("reset");
        //    
        var dataId = $(this).parent("td").parent("tr").data("id");
        if(!(dataId === null || dataId === undefined)) {
          var dataArr = scope.dataarr;//getCurrDataObj(scope.datatable,dataId,dataIdField);
          $("form#form-save input:not(.data-detail), form#form-save textarea, form#form-save select:not(.select-exclude-scan)").each(function() {
            if($(this).is(":radio")) {
              if($(this).val() === dataArr[$(this).attr("name")])
                $(this).prop("checked",true);
            } else {
              $(this).val(dataArr[$(this).attr("id")]);
            }
            if($(this).is(":checkbox"))
              $(this).prop("checked",$(this).val()+""==="true");
          });
          if(objRelMap.length > 0) {
            $.each(objRelMap,function(idxClass,valClass) {
              $.each(valClass.field,function(idxField, valField) {
                var dataRelVal = dataArr[valClass.name] === null ? "" : dataArr[valClass.name][valField.column];
                $("form#form-save #"+valField.id).val(dataRelVal);
              });
            });
          }
          if(hideFieldOnUpdateArr.length > 0) {
            $.each(hideFieldOnUpdateArr,function(idx,val) {
              $("form#form-save div:has(input#"+val+")").prop("hidden",true);
              $("form#form-save #"+val).prop("required",false);
            });
          }
          //
          if(!$.isEmptyObject(masterDetailObj)) {
            $.each(masterDetailObj.data,function(idx,val) {
              var detailData = dataArr[val.edit];
              $.each(detailData,function(idxDet,valDet) {
                $("table#tbl-data-dtl tr").each(function() {
                  var fieldId = $(this).find("td#"+val.field.idName);
                  if(valDet[val.field.objName][val.field.idName] + "" === fieldId.children("span").text()) {
                    fieldId.children("input#inputVerif").prop("checked",true);
                    $(this).find("input:not(#inputVerif)").each(function() {
                      $(this).val(valDet[$(this).attr("id")]);
                    });
                    return false;
                  }
                });
              });
            });
          }
          $("div#mdl-save-record .modal-title>img").attr("src",relativePath+"img/icon/edit-icon.png");
          $("div#mdl-save-record .modal-title>span").text("Edit Record");
        } else {
          if(hideFieldOnUpdateArr.length > 0) {
            $.each(hideFieldOnUpdateArr,function(idx,val) {
              $("form#form-save div:has(input#"+val+")").prop("hidden",false);
              $("form#form-save #"+val).prop("required",true);
            });
          }
          $("form#form-save>input[type=hidden]:nth-child(1)").val("0");
          $("div#mdl-save-record .modal-title>img").attr("src",relativePath+"img/icon/new-icon.png");
          $("div#mdl-save-record .modal-title>span").text("New Record");      
        }
        //compile and show
        scope.$apply();
        $(modalSave).modal("show");      
      });
  
      //date picker
      var startdatepicker = datePicker(".input-group input#startDate");
      var enddatepicker = datePicker(".input-group input#endDate");
      //
      $("button#btn-startdate").click(function() {
        startdatepicker.datepicker("show");
      });  
      $("button#btn-enddate").click(function() {
        enddatepicker.datepicker("show");
      });
      //
      if($("input#startDateFind").length) {
        datePicker("input#startDateFind");
        datePicker("input#endDateFind");
      }
      if($("input#asOfDate").length)
        datePicker("input#asOfDate");
  
      //
      $("form#form-save").on("submit",function(evt) {
        evt.preventDefault();
        var status = true;
        var currForm = $(this);
        //end date must be greater or equal to start date
        if(new Date(currForm.find("input#startDate").val()) > new Date(currForm.find("input#endDate").val())) {
          showErrorMessage("Until/end date must be greater or equal to valid/start date")
          return false;
        }
        //saved end date must be greater or equal to today
        //disable through disable feature only
        if(new Date().setHours(0,0,0,0) > new Date(currForm.find("input#endDate").val())) {
          showErrorMessage("Please disable record via disable button ..!");
          return false;
        }
        //
        if(fieldToCheckBeforeSaveArr.length > 0) {
          $.each(fieldToCheckBeforeSaveArr,function(idx,val) {
            if(currForm.find("input#"+val.field1).val() !== currForm.find("input#"+val.field2).val()) {
              status = false;
              alert(val.alert);
              return false;
            }          
          });
        }
        //
        if(!$.isEmptyObject(extraCheckFieldDetail)) {
          var checkBoxName = "td>input#"+extraCheckFieldDetail.checkboxField;
          $.each(extraCheckFieldDetail.fields,function(idx,val) {
            var fieldName = val.fieldName;
            $("table#tbl-data-dtl tr").each(function() {
              if($(this).find(checkBoxName).is(":checked") && $(this).find("td>input#"+fieldName).val() === "") {
                status = false;
                alert(val.alert);
                return false;
              }
            });
            return status;
          });
        }
        if(isDateCheckToToday) {
          var today = new Date().setHours(0,0,0,0);
          if(today > new Date(currForm.find("input#startDate").val()) || today > new Date(currForm.find("input#endDate").val())) {
            showErrorMessage("Absence date must be equal or greater than today ..!");
            return false;
          }
        }
        if(status) {
          scope.saveData(relativePath + activePage.data("save-url") + "?" + $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text(),
                        formInputFile,
                        modalSave);
        }
      });
  
      //
      $("table ").on("click","td>img#img-delete-record",function() {
        //$("div#message-mdl .modal-body").html("Currently unavailable");
        //
        var $delmdl = $("div#delete-mdl");
        var $delmdlhead = $delmdl.find("thead>tr");
        var $delmdlbody = $delmdl.find("tbody>tr");
        //init
        $delmdlhead.empty();
        $delmdlbody.empty();
        //
        $.each(disableObjArr,function(idx,val) {
          $delmdlhead.append("<th>"+val.fieldName+"</th>");
          if(val.fieldValue.indexOf(".") > -1) {
            var fieldValueArr = val.fieldValue.split(".");
            $delmdlbody.append("<td>"+(scope.dataarr[fieldValueArr[0]][fieldValueArr[1]])+"</td>");
          } else {        
            $delmdlbody.append("<td>"+(scope.dataarr[val.fieldValue])+"</td>");      
          }
        });
        $delmdl.modal("show");    
      });
      
      //
      $("button#delete-confirm-btn").click(function() {
        //alert(scope.dataarr[dataIdField]);
        var formData = {};
        formData[dataIdField] = scope.dataarr[dataIdField];
        scope.saveDataNonAssign(relativePath + activePage.data("save-url") + "/disable?" + $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text(),
                        formData,function(response) {
          scope.getData(scope.url,scope.params);
          //
          if(response.data)
            $("div#delete-mdl").modal("hide");
        });
      });
  
      //  
      $("div.find-record").on("click", "div.img-container>img#img-save-record", function() {
        if(masterListUpdateOnly.updAssignObj && $(masterListUpdateOnly.updAssignObj).val() === "0") {
          showErrorMessage(masterListUpdateOnly.warnMessage[0]);
        } else if(masterListUpdateOnly.updCommissionObj && $(masterListUpdateOnly.updCommissionObj).val() === "0") {
          showErrorMessage(masterListUpdateOnly.warnMessage[1]);
        } else if(masterListUpdateOnly.updCommissionObj && 
                ($(masterListUpdateOnly.updCommissionObj).val() === $(masterListUpdateOnly.updAssignObj).val())) {
          showErrorMessage(masterListUpdateOnly.warnMessage[2]);
        } else if($("table#tbl-data>tbody>tr>td>input#inputVerif:checked").length === 0) {
          showErrorMessage("Nothing to save ..!");
        } else {
          scope.saveData(relativePath + activePage.data("save-url") + "?" + $("span#csrf-param-name").text() + "=" + $("span#csrf-token").text(),
                        formInputFile,
                        modalSave);
        }
      });
      
      /* end binding event */
    });
  };
  
  
  
  var switchActivePage = function($element) {
    var $parentThis = $element.parent("li");
    $parentThis.siblings("li").removeClass("active-page");
    $parentThis.addClass("active-page");
    activePage = $parentThis;
  };
    
  $(window).load(function() {
    var href = localStorage.getItem("previousUrl") || localStorage.getItem("defaultAppUrl");
    switchMenu(href);
    var page = href.split("/").pop();
    var sectionIdx = page.indexOf("#");
    if(sectionIdx > -1)
      page = page.substring(0,page.indexOf("#"));
    var $sidebarLi = $(".sidebar-nav li:has(a)");
    $sidebarLi.removeClass("active-page");
    $(".sidebar-nav li:has(a)").each(function() {
      if(page === $(this).children("a").attr("href").split("/").pop()) {
        $(this).addClass("active-page");
        activePage = $(this);
        var topPos = $(this).position().top;
        var parentHeight = $("div#sidebar-wrapper").height();
        if(topPos > (parentHeight/2)) {//move scrollbar to obj position if it over the limit (to prevent unseeing menu)
          $("div#sidebar-wrapper").scrollTop(topPos);        
        }
        return false;
      }
    });
  });

  $(window).bind("popstate",function() {
    switchMenu(window.location.href);
  });

  $("div#sidebar-wrapper ul.sidebar-nav ").on("click","li>a",function(evt) {
    evt.preventDefault();
    if(currPage !== $(this).attr("href")) {
      switchMenu($(this).attr("href"));
      switchActivePage($(this));
      currPage = $(this).attr("href");
    }
  }); 
      
  //
  var gendata = function() {
    //
    var paramInput = {};
    $("div.find-record select, div.find-record input").each(function() {
      var name = $(this).attr("ng-model");
      paramInput[name] = scope[name];
    });
    //
    scope.getData(relativePath + activePage.data("data-url")+"/"+currPageNo, paramInput);
  };
  
  //
  /*
  $(".modal").on("shown.bs.modal", function() {
    $(".modal-backdrop.in").hide();
  });*/
    
});

/********************************************/

  
/****** A N G U L A R   S E C T I O N ******/

//Setup angular modul
var angularApp = angular.module("angularApp",[]);

//own directive
angularApp.directive("fileModel", ["$parse", function ($parse) {
    return {
        restrict: "A",
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind("change", function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

//Setup service
angularApp.service("paramserv", ["$http", function($http) {
  
  //
  this.execajax = function (method, url, params, data, headers, callback) {
    checkCurrSessAndExec();
    startAnimation();
    var prop = {method: method,
                url: url,
                params: params,
                data: data,
                headers: headers/*,
                transformRequest: angular.identity*/
              };
    var showMessage = (method.toLowerCase() === "post" && url.indexOf("download") === -1);
    //
    $http(prop).then(function success(response){
      callback(response);
      if(showMessage) {
        if(response.data)
          showInfoMessage("Your change has been saved ..!");
        else
          showErrorMessage("Save got problem, your record may have relation ..!");
      }
    }, function error(response){      
      if(response.status !== undefined) {
        var showError = true;
        if(errorCaptureArr.length > 0) {
          var responseError = JSON.stringify(response.data);
          $.each(errorCaptureArr,function(idx,val) {
            if(responseError.indexOf(val.errTxt) > -1) {
              showErrorMessage(val.errMsg);
              showError = false;
              return false;
            }
          });
        }
        if(showError)
          showErrorMessage("Something wrong with the request..! (" + response.statusText + "):<br/>" +
                              "<ul>" +
                                "<li>Check the input constraint (duplicate key/value, parent-child integrity, etc)</li> " +
                                "<li>Still in the development phase, contact the developer</li>" +
                              "</ul>");
      } else if(showMessage) {
        if(response.data)
          showInfoMessage("Your change has been saved ..! status: " + response.status);
        else          
          showErrorMessage("Save got problem, your record may have relation ..!");
      } 
    }).finally(function() {  
      endAnimation();
    });
  };
  //
  this.uploadfile = function(url,formData,contentType,processData,cache,callback) {
    checkCurrSessAndExec();
    startAnimation();
    $.ajax({
      method: "POST",
      url: url,
      data: formData,
      contentType: contentType,
      processData: processData,
      cache: cache
    }).done(function(response) {
      showInfoMessage("Your change has been saved ..!");
      callback(response);
    }).fail(function(response) {
      var showError = true;
      if(errorCaptureArr.length > 0) {
        var responseError = JSON.stringify(response.responseText);
        $.each(errorCaptureArr,function(idx,val) {
          if(responseError.indexOf(val.errTxt) > -1) {
            showErrorMessage(val.errMsg);
            showError = false;
            return false;
          }
        });
      }
      if(showError)
        showErrorMessage("Oops something wrong with the uploaded file or the development ..!: " + response.status);
    }).always(function() {
      endAnimation();
    });
  };
}]);

angularApp.service("dataserv", function(paramserv) {
  //
  this.getData = function(url,params,callback) {
    paramserv.execajax("GET",url,params,null,{"Content-Type": "application/json"},callback);
  };
  //
  this.saveData = function(url,data,callback) {
    paramserv.execajax("POST",url,null,data,{"Content-Type": "application/json"},callback);
  };
  //
  this.postDataByParam = function(url,params,callback) {
    paramserv.execajax("POST",url,params,null,null,callback);
  };
  //
  this.uploadFile = function(url,params,callback) {
    var formData = new FormData();
    for(var key in params) {
      formData.append(key,params[key]);
    }
    paramserv.uploadfile(url,formData,false,false,false,callback);
  };
  //
  this.getDataNonJson = function(url,params,callback) {
    paramserv.execajax("GET",url,params,null,null,callback);
  };
});

angularApp.service("domserv", function() {
  //
  this.addTitleAndFind = function(activePage) {
    //
    var container = $("div#page-content-wrapper>div.container");
    
    // find & new
    if(loadInitListObj) {
      var $findRecord = $("div#page-content-wrapper>div.container div.find-record");
      var $imgContainer = $("<div>", {"class": "img-container"});
      
      $("<img>", 
        {"id": "img-find-record", "class": "img-record img-record-medium",
          "src": "../../img/icon/find-icon.png", "alt": "Find icon", "title": "Find Record"})
                .appendTo($imgContainer);
      if(replaceWithSaveImage) {
        $("<img>", 
          {"id": "img-save-record", "class": "img-record img-record-medium",
            "src": "../../img/icon/save-icon.png", "alt": "Save icon", "title": "Save Record"})
                  .appendTo($imgContainer);
        $imgContainer.find("img#img-find-record").prop("hidden",true);
      } else if(!showFindImgOnly) {
        $("<img>", 
          {"id": "img-new-record", "class": "img-record img-record-medium",
            "src": "../../img/icon/new-icon.png", "alt": "New icon", "title": "New Record"})
                  .appendTo($imgContainer);
      }
      
      $findRecord.append($imgContainer);
    }

    // title
    var $divTitle = $("<div>", {"class": "table-title"});
    $("<span>").text(activePage.children("a").text().trim()).appendTo($divTitle);
    container.prepend($divTitle);    
    
    return container;
  };
  //
  this.updatePaging = function(data) {
    execPaging(data.count);
  };
  //
  this.assignData = function() {
    var objData = {};
    if(!$.isEmptyObject(masterListUpdateOnly)) {
      var dataIdList = [];
      $("table#tbl-data>tbody>tr").each(function() {
        if($(this).find("td>input#inputVerif").prop("checked") === true) {
          dataIdList.push($(this).data("id"));
        }
      });
      if(dataIdList.length > 0) {
        if(masterListUpdateOnly.updVarName)
          objData[masterListUpdateOnly.updVarName] = $(masterListUpdateOnly.updAssignObj).val();
        objData[masterListUpdateOnly.updListIdName] = dataIdList;
      }      
    } else {
      $("form#form-save input:not(:file):not(.display-only):not(.data-detail), form#form-save textarea, form#form-save select").each(function() {
        if($(this).is(":checkbox")) 
          objData[$(this).attr("id")] = $(this).prop("checked")+"";
        else if($(this).is(":radio") && $(this).is(":checked"))
          objData[$(this).attr("name")] = $(this).val();
        else
          objData[$(this).attr("id")] = $(this).val();
      });
      //
      if(!$.isEmptyObject(masterDetailObj)) {
        $.each(masterDetailObj.data,function(idx,val) {
          var objOthArr = [];
          $("table#tbl-data-dtl>tbody>tr").each(function() {
            var objOth = {};
            if($(this).find("td>input#inputVerif").prop("checked") === true) {
              if(masterDetailObj.isFormOnly) { 
                for(var key in objData) {
                  if(objData.hasOwnProperty(key))
                    objOth[key] = objData[key];
                }
              }
              var tdId = $(this).children("td").eq(0);
              objOth[tdId.attr("id")] = tdId.children("span").text();
              $(this).children("td").each(function() {
                $(this).children("input:not(#inputVerif)").each(function() {
                  objOth[$(this).attr("id")] = $(this).val();
                });
              });
            }
            if(!$.isEmptyObject(objOth))
              objOthArr.push(objOth);
          });
          objData[val.new] = objOthArr;
        });
      }
    }
    //alert(JSON.stringify(objData));
    return objData;
  };
  
  this.showModal = function(modalName) {
    $(modalName).modal("show");
  };
  
  this.hideModal = function(modalName) {
    $(modalName).modal("hide");
  };
  
  this.resetInputVal = function() {
    var inputArr = [{name:"input#inputVerifAll",type:"checkbox"}];
    $.each(inputArr,function(idx,val) {
      if(val.type === "checkbox") {
        $(val.name).prop("checked",false);
      } else {
        $(val.name).val("");
      }
    });
  };
});

//Setup controller
angularApp.controller("angularCtrl", function($scope,$compile,dataserv,domserv) {
  //
  $scope.datadrop = {};
  
  //Show/hide item by comparing its value and the default
  $scope.hideItem = function(itemVal,defVal) {
    if(itemVal === defVal)
      return true;
    return false;
  };
  
  //check given conditional, set value if it is true/false
  $scope.setCondVal = function(cond, trueVal, falseVal) {
    if(cond)
      return trueVal;
    return falseVal;
  };
  
  //
  $scope.radioButton = function(radioEnable,currentValue,fieldValue) {
    if(radioEnable === "true") {
      if(currentValue === fieldValue)
        return "on";
      else
        return "off";
    } else {
      return "disable";
    }
  };
  
  //
  $scope.getData = function(url,params) {
    var updateDatatable = function(response) {
      $scope.datatable = response.data.content;
      domserv.updatePaging(response.data);
      $scope.url = url;
      $scope.params = params;
      cbFuncGenData();
    };
    dataserv.getData(url,params,updateDatatable);    
  };
  
  //
  $scope.initDropdown = function(pathUrl,pathName) {
    var updateDropdown = function(response) {
      var dataDropName = pathName;
      if(pathName.indexOf("/") > 0)
        dataDropName = pathName.split("/").pop();
      $scope.datadrop[dataDropName] = response.data;
    };
    dataserv.getData(pathUrl+"/"+pathName,{},updateDropdown);
  };
  
  //
  $scope.addTitleAndFind = function(activePage) {
    $compile(domserv.addTitleAndFind(activePage))($scope);
    //domserv.addTitleAndFind(activePage);
  };
  
  //
  $scope.saveData = function(url,formInputFile,modalSave) {
    $scope.$apply();
    var uploadFile = function(response) {
      if(formInputFile.val()) {
        var params = {};
        formInputFile.each(function() {
          params[$(this).attr("name")] = this.files[0];
        });
        params[uploadFileObj.field] = response.data[uploadFileObj.field];
        $scope.uploadFile(url.replace(uploadFileObj.name,uploadFileObj.name+"/file"),params,function(responseDown) {
          $scope.getData($scope.url,$scope.params);
          domserv.hideModal(modalSave);
        });
      } else {
        $scope.getData($scope.url,$scope.params);
        domserv.hideModal(modalSave);
      } 
      domserv.resetInputVal();
    };
    dataserv.saveData(url,domserv.assignData(),uploadFile);
    //domserv.assignData();
  };
  
  //
  $scope.initDropdownCommon = function(pathUrl,pathName,params,callback) {
    var updateDropdown = function(response) {
      $scope.datadrop[pathName] = response.data;
      callback(response);
    };
    dataserv.getData(pathUrl+"/"+pathName,params,updateDropdown);
  };
  
  //
  $scope.store = function(data) {
    $scope.data = data;
  };
  
  //
  $scope.storedd = function(drop) {
    $scope.datadd = drop;
  };
  
  $scope.storearr = function(dataarr) {
    $scope.dataarr = dataarr;
  };
  
  //
  $scope.switchValTo = function(valToSwitch,switchedVal,checkedVal) {
    if(valToSwitch === checkedVal)
      return switchedVal;
    return valToSwitch;
  };
  
  //
  $scope.initDataTableGeneric = function(pathUrl,pathName,params,callback) {
    dataserv.getData(pathUrl+"/"+pathName,params,function(response) {
      var tableContents = response.data.tableContents;
      var contents = [];
      $.each(tableContents,function(idx,val) {
        contents[idx] = val.val.split(delimiter);
      });
      var datatablegeneric = {headers: response.data.tableHeaders, contents: contents};
      $scope.datatablegeneric = datatablegeneric;
      callback(response);
    });
  };
  
  //
  $scope.showModal = function(modalName) {
    domserv.showModal(modalName);
  };
  
  //
  $scope.uploadFile = function(url,params,callback) {
    dataserv.uploadFile(url,params,callback);
  };
  
  //
  $scope.postDataByParam = function(url,params,callback) {
    dataserv.postDataByParam(url,params,callback);
  };
  
  //
  $scope.getDataCommon = function(url,params,callback) {
    dataserv.getData(url,params,callback);
  };
  
  //
  $scope.getDataNonJson = function(url,params,callback) {
    dataserv.getDataNonJson(url,params,callback);
  };
  
  //
  $scope.saveDataNonAssign = function(url,data,callback) {
    dataserv.saveData(url,data,function(response) {
      callback(response);
      $scope.getData($scope.url,$scope.params);
    });
  };
  
  //
  $scope.compileObject = function(obj) {
    $compile(obj)($scope);
  };
});

