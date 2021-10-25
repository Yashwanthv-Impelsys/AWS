package org.impelsys.SpringBootDemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.impelsys.SpringBootDemo.data.UserRepository;
import org.impelsys.SpringBootDemo.exception.UserNotFoundException;
import org.impelsys.SpringBootDemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList();
		userRepository.findAll().forEach(userList::add);
		return userList;
	}

	 public User getUser(int id) //throws UserNotFoundException 
	 {
		//Optional<User> user = userRepository.findById(id);  //encapsulated user inside optional
		try {
		 User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
		 return user;
		}
		catch(UserNotFoundException e)
		{
			System.out.println("In catch");
			throw (e);
		}
		// return user;
	}

	public User saveUser(User user) {
		System.out.println(user);
		return userRepository.save(user);
	}


}
