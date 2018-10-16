package com.webtech.studentslist.model.db.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webtech.studentslist.mode.db.dao.logic.DBType;
import com.webtech.studentslist.mode.db.dao.logic.IStudentDAO;
import com.webtech.studentslist.model.dto.Student;
import com.webtech.studentslist.res.mysql.MySQLConsts;

public class StudentDAOMySQL implements IStudentDAO {
	
	private Connection connection;
	private PreparedStatement statement;
	
	@Override
	public void insert(Student dtoToInsert) {
		
		try {
			setDBConfiguration();
			
			statement = connection.prepareStatement(MySQLConsts.INSERT_STUDENT);
			statement.setBigDecimal(1, dtoToInsert.getId());
			statement.setString(2, dtoToInsert.getFirstName());
			statement.setString(3, dtoToInsert.getLastName());
			statement.setString(4, dtoToInsert.getCourse());
			
			statement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeDBReferences();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Student dtoToDelete) {
		try {
			setDBConfiguration();
			
			statement = connection.prepareStatement(MySQLConsts.DELETE_STUDENT);
			statement.setBigDecimal(1, dtoToDelete.getId());
			
			statement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeDBReferences();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Student dtoToUpdate) {
		try {
			setDBConfiguration();
			
			statement = connection.prepareStatement(MySQLConsts.UPDATE_STUDENT);
			statement.setString(1, dtoToUpdate.getFirstName());
			statement.setString(2, dtoToUpdate.getLastName());
			statement.setString(3, dtoToUpdate.getCourse());
			statement.setBigDecimal(4, dtoToUpdate.getId());
			
			statement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeDBReferences();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentsList = new ArrayList<Student>();
		
		try {
			setDBConfiguration();
			
			statement = connection.prepareStatement(MySQLConsts.SELECT_ALL_STUDENTS);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				studentsList.add(buildStudent(resultSet));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeDBReferences();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return studentsList;
	}

	@Override
	public Student getById(long id) {
		Student student = null;
		
		try {
			setDBConfiguration();
			statement = connection.prepareStatement(MySQLConsts.SELECT_STUDENT_BY_ID);
			statement.setBigDecimal(1,BigDecimal.valueOf(id));
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next())
				student = buildStudent(resultSet);

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeDBReferences();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return student;
	}

	@Override
	public DBType getDBType() {
		return DBType.MYSQL;
	}
	
	private void setDBConfiguration() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		Class.forName(MySQLConsts.MY_SQL_DRIVER).newInstance();
		connection = (Connection)DriverManager.getConnection(MySQLConsts.MYSQL_DB_URL, MySQLConsts.USER, MySQLConsts.PASSWORD);
	}
	
	private void closeDBReferences() throws SQLException {
		connection.close();
		statement.close();
	}
	
	private Student buildStudent(ResultSet resultSet) throws SQLException{
		
		BigDecimal id = resultSet.getBigDecimal(STUDENT_ID);
		String firstName = resultSet.getString(FIRST_NAME);
		String lastName = resultSet.getString(LAST_NAME);
		String course = resultSet.getString(COURSE);
		
		Student student = new Student(id,firstName,lastName,course);
		
		return student;
	}
	
}
