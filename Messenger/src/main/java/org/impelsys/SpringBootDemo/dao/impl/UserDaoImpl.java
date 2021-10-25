package org.impelsys.SpringBootDemo.dao.impl;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.impelsys.SpringBootDemo.dao.UserDao;
import org.impelsys.SpringBootDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory; 

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		int row;
		Session session=sessionFactory.openSession();
		System.out.println("Saving");
		Transaction tx=session.beginTransaction();
		row=(int) session.save(user);
		System.out.println(user);
		System.out.println("created user with Id: "+row);
		tx.commit();
		session.close();
		return row;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		user.setId(id);
		session.delete(user);
		tx.commit();
		session.close();
	}

	@Override
	public User viewUser(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, new Integer(id));
		System.out.println("User="+user);
		System.out.println("Id:"+id);
		session.close();
		
		return user;
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		List<User> userList = session.createQuery("From User").list();
		session.close();
		return userList;
	}
	
}
