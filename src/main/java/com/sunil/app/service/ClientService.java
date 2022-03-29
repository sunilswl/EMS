package com.sunil.app.service;

import java.util.List;

import com.sunil.app.model.Client;

public interface ClientService {
	void addClient(Client client);
	void updateClient(Client client);
	List<Client> getAllClient();
	Client getById(int id);

}
