package org.impelsys.SpringBootDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="This Comment is not found in the system")
public class CommentNotFoundException extends RuntimeException{
	

	private static final long serialVersionUID =1l; 
	public CommentNotFoundException(int id) {
		super(String.format("Comment with %d not Found!",id));
	}
}
