package com.webtech.studentslist.mode.db.dao.logic;

import java.util.List;

public interface IDAO<T> {
	
	/**
	 * Insert the given DTOs
	 * @param dtoToInsert The new DTO to insert
	 */
	public void insert(T dtoToInsert);
	
	/**
	 * Delete a specific DTO
	 * @param dtoToDelete The DTO to be deleted
	 */
	public void delete(T dtoToDelete);
	
	/**
	 * Update the DTO with the specific id with the new DTO details
	 * @param dtoToUpdate The DTO with the new details
	 */
	public void update(T dtoToUpdate);
	
	
	/**
	 * @return A list with all the DTOs
	 */
	public List<T> getAllStudents();
	
	/**
	 * Get DTOs by id
	 * @param id of the relevant DTOs
	 * @return The DTOs with the given id
	 */
	public T getById(long id);
	
	/**
	 * This method return the type if  this specific DBs
	 * @return The type of the DB
	 */
	public DBType getDBType();
}
