

package com.webtech.studentslist.model.db.dao;

import com.webtech.studentslist.mode.db.dao.logic.DBType;
import com.webtech.studentslist.mode.db.dao.logic.IStudentDAO;

/**
 * @author webTech
 *
 */
public abstract class DAOFactory{
	
	public static DAOFactory getDatabaseDAO(DBType dbType) {
		switch(dbType) {
			case MYSQL:
				return MySQLDAOFactory.getInstance();
			default:
				return null;
		}
	}
	
	public abstract IStudentDAO getStudentDAO();
	
}

