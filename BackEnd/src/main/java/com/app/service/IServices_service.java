package com.app.service;

import java.util.List;

import com.app.pojos.Services;

public interface IServices_service {
	
	List<Services> findByUser_id(int id);
	List<Services> FindUnaccepted(int id);
	List<Services> findAll();

}
