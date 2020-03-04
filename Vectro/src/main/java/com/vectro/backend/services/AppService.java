package com.vectro.backend.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vectro.backend.model.App;
import com.vectro.backend.repository.AppRepository;

@Service
@Transactional
public class AppService {

	@Autowired
	private final AppRepository appRepository;
	public AppService(AppRepository appRepository) {
		this.appRepository = appRepository;
	}
	public void saveMyUser(App app) {
		appRepository.save(app);
	}
	
	public App findByEmail(String email) {
		return appRepository.findByEmail(email);
	}
}
