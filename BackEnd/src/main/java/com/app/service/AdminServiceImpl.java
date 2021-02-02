package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAdminDao;
import com.app.pojos.Admin;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {
	
	
	@Autowired
	private IAdminDao dao;
	
	
	@Override
	public List<Admin> getAllAdmin() {
		System.out.println("dao impl class "+dao.getClass().getName());
		return dao.findAll();
	}
	
	@Override
	  public Admin fetchAdminByEmailAndPassword(String email,String password){
		  return dao.findByEmailAndPassword(email, password);
	  }

}
