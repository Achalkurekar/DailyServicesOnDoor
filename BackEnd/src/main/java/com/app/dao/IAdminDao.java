package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Admin;

public interface IAdminDao extends JpaRepository<Admin, Integer>{

	public Admin findByEmailAndPassword(String Email,String Password);
}
