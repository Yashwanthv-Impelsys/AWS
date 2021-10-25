package org.impelsys.SpringBootDemo.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ClientErrorException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.impelsys.SpringBootDemo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;



@Repository
public class CommentDaoImpl {
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Comment> listComments(){
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Comment",Comment.class);
		List<Comment> commentList = query.list();
		session.close();
		return commentList;
	}
	
	public Comment getComment(int id) {
		
		Session session = sessionFactory.openSession();
		Comment comment = session.get(Comment.class, new Integer(id));
		/*
		 * if(comment!=null)
		 *  System.out.println("Comment: "+comment);
		 */	
		session.close();
		return comment;
	}
	
}
