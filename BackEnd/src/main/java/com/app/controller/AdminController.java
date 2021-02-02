package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin;
import com.app.pojos.ServiceProvider;
import com.app.service.IAdminService;
import com.app.service.IServiceProviderService;

@RestController
@RequestMapping("/admins")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private IAdminService admin_service;
	@Autowired 
	private IServiceProviderService sp_service;
	
	
	public AdminController() {
		System.out.println("in constr of "+getClass().getName());
	}
	
	//ResponseEntity represents entire response packet(header,status,body etc))
		@GetMapping
		public ResponseEntity<?> listAllAdmin()
		{
			System.out.println("in list all providers");
			List<Admin> ad=admin_service.getAllAdmin();
			if(ad.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
			return new ResponseEntity<>(ad,HttpStatus.OK);//200
		}
		
		
		//ResponseEntity represents entire response packet(header,status,body etc))
				@GetMapping("/providers")
				public ResponseEntity<?> listAllProviders()
				{
					System.out.println("in list all providers");
				List<ServiceProvider> pro=sp_service.getAllProviders();
					if(pro.isEmpty())
						return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
					return new ResponseEntity<>(pro,HttpStatus.OK);//200
						
					
				}
				
			
				

				@PutMapping("/providers/{provider_id}")
				public ResponseEntity<?> updateDetails(@PathVariable int provider_id,@RequestBody ServiceProvider updated)
				{
					try
					{
						ServiceProvider up = sp_service.updateProvider(provider_id,updated);
						return new ResponseEntity<>(up,HttpStatus.OK);
					}
					catch(RuntimeException e)
					{
						e.printStackTrace();
						return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}
				
				@PostMapping("/login")
			     @CrossOrigin(origins = "http://localhost:4200")
			     public Admin loginAdmin(@RequestBody Admin admin)throws Exception{
			    	 String tempEmail=admin.getEmail();
			    	 String tempPass=admin.getPassword();
			    	 
			    	 Admin adminobj= null;
			    	 if(tempEmail !=null && tempPass!=null) {
			    		 adminobj=admin_service.fetchAdminByEmailAndPassword(tempEmail, tempPass);
			    	 }
			    	 if(adminobj == null) {
			    		 throw new Exception("Bad credential");
			    	 }
			    	 return adminobj;
			     }
				
}
