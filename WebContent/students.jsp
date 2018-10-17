<%@page import="com.webtech.studentslist.res.IAppConsts"%>
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
		<link rel="stylesheet" href="/StudentsList/css/bootstrap.min.css"/>

		<!-- Custom styles for this template -->
		<link rel="stylesheet" href="/StudentsList/css/style.css">
		
		
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
					  	<select class="form-control" name="criterions" ng-model="sortCriterion">
						  <option class="sortOption" value="<%= IAppConsts.PARAM_ID %>">מזהה</option>
						  <option class="sortOption" value="<%= IAppConsts.PARAM_FIRST_NAME %>">שם פרטי</option>
						  <option class="sortOption" value="<%= IAppConsts.PARAM_LAST_NAME%>">שם משפחה</option>
						  <option class="sortOption" value="<%= IAppConsts.PARAM_COURSE%>">מחלקה</option>
						</select>
					  </span>
				    </div>
			    </form>
			    
				<button type="button" class="btn btn-success" id="newStudentButton" 
				onClick="window.location.href='services/StudentsService/newStudent'">הוספת סטודנט חדש</button>
				  
				  <table id="secondTable" class="table table-dark studentsTable table-hover">
				  	  <tr>
				      	<th>מזהה</th>
				        <th>שם פרטי</th>
				        <th>שם משפחה</th>
				        <th>מחלקה</th>
				  	  </tr>
					  <tr class="table-row studentsTableRow"  ng-repeat="student in students | filter:search | orderBy:sortCriterion"
					   ng-click="tableRowClick(student)">
					    <td>{{ student.id }}</td>
					    <td>{{ student.firstName }}</td>
					    <td>{{ student.lastName }}</td>
					    <td>{{ student.course }}</td>
					  </tr>
				  </table>
			</div>
			
		  <!--  JQuery core JS -->
		  <script type="text/javascript" src="js/jquery.js"></script>
		  
		  <!-- Custom scripts for this template -->
		  <script type="text/javascript" src="js/students.js"></script>
		  
		  <!--  Angular core JS -->
		  <script src="js/angular.min.js"></script>
		  
	</body>
</html>
