package com.sunil.app.service;

import java.util.List;

import com.sunil.app.model.Account;
import com.sunil.app.model.SubAccount;

public interface AccountService {
	void addACtype(SubAccount account);
	void updateACtype(SubAccount account);
	List<SubAccount> getAllAC();
	SubAccount getById(int id);
	
	List<Account> getAllAccount();

}
