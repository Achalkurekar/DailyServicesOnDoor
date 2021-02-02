package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.pojos.Services;
import com.app.dao.*;


public class ServicesImplement implements IServices_service{
	
	@Autowired
	Iservices serviceimpl;

	@Override
	public List<Services> findByUser_id(int id) {
		return null;
	}

	@Override
	public List<Services> FindUnaccepted(int id) {
		return serviceimpl.findToUnaccepted(id);
	}

	@Override
	public List<Services> findAll() {
		return serviceimpl.findAll();
	}

}
