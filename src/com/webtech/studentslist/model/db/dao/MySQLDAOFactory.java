package com.webtech.studentslist.model.db.dao;

import com.webtech.studentslist.mode.db.dao.logic.IStudentDAO;
import com.webtech.studentslist.model.db.dao.impl.StudentDAOMySQL;

public class MySQLDAOFactory extends DAOFactory {
	
	private static MySQLDAOFactory instance;
	
	private MySQLDAOFactory() {
		
	}
	
	public static MySQLDAOFactory getInstance() {
		if(instance == null)
			instance = new MySQLDAOFactory();
		
		return instance;
	}

	@Override
	public IStudentDAO getStudentDAO() {
		return new StudentDAOMySQL();
	}
}
