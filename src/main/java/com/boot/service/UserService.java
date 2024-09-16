package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.UserRepository;
import com.boot.entity.User;

@Service
public class UserService {
	
	   @Autowired
       private UserRepository repo;
	   
	   public void addUser(User u) {
		   repo.save(u);
	   }
	   public boolean validateUser(String uName, String uPassword) {
		    User user = repo.findByuName(uName);
		    if (user != null && user.getuPassword().equals(uPassword)) {
		        System.out.println("User validated successfully."); // Debug line
		        return true;
		    }
		    System.out.println("User validation failed."); // Debug line
		    return false;
		}
	   	
}
