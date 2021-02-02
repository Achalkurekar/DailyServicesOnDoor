package com.app.service;

import java.util.List;

import com.app.pojos.UserFeedBack;

public interface Ifeedback {
	
	List<UserFeedBack> findAll();
	UserFeedBack findById(int id);
	
	

}
