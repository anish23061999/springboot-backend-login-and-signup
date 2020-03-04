package com.vectro.backend.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.vectro.backend.model.User;
import com.vectro.backend.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public void saveMyUser(User user) {
		userRepository.save(user);
	}
	
	public User findByMailAndPassword(String mail,String password) {
		return userRepository.findByMailAndPassword(mail,password);
	}
	
	/*public User findByOtp(String otp)
	{
		return userRepository.findByOtp(otp);
	}*/
}
