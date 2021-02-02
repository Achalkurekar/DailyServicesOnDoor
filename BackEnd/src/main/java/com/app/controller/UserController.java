package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Models.AcceptService;
import com.app.dao.IUserFeedbackDao;
import com.app.dao.Iservices;
import com.app.pojos.Services;
import com.app.pojos.User;
import com.app.pojos.UserFeedBack;
import com.app.service.IUserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private IUserService service;
	
	@Autowired
	private IUserFeedbackDao UFService;
	
	@Autowired
	private Iservices iservice;
	
	 public UserController() {
		 System.out.println("in constr of "+getClass().getName());
	}
	
	@GetMapping
	public ResponseEntity<?> listAllUsers()
	{
		System.out.println("in list all users");
		List<User> us=service.getAllUsers();
		if(us.isEmpty())
		   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<>(us,HttpStatus.OK);//200
	}
	
	//insert new user
		@PostMapping
		@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<?> insertUser(@RequestBody User newUser)
		{
			System.out.println(newUser);
			try
			{
				User us=service.insertUser(newUser);
				return new ResponseEntity<>(us,HttpStatus.OK);
			}
			catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		//update user
		@PutMapping("/{user_id}")
		public ResponseEntity<?> updateDetails(@PathVariable int user_id,@RequestBody User updateUser)
		{
			try
			{
				User us=service.updateUser(user_id,updateUser);
				return new ResponseEntity<>(us,HttpStatus.OK);
				}
			catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//delete user
		@DeleteMapping("/{userId}")
		public ResponseEntity<?> deleteUser(@PathVariable int userId)
		{
			System.out.println("in the "+getClass().getName());
			try {
				service.deleteUser(userId);
			return new ResponseEntity<>(HttpStatus.OK);
			}
				catch(RuntimeException e)
			{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		 
		
	}
		  @GetMapping("/getUser/{id}")
		  @CrossOrigin(origins = "*")
		  User getUserDetail(@PathVariable String id)
		  {
			  System.out.println("Get User Detail");
			  return service.findByUserId(Integer.parseInt(id));
			  
		  }
		  
		  
		  @PostMapping("/FeedbackFilled")
		  @CrossOrigin(origins = "*")
		  UserFeedBack FillFeedback(@RequestBody AcceptService ac) 
		  {
			  System.out.println("Feedback Section");
			  System.out.println(ac);
			  
			  UserFeedBack userfeedback=new UserFeedBack();
			  userfeedback.setDescription(ac.getDescription());
			  userfeedback.setRating(ac.getRating());
			  Optional<Services> s=iservice.findById(ac.getServiceId());
              
			  Services Cfs=s.get();
			  System.out.println(Cfs);
			  Cfs.setFeedbackstatus(4);
			  UserFeedBack fis=UFService.save(userfeedback);
			  System.out.println("Feedback Id -->...."+fis.getFeedbackId());
			  System.out.println(fis);
			  Cfs.setFeedback_id(fis.getFeedbackId());
			  iservice.save(Cfs);
			  
			  return fis;
		  }
		  
		  @PostMapping("/login")
		  @CrossOrigin(origins = "*")
          User LoginUser(@RequestBody com.app.Models.User u) 
		  {
			  System.out.println("Hello");
			  System.out.println(service.userlogin(u));
			  return service.userlogin(u);
		  } 
		  
		  
	
}
