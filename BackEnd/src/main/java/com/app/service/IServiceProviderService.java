package com.app.service;

import java.util.List;
import java.util.Optional;



import com.app.pojos.ServiceProvider;

public interface IServiceProviderService 
{
	//list of all service provider
	List<ServiceProvider> getAllProviders();
	Optional<List<ServiceProvider>>getAllMatchingProviders(String sname);
	//list of provider by service name
	//Optional<ServiceProvider> getProviderDetails(String sName);
	ServiceProvider insertProvider(ServiceProvider sp);
	ServiceProvider updateProvider(int sp_id,ServiceProvider oldDetails);
	List<ServiceProvider> getService(int id);
	ServiceProvider deleteProvider(int spId);
	ServiceProvider findServiceProvideById(int id);
	ServiceProvider ServiceProviderLogin(com.app.Models.User u);
 
	
}

	





