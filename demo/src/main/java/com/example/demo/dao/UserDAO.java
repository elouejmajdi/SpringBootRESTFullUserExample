package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.*;

@Component
public class UserDAO {

	public static List<User> db = new ArrayList<>();

	public List<User> getAllUsers() {
		return db;
	}

	public User getUserById(int id) {
		return db.get(id);
	}

	public void createUser(User user) {
		db.add(user);
	}

	public User delete(int id) {
		User user = new User();
		user = db.get(id);
		db.remove(id);

		return user;
	}

	public void updateUser(int id, User user) {
		db.set(id, user);

	}

	static {

		User user1 = new User();
		user1.setId(1);
		user1.setName("Harray");
		db.add(user1);

		User user2 = new User();
		user1.setId(2);
		user1.setName("Jared");
		db.add(user2);
	}

}
