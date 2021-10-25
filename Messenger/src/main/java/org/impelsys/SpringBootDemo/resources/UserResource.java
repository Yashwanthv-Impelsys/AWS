package org.impelsys.SpringBootDemo.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

//import java.net.URISyntaxException;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.impelsys.SpringBootDemo.dao.UserDao;
import org.impelsys.SpringBootDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Service
@Path("/users")  //http://localhost:8080/Messenger/users
@XmlRootElement(name="User")
public class UserResource {
	
	  @Autowired 
	  SessionFactory sessionFactory;
	 

	@Autowired
	@Qualifier("userDao")
	UserDao userDao;
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser() {
		List<User> userList = userDao.listUsers();
		Response.ResponseBuilder builder = Response.status(Status.OK);
		Response response = builder.entity(userList).build();
		return response;
	}
	
	
	@DELETE
	@Path("/remove/{id}")
	public Response delete(@PathParam("id") int id) {
		userDao.deleteUser(id);
		Response.ResponseBuilder builder = Response.status(Status.OK);
		Response response = builder.entity(id).build();
		return response;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") int id){
		// db call
		System.out.println("In getUserById");
		
		/*
		 * User user = new User(); user.setUserEmail("abc@gmail.com");
		 * user.setUserName("Abc"); user.setId(id);
		 */
		//Session session = sessionFactory.openSession();
		User user = userDao.viewUser(id);
		Response.ResponseBuilder builder = Response.status(Status.OK);
		Response response = builder.entity(user).build();
		//session.close();
		//return Response.status(200).entity(user).build();
		
		return response;
	}

		@POST
		@Path("/user")    //http://localhost:8080/Messenger/users/user
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response addUser(User user) {
			
			int id = userDao.addUser(user);
			System.out.println("In AddUser()");
			Response.ResponseBuilder builder = Response.status(Status.OK);
			Response response = builder.entity("Created User :"+ id).build();
			return response;
		}
}
