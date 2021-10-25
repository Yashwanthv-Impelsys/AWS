package org.impelsys.SpringBootDemo.dao;

import java.util.List;

import org.impelsys.SpringBootDemo.model.User;

public interface UserDao {
	int addUser(User user);
	void deleteUser(int id);
	User viewUser(int id);
	List<User> listUsers();
	//User viewUser(int id, Session session);
	

}
