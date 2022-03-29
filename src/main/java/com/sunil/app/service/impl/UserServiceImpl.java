package com.sunil.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.app.model.User;
import com.sunil.app.repository.UserRepository;
import com.sunil.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	@Override
	public User loginUser(String un, String psw) {
		// TODO Auto-generated method stub
		return userRepo.findByEmailAndPassword(un,psw);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return userRepo.getById(id);
	}

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	@Override
	public void restPass(String psw, int id) {
		// TODO Auto-generated method stub
		userRepo.restPassword(psw, id);
	}

	@Override
	public Long countUser() {
		// TODO Auto-generated method stub
		return userRepo.count();
	}

}
