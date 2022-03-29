package com.sunil.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sunil.app.model.User;
@Repository

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String psw);
	User findByEmail(String email);

	//using query
	@Transactional
	@Modifying
	@Query(value="UPDATE user_tbl set password=:psw where id=:id", nativeQuery = true)
	//@Query("UPDATE User u set  u.password = :psw WHERE u.id = :id")
	void restPassword( String psw,  int id );

}
