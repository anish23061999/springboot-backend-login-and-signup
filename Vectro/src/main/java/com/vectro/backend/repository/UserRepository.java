package com.vectro.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.vectro.backend.model.User;

public interface UserRepository extends CrudRepository<User,Long>{
	
	public User findByMailAndPassword(String mail,String password);

	//public User findByOtp(String otp);
}
