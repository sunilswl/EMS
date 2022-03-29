package com.sunil.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.app.model.Test;
import com.sunil.app.repository.TestRepository;
import com.sunil.app.service.TestService;
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepository tRepo;
	@Override
	public void addTest(Test test) {
		// TODO Auto-generated method stub
		tRepo.save(test);
	}
	@Override
	public List<Test> getAllTest() {
		// TODO Auto-generated method stub
		return tRepo.findAll();
	}
	@Override
	public Test getById(int id) {
		// TODO Auto-generated method stub
		return tRepo.getById(id);
	}
	@Override
	public void updateTest(Test test) {
		// TODO Auto-generated method stub
		tRepo.save(test);
	}

}
