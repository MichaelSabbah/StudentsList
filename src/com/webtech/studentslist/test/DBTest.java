package com.webtech.studentslist.test;

import java.math.BigDecimal;

import com.webtech.studentslist.mode.db.dao.logic.DBType;
import com.webtech.studentslist.mode.db.dao.logic.IStudentDAO;
import com.webtech.studentslist.model.db.dao.DAOFactory;
import com.webtech.studentslist.model.dto.Student;

public class DBTest {
	/*public static void main(String[] args) {
		IStudentDAO studentDAO = DAOFactory.getDatabaseDAO(DBType.MYSQL).getStudentDAO();
		
		Student s1 = new Student(BigDecimal.valueOf(203106935),"מייקל","סבח","תוכנה");
		//Student s1 = new Student(BigDecimal.valueOf(203106935),"Michael","Sabbah","Software");
		Student s2 = new Student(BigDecimal.valueOf(102449302),"David","Cohen","Math");
		Student s3 = new Student(BigDecimal.valueOf(440392102),"Dor","Levi","Physics");
		
		//Insert students
		studentDAO.insert(s1);
		studentDAO.insert(s2);
		studentDAO.insert(s3);
		studentDAO.insert(s1);
		System.out.println("Students inserted");
		
		//Delete student
		studentDAO.delete(s1);
		System.out.println("Student s1 deleted");
		
		//Get all students
		System.err.println("All students: ");
		System.out.println(studentDAO.getAllStudents());
		
		//Get student by id
		System.out.println("Student by id(s2): ");
		Student student = studentDAO.getById(102449302);
		if(student != null)
			System.out.println(student.toString());
		else
			System.out.println("Student not exist");
		
		//Update student
		s2.setCourse("Software");
		studentDAO.update(s2);
		
		//Get student by id
		System.out.println("Student by id(s2 after update): ");
		student = studentDAO.getById(102449302);
		if(student != null)
			System.out.println(student.toString());
		else
			System.out.println("Student not exist");
		
	}*/
}
