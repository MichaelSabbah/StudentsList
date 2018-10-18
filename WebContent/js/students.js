// The global object that holds all logic
var STUDENTS = {
	newStudentPae : function (){
		xhttp.open("GET", "ajax_info.txt", true);
		xhttp.send();
	},
	httpGet : function (url,callBackFunction) {
		  alert("Enter hepGet");
		  var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
			if(callBackFunction != null){
			    if (this.readyState == 4 && this.status == 200) {
			    	callBackFunction(this);	
			    }
			}
		  }
		  xhttp.open("GET", url, true);
		  xhttp.send();
	},
	setStudentsTable : function (xhttp){
		alert("Enter setStudentsTable function");
		
		//Parse students list from JSON to JavaScript array
		var studentsArray = JSON.parse(xhttp.responseText);
		alert(studentsArray);
		
		//Set the Angular 'students' model to be 'studentsArray'
	 	var app = angular.module('myApp', []);
	 	app.controller('myCtrl', function($scope) {
	 	      $scope.students = studentsArray;
	 	});
	},
	
	openStudentDetailsPage : function(student){
		window.location.href='services/StudentsService/studentDetails?id=' + student.id;
	},
	
	setStudentsTable : function(){
		  var app = angular.module('myApp', []);
		  app.controller('myCtrl', function($scope, $http) {
		      $http.get("services/StudentsService/students")
		      .then(function(response) {
		          $scope.students = response.data;
		      });
		      
			  $scope.tableRowClick = function(student) {
				 STUDENTS.openStudentDetailsPage(student);
			  };
		  });	
	}
};

//Initializations
$(document).ready( function( ) {
	STUDENTS.setStudentsTable();
});

