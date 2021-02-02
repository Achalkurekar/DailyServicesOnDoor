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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Models.User;
import com.app.pojos.ServiceProvider;
import com.app.service.IServiceProviderService;


@RestController
/*@RequestMapping("/providers")*/
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceProviderController 
{
	
	
	@Autowired
	private IServiceProviderService service;
	
	
	public ServiceProviderController() {
		System.out.println("in constr of "+getClass().getName());
	}
	
	
	//ResponseEntity represents entire response packet(header,status,body etc))
	@GetMapping("/providers")
	public ResponseEntity<?> listAllProviders()
	{
		System.out.println("in list all providers");
		 List<ServiceProvider> pro=service.getAllProviders();
		 System.out.println(pro);
		if(pro.isEmpty()) 
		{
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204	
		}			
		
		return new ResponseEntity<>(pro,HttpStatus.OK);//200
	}
	

	
		@GetMapping("/providers/providerName/{providersName}")
		public ResponseEntity<?> getProviderNameList(@PathVariable  String providersName)
		{
			System.out.println("in get provider details"+ providersName);
			Optional<List<ServiceProvider>> providerDetails=service.getAllMatchingProviders(providersName);
			if(providerDetails.isPresent()){
				return new ResponseEntity<>(providerDetails.get(),HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		@GetMapping("/providers/{id}")
		public List<ServiceProvider> getAllServiceProvider(@PathVariable String id)
		{
			System.out.println(id);			
			List<ServiceProvider> s= service.getService(Integer.parseInt(id));
			System.out.println(s);
			return s;
		}
		
		@GetMapping("/ProvidersById/{id}")
		public ServiceProvider getServiceProviderById(@PathVariable String id)
		{
			System.out.println(id);			
			ServiceProvider s= service.findServiceProvideById(Integer.parseInt(id));
			System.out.println(s);
			return s;
		}
	
	
	
		@PostMapping("/Service_provider")
		public ResponseEntity<?> insertServiceProvider(@RequestBody ServiceProvider newProvider)
		{
			System.out.println(newProvider);
			
			
			try
			{
				ServiceProvider ip = service.insertProvider(newProvider);
				return new ResponseEntity<>(ip,HttpStatus.OK);
			}
			catch(RuntimeException e)
			{
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
		@PutMapping("providers/provider_id/{provider_id}")
		public ResponseEntity<?> updateDetails(@PathVariable int provider_id,@RequestBody ServiceProvider updated)
		{
			try
			{
				ServiceProvider up = service.updateProvider(provider_id,updated);
				return new ResponseEntity<>(up,HttpStatus.OK);
			}
			catch(RuntimeException e)
			{
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@DeleteMapping("/providers/ServiceProvider/{spId}")
		public ResponseEntity<?> deleteServiceProvider(@PathVariable int spId)
		{
			System.out.println(spId);
			System.out.println("in the "+getClass().getName());
			try {
				service.deleteProvider(spId);
			return new ResponseEntity<>(HttpStatus.OK);
			}
				catch(RuntimeException e)
			{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
		}
		
		
		@PostMapping("/login/ServiceProvider")
		public ServiceProvider LoginServiceProvider(@RequestBody User u) 
		{
			System.out.println(u);
			return service.ServiceProviderLogin(u);
		}
		
		

		


}
