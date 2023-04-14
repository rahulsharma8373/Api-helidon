package com.api.list.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.api.list.entity.RegisterApi;
import com.api.list.repository.RegisterApiRepo;
@ApplicationScoped
public class RegisterApiImplService implements RegisterApiService {
	
	@Inject
	private RegisterApiRepo registerApiRepo;

	@Override
	public String saveRegisterApi(RegisterApi registerApi)throws Exception {		
		try {
			return registerApiRepo.saveRegisterApi(registerApi);
			  
		} catch (Exception e) {
			throw new Exception("Something went wrong");
		}
	}
	


}
