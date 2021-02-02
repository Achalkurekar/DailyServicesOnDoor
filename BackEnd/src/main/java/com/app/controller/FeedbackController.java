package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.UserFeedBack;
import com.app.service.FeedbackImple;
import com.app.service.Ifeedback;

@RestController
@CrossOrigin(origins = "*")
public class FeedbackController {
	
	@Autowired
	private  Ifeedback fee;
	
	@GetMapping("GetALLFeedback")
	List<UserFeedBack> getAllFeedback()
	{
	   return fee.findAll();	
	}
	
	@GetMapping("feedback/{id}")
	UserFeedBack getFeedback(@PathVariable String id) 
	{
		return fee.findById(Integer.parseInt(id));
	}

}
