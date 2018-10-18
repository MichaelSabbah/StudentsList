// The global object that holds all logic

var studentId = null;

var STUDENT_FORM = {

	loadDetailsForm : function(studentId){
		STUDENT_FORM.disableNewStudentForm();
		STUDENT_FORM.enableStudentDetailsForm();
		STUDENT_FORM.loadStduentDetails(studentId);
	},
		
	disableNewStudentForm : function(){
		$("#newStudentButtons").addClass("disable");
		$("#newStudentButtons").attr("disabled",true);
	},
	
	enableStudentDetailsForm : function(){
		$("#studentDetailsButtons").removeClass("disable");
	},
	
	setStudentDetails : function(student){
		$("#idInput").val(student.id);
		$("#firstNameInput").val(student.firstName);
		$("#lastNameInput").val(student.lastName);
		$('[name=course] option').filter(function() { 
		    return ($(this).text() == student.course); //To select Blue
		}).prop('selected', true);
	},
	
	loadStduentDetails : function(studentId){
	    $.get("/StudentsList/services/StudentsService/getStudent",{id : studentId}, function(student){
	    	STUDENT_FORM.setStudentDetails(student);
	    });
	},
	
	deleteStudent : function(studentId){
		alert("deleteStudent");
		alert(studentId);
		window.location.href='services/StudentsService/deleteStudent?id=' + studentId;
	},
	
	setFormAction : function(action){
		$("#studentDetailsForm").attr("action",action);		
	}
};

//Initializations
$(document).ready( function( ) {
	
	//Student details page, get student details from DB
	if(studentId != null){
		STUDENT_FORM.loadDetailsForm(studentId);
	}
	
	$("#deleteStudentButton").on('click', function() {
		var action = "/StudentsList/services/StudentsService/deleteStudent";
		STUDENT_FORM.setFormAction(action);
	});
	
	$("#addStudentButton").on('click', function() {
		var action = "/StudentsList/services/StudentsService/insertStudent";
		STUDENT_FORM.setFormAction(action);	
	});
	
	$("#editDetailsButton").on('click', function() {
		var action = "/StudentsList/services/StudentsService/updateStudentDetails";
		STUDENT_FORM.setFormAction(action);	
	});
});