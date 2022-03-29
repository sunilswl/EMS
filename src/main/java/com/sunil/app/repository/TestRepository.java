package com.sunil.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.app.model.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

}
