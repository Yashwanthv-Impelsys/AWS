package org.impelsys.SpringBootDemo.dao;

import org.impelsys.SpringBootDemo.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
//@Repository  //not required it has default implementation
public interface UserLoginRepository extends JpaRepository<UserLogin,Integer>{

	UserLogin findByUsername(String username);    //finder API
}
