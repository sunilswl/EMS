package com.sunil.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sunil.app.model.SubAccount;

public interface ACRepository extends JpaRepository<SubAccount, Integer> {

}
