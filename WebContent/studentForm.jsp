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
	  	<form id="studentDetailsForm" action="/StudentsList/services/StudentsService/insertStudent" method="GET">	
		    <div class="form-group">
		    	<label for="id">ת.ז</label>
		  		<input type="number" name="id" class="form-control" id="idInput" placeholder="הקלד ת.ז" required>
		  	</div>
		  	<div class="form-group">
		  		<label for="firstNameInput">שם פרטי</label>
		  		<input type="text" name="firstName" class="form-control" id="firstNameInput" placeholder="הקלד שם פרטי" required>
		  	</div>
		  	<div class="form-group">
		  		<label for="lastNameInput">שם משפחה</label>
		  		<input type="text" name="lastName" class="form-control" id="lastNameInput" placeholder="הקלד שם משפחה" required>
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
		  	<div id="studentDetailsButtons" class="disable">
		  		<button id="editDetailsButton" type="submit" class="btn btn-success">שמור פרטים</button>
		  		<button id="deleteStudentButton" type="submit" class="btn btn-danger">מחק סטודנט</button>
		  	</div>
		  	<div id="newStudentButtons">
		  		<button id="addStudentButton" type="submit" class="btn btn-success"> הוסף סטודנט</button>
		  	</div>
	  	</form> 
	  </div>
	  
	  <script type="text/javascript" src="/StudentsList/js/jquery.js"></script>
	  
	  <!-- Bootstrap core JavaScript
	  <script type="text/javascript" src="/StudentsList/js/bootstrap.min.js"></script>-->
	  
	  <!-- Custom scripts for this template -->
	  <script type="text/javascript" src="/StudentsList/js/newStudent.js"></script>
	  <script type="text/javascript">
  	  	studentId = <%= request.getParameter("id") %>
  	  </script>
	</body>

</html>
