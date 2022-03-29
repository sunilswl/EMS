package com.sunil.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.app.model.Client;
import com.sunil.app.repository.ClientRepository;
import com.sunil.app.service.ClientService;
@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepository clientRepo;
	
	@Override
	public void addClient(Client client) {
		// TODO Auto-generated method stub
		clientRepo.save(client);
	}

	@Override
	public void updateClient(Client client) {
		// TODO Auto-generated method stub
		clientRepo.save(client);
	}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return clientRepo.findAll();
	}

	@Override
	public Client getById(int id) {
		// TODO Auto-generated method stub
		return clientRepo.getById(id);
	}

}
