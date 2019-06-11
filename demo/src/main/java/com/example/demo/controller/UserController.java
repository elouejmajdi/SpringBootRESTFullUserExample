package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;

@RestController
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/")
	public String welcome() {
		return "index";
	}
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<User> getAll(){
		return userDAO.getAllUsers();
	}
	

	@RequestMapping(value="/users/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable int id){
		return userDAO.getUserById(id);
	}
	@RequestMapping(value="/users/", method = RequestMethod.POST)
	public boolean createUser(@RequestBody User user) {
		if(user.getName()==null) {
			return false;
		}
		else {
			userDAO.createUser(user);
			
			return true;
		}
	}
	@RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
	public void updateUser(@PathVariable int id,@RequestBody User user) {
		userDAO.updateUser(id,user);
	}
	@RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
	public User deleteUser(@PathVariable int id) {
		return userDAO.delete(id);
	}
	
}
