package com.app.service;

import java.util.List;

import com.app.Models.AcceptService;
import com.app.pojos.User;
import com.app.pojos.UserFeedBack;

public interface IUserService {
	List<User> getAllUsers();
	User insertUser(User us);
	User updateUser(int user_id,User oldDetails);
	User deleteUser(int UserId);
	User findByUserId(int id);
	int filfeedback(UserFeedBack uf);
	User userlogin(com.app.Models.User u);
	
}
