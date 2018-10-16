<%@ page import="com.webtech.studentslist.model.db.dao.impl.StudentDAOMySQL"%>
<%@ page import="com.webtech.studentslist.controller.services.StudentsServices"%>
<%@ page import="java.util.List"%>
<%@ page import="com.webtech.studentslist.model.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>

<html dir="rtl">
	<head>

		<meta charset="UTF-8">
		<!-- Bootstrap core CSS -->
		<link rel="stylesheet" href="css/bootstrap.min.css"/>

		<!-- Custom styles for this template -->
		<link rel="stylesheet" href="css/style.css">
		
		<title>רשימת סטודנטים</title>

	</head>

	<body>
		<div class="jumbotron main-head">
			<div class="container">
				<h1>רשימת סטודנטים</h1>
			</div>
		</div>

			<div ng-app="myApp" ng-controller="myCtrl">
				<form>
					<div class="form-group form-wrapper">
					  <span>חיפוש:<input class="form-control" id="searchingInput" type="text" ng-model="search"></span>
					  <span>מיין לפי:
					  	<select class="form-control" name="cars" ng-model="sortCriterion">
						  <option class="sortOption" value="id">מזהה</option>
						  <option class="sortOption" value="firstName">שם פרטי</option>
						  <option class="sortOption" value="lastName">שם משפחה</option>
						  <option class="sortOption" value="course">מחלקה</option>
						</select>
					  </span>
				    </div>
			    </form>
			    
				<button type="button" class="btn btn-success" id="newStudentButton" 
				onClick="window.location.href='services/StudentsService/newStudent'">הוספת סטודנט חדש</button>
				  
				  <table id="secondTable" class="table table-dark studentsTable">
				  	  <tr>
				      	<th>מזהה</th>
				        <th>שם פרטי</th>
				        <th>שם משפחה</th>
				        <th>מחלקה</th>
				  	  </tr>
					  <tr ng-repeat="student in students | filter:search | orderBy:sortCriterion">
					    <td>{{ student.id }}</td>
					    <td>{{ student.firstName }}</td>
					    <td>{{ student.lastName }}</td>
					    <td>{{ student.course }}</td>
					  </tr>
				  </table>
			</div>
		
		  <!-- Bootstrap core JavaScript-->
		  <script type="text/javascript" src="/StudentsList/js/bootstrap.min.js"></script>
		 
		  <!-- Custom scripts for this template -->
		  <script type="text/javascript" src="/StudentsList/js/studentsList.js"></script>
		  
		  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
		  
		  <script type="text/javascript">
			  var app = angular.module('myApp', []);
			  app.controller('myCtrl', function($scope, $http) {
			      $http.get("services/StudentsService/students")
			      .then(function(response) {
			          $scope.students = response.data;
			      });
			  });
		  </script>
	</body>
</html>
