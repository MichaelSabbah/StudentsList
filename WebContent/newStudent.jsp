<%@ page import="com.webtech.studentslist.model.db.dao.impl.StudentDAOMySQL"%>
<%@ page import="com.webtech.studentslist.controller.services.StudentsServices"%>
<%@ page import="java.util.List"%>
<%@ page import="com.webtech.studentslist.model.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>

<html dir="rtl">

	<head>

		<meta charset="UTF-8">
		<title>סטודנט חדש</title>
   		<!-- Bootstrap core CSS -->
		<link rel="stylesheet" href="/StudentsList/css/bootstrap.min.css"/>
		<!-- Custom styles for this template -->
		<link rel="stylesheet" href="/StudentsList/css/style.css">

	</head>

<body>

  <div class="jumbotron main-head">
    <div class="container">
      <h1>הוספת סטודנט חדש</h1>
    </div>
  </div>
  
  <div id="newUserForm" class="form-wrapper">
  	<form action="/StudentsList/services/StudentsService/insertStudent" method="GET">	
	    <div class="form-group">
	    	<label for="id">ת.ז</label>
	  		<input type="number" name="id" class="form-control" id="id" placeholder="הקלד ת.ז">
	  	</div>
	  	<div class="form-group">
	  		<label for="firstNameInput">שם פרטי</label>
	  		<input type="text" name="firstName" class="form-control" id="firstNameInput" placeholder="הקלד שם פרטי">
	  	</div>
	  	<div class="form-group">
	  		<label for="lastNameInput">שם משפחה</label>
	  		<input type="text" name="lastName" class="form-control" id="lastNameInput" placeholder="הקלד שם משפחה">
	  	</div>
	  	<div class="form-group">
	  		<br>
	  		<select name="course" class="form-control custom-select" id="courses">
	  			<option id="chooseCourseText" selected>בחר מחלקה</option>
	  			<option>תעשייה וניהול</option>
	  			<option>חשמל</option>
	  			<option>תוכנה</option>
	  			<option>מכונות</option>
	  		</select>
	  	</div>
	  	<button id="addStudentButton" type="submit" class="btn btn-success"> הוסף סטודנט</button>
  	</form> 
  </div>

  <!-- Bootstrap core JavaScript-->
  <script type="text/javascript" src="/StudentsList/js/bootstrap.min.js"></script>
  
  <!-- Custom scripts for this template -->
  <script type="text/javascript" src="/StudentsList/js/studentsList.js"></script>

  <!-- Jquery core javascript -->
  <script src="/StudentsList/js/jquery-3.3.1.min.js"></script>

  <!-- Angular core javascript -->
  <script src="/StudentsList/js/angular.min.js"></script>

</body>

</html>
