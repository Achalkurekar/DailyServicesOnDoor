package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Models.AcceptService;
import com.app.dao.IUserDao;
import com.app.dao.IUserFeedbackDao;
import com.app.pojos.User;
import com.app.pojos.UserFeedBack;
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	
	@Autowired
	private IUserFeedbackDao ufdao;
	
	
	@Override
	public List<User> getAllUsers() {
		
		return dao.findAll();
	}

	@Override
	public User insertUser(User us) {
		
		return dao.save(us);
	}

	@Override
	public User updateUser(int user_id, User oldDetails) 
	{
		
			Optional<User> checkUser=dao.findById(user_id);
			if(checkUser.isPresent())
			{
				User updatedDetails=checkUser.get();
			updatedDetails.setAddress(oldDetails.getAddress());
			updatedDetails.setEmail(oldDetails.getEmail());
			updatedDetails.setFirstName(oldDetails.getFirstName());
			updatedDetails.setLastName(oldDetails.getLastName());
			updatedDetails.setMobile(oldDetails.getMobile());
			return updatedDetails;
			}
			return null;
		
	}

	@Override
	public User deleteUser(int UserId) 
	{
		
			dao.deleteById(UserId);
			return null;
	}

	@Override
	public User findByUserId(int id) {
		// TODO Auto-generated method stub
		return  dao.findByUser_id(id);
	}

	@Override
	public int filfeedback(UserFeedBack uf) {
		UserFeedBack demo= ufdao.save(uf);
		return demo.getFeedbackId();
	}



	@Override
	public User userlogin(com.app.Models.User u) {
		System.out.println(u.getUsername()+""+u.getPassword());
		return dao.findByUserIdandPasswword(u.getUsername(), u.getPassword());
	}
	
	

	

}
