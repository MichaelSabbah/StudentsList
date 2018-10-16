package com.webtech.studentslist.mode.db.dao.logic;

import com.webtech.studentslist.model.dto.Student;

public interface IStudentDAO extends IDAO<Student> {
	
	//Student fields columns name
	public static final String STUDENT_ID = "STUDENTID";
	public static final String FIRST_NAME = "FIRSTNAME";
	public static final String LAST_NAME  = "LASTNAME";
	public static final String COURSE 	  = "COURSE";
}
