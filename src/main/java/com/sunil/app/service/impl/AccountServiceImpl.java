package com.sunil.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.app.model.Account;
import com.sunil.app.model.SubAccount;
import com.sunil.app.repository.ACRepository;
import com.sunil.app.repository.AccountRepository;
import com.sunil.app.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private ACRepository acRepo;
	@Autowired
	private AccountRepository aRepo;
	
	@Override
	public void addACtype(SubAccount subaccount) {
		// TODO Auto-generated method stub
		acRepo.save(subaccount);
	}

	@Override
	public void updateACtype(SubAccount subaccount) {
		// TODO Auto-generated method stub
		acRepo.save(subaccount);
	}

	@Override
	public List<SubAccount> getAllAC() {
		// TODO Auto-generated method stub
		return acRepo.findAll();
	}

	@Override
	public SubAccount getById(int id) {
		// TODO Auto-generated method stub
		return acRepo.getById(id);
	}

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return aRepo.findAll();
	}

}
