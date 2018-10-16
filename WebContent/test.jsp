<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.webtech.studentslist.model.dto.Student" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.google.gson.reflect.TypeToken" %>
<%@ page import="java.lang.reflect.Type" %>

<!DOCTYPE html>

<html dir="rtl">
	<head>
		
		<meta charset="UTF-8">

		<link rel="stylesheet" href="bootstrap4/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="style.css">
		<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
		<script src="bootstrap4/js/bootstrap.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>

		<title>רשימת סטודנטים</title>

	</head>

	<body>

		<div class="jumbotron">
		  <div class="container">
		    <h1>רשימת סטודנטים</h1>
		  </div>
		</div>
 		<div id="">

 		</div>
		<div class="studentsTableBox">
		 <table class="table table-dark studentsTable">
		    <thead>
		      <tr>
		      	<th>מזהה</th>
		        <th>שם פרטי</th>
		        <th>שם משפחה</th>
		        <th>מחלקה</th>
		      </tr>
		    </thead>
		    <tbody>

		    <%
		    Type type = new TypeToken<ArrayList<Student>>() {}.getType();
		    String studentsJsonArray = (String)request.getAttribute("studentsJsonArray");

		    ArrayList<Student> students = new Gson().fromJson(studentsJsonArray, type);
			   for(Student student : students){

				   String format = String.format("<tr>" +
		                    "<td>%d</td>" +
		                    "<td>%s</td>" +
		                    "<td>%s</td>" +
		                    "<td>%s</td>" +
		                	"</tr>",
							student.getId(),student.getFirstName(),student.getLastName(),student.getCourse());

		            out.print(format);
			   }
		    %>

		    </tbody>
		  </table>
		</div>

		<div ng-app="myApp" ng-controller="myCtrl">

			<form>
				<div class="form-group" id="tableOperations">
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

 	 <script>
 	 	var studentsList = JSON.parse('<%= studentsJsonArray %>');

	 	var app = angular.module('myApp', []);
	 	app.controller('myCtrl', function($scope) {
	 	      $scope.students = studentsList;
	 	});

	 </script>

	</body>

</html>
