package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserFeedbackDao;
import com.app.pojos.UserFeedBack;


@Service
@Transactional
public class FeedbackImple implements Ifeedback{

	@Autowired
	private IUserFeedbackDao dao;
	
	@Override
	public List<UserFeedBack> findAll() {
		return dao.findAll();

	}

	@Override
	public UserFeedBack findById(int id) {
		Optional<UserFeedBack> s= dao.findById(id);	
		return s.get();
		}
	
	

}
