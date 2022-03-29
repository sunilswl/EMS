package com.sunil.app.service;

import java.util.List;

import com.sunil.app.model.Test;

public interface TestService {
	
	void addTest(Test test);
	List<Test> getAllTest();
	Test getById(int id);
	void updateTest(Test test);

}
