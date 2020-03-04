package com.vectro.backend.repository;

import com.vectro.backend.model.App;
import org.springframework.data.repository.CrudRepository;
public interface AppRepository extends CrudRepository<App,String> {
	
	public App findByEmail(String email);
}
