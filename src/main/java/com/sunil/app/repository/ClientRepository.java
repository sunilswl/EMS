package com.sunil.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.app.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
