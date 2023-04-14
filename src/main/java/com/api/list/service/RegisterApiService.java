package com.api.list.service;

import javax.enterprise.context.ApplicationScoped;

import com.api.list.entity.RegisterApi;
@ApplicationScoped
public interface RegisterApiService {
	 public String saveRegisterApi(RegisterApi registerApi)throws Exception;
}

