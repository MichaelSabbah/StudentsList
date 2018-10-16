function newStudentPae(){
	xhttp.open("GET", "ajax_info.txt", true);
	xhttp.send();
}

function httpGet(url,callBackFunction) {
  alert("Enter hepGet");
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
	if(callBackFunction != null){
	    if (this.readyState == 4 && this.status == 200) {
	    	callBackFunction(this);	
	    }
	}
  };
  xhttp.open("GET", url, true);
  xhttp.send();
}

function setStudentsTable(xhttp){
	alert("Enter setStudentsTable function");
	//Parse students list from JSON to JavaScript array
	var studentsArray = JSON.parse(xhttp.responseText);
	alert(studentsArray);
	//Set the Angular 'students' model to be 'studentsArray'
 	var app = angular.module('myApp', []);
 	app.controller('myCtrl', function($scope) {
 	      $scope.students = studentsArray;
 	});
}
