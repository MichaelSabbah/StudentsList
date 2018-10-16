package com.webtech.studentslist.controller.services;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.spi.dispatch.RequestDispatcher;
import com.sun.research.ws.wadl.Request;
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

	@GET
	@Path("/students")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudents(){
		studentDAO.insert(new Student(BigDecimal.valueOf(203106935),"מייקל","סבח","תוכנה"));
		studentDAO.insert(new Student(BigDecimal.valueOf(202339245),"משה","כהן","חשמל"));
		return studentDAO.getAllStudents();
	}
	
	@GET
	@Path("/newStudent")
	public Viewable newStudentPage(){
		  /*Map<String, String> model = new HashMap<>();
		  model.put("key1", "value1");
		  model.put("key2", "value2");*/
		  return new Viewable("/newStudent.jsp");
	}
	
	@GET
	@Path("/insertStudent")
	public Response insertNewStudent(@QueryParam(IAppConsts.PARAM_ID) long id,
									 @QueryParam(IAppConsts.PARAM_FIRST_NAME) String firstName,
									 @QueryParam(IAppConsts.PARAM_LAST_NAME) String lastName,
									 @QueryParam(IAppConsts.PARAM_COURSE) String course) {
		
		System.out.println("Enter insertNewStudent method");
		
		//Create new student
		Student student = new Student(BigDecimal.valueOf(id),firstName,lastName,course);
		
		//Insert new student
		studentDAO.insert(student);
		
		return null;
		
	}
	
}
