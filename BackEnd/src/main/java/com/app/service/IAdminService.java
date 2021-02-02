package com.app.service;

import java.util.List;

import com.app.pojos.Admin;

public interface IAdminService {
	List<Admin> getAllAdmin();
	Admin fetchAdminByEmailAndPassword(String email, String password);
}
