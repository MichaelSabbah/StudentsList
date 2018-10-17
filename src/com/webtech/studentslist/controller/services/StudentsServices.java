package com.webtech.studentslist.controller.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.view.Viewable;
import com.webtech.studentslist.mode.db.dao.logic.DBType;
import com.webtech.studentslist.mode.db.dao.logic.IStudentDAO;
import com.webtech.studentslist.model.db.dao.DAOFactory;
import com.webtech.studentslist.model.dto.Student;
import com.webtech.studentslist.res.IAppConsts;

/**
 * 
 * @author webTech
 *
 */
@Path("/StudentsService")
public class StudentsServices {
	
	private IStudentDAO studentDAO = DAOFactory.getDatabaseDAO(DBType.MYSQL).getStudentDAO();
	//@Context private HttpServletRequest request;
	
	@GET
	@Path("/students")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents(){
		return studentDAO.getAllStudents();
	}
	
	
	@GET
	@Path("/newStudent")
	public Viewable newStudentPage(@Context HttpServletRequest request){
		  request.setAttribute("newStudent", true);
		  return new Viewable("/studentForm.jsp");
	}
	
	@GET
	@Path("/studentDetails")
	public Viewable studentsDetails(@Context HttpServletRequest request) {
		System.out.println("studentsDetails");
		System.out.println(request.getPathInfo());
		return new Viewable("/studentForm.jsp");
	}
	
	@GET
	@Path("/insertStudent")
	public void insertNewStudent(@QueryParam(IAppConsts.PARAM_ID) long id,
									 @QueryParam(IAppConsts.PARAM_FIRST_NAME) String firstName,
									 @QueryParam(IAppConsts.PARAM_LAST_NAME) String lastName,
									 @QueryParam(IAppConsts.PARAM_COURSE) String course,
									 @Context ServletContext context,
									 @Context HttpServletRequest request,
									 @Context HttpServletResponse response
									 ) {
		
		System.out.println("Enter insertNewStudent method");
		
		//Create new student
		Student student = new Student(BigDecimal.valueOf(id),firstName,lastName,course);
		
		//Insert new student
		studentDAO.insert(student);
		
		//Redirect to main page (students list)
		try {
			response.sendRedirect("/StudentsList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@GET
	@Path("/deleteStudent")
	public Response deleteStudent(@QueryParam(IAppConsts.PARAM_ID) long id) {
		
		//Delete student with the given id
		studentDAO.delete(id);
		
		//Redirect to main page (students list)
		return null;
	}
	
}
