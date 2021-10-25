package org.impelsys.SpringBootDemo.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.impelsys.SpringBootDemo.exception.CommentNotFoundException;
import org.impelsys.SpringBootDemo.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice 	//interception for exception occuring in all controllers
					//Specialization of component annotation
					//globally shared
@ResponseBody
public class ControllerExceptionHandler {

	@ExceptionHandler(CommentNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND ) //reason = "Unable to find Comment"
	public String handlerForCommentsNotFound(CommentNotFoundException ce) {
		
		//System.out.println("Will Look Into this issue:"+ ce.getMessage());
		return "Will Look Into this issue:"+ ce.getMessage();
	}

	
	
/*	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND) //, reason = "Unable to Find user"
	public String handlerForUserNotFound(UserNotFoundException ue) {
		//String msg ="Will Look Into this issue:"+ ue.getMessage();
		System.out.println("In ExceptionHandler:");
		return "Will Look Into this issue:"+ ue.getMessage();
	}
*/
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND )//, reason="user not found" 
	public String handleAllExceptions(Exception e) {
		return e.getMessage();
	}
}
