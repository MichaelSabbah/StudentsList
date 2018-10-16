package com.webtech.studentslist.res.mysql;

public class MySQLConsts {
	
	public static final String STUDENTS_DB_NAME = "students_list";
	
	//Configuration
	public static final String USER = "root";
	public static final String PASSWORD = "";
	public static final String MY_SQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_DB_URL = "jdbc:mysql://localhost/"+STUDENTS_DB_NAME+"?useUnicode=yes&characterEncoding=UTF-8";
	
	//Queries
	public static final String INSERT_STUDENT = "INSERT IGNORE INTO " + STUDENTS_DB_NAME + "." + "STUDENTS "
											  + "(STUDENTID,FIRSTNAME,LASTNAME,COURSE) "
											  + "VALUES (?,?,?,?)";
	public static final String DELETE_STUDENT = "DELETE FROM STUDENTS WHERE STUDENTID=?";
	public static final String SELECT_STUDENT_BY_ID = "SELECT * FROM STUDENTS WHERE STUDENTID=?";
	public static final String SELECT_ALL_STUDENTS = "SELECT * FROM STUDENTS";
	public static final String UPDATE_STUDENT = "UPDATE STUDENTS "
											  + "SET FIRSTNAME=?, LASTNAME=?, COURSE=?"
											  + "WHERE STUDENTID=?";
}
