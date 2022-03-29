package com.sunil.app.service;

import java.util.List;

import com.sunil.app.model.User;

public interface UserService {
	
	void addUser(User user);
	void updateUser(User user);
	User loginUser(String un, String psw);
	List<User> getAllUser();
	User getById(int id);
	User getByEmail(String email);
	void restPass(String psw, int id);
	Long countUser();

}
