package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Models.User;
import com.app.dao.IServiceProviderDao;
import com.app.pojos.ServiceProvider;

@Service
@Transactional

public class ServiceProviderImpl implements IServiceProviderService {

	@Autowired
	private IServiceProviderDao dao;
	
	
	@Override
	public List<ServiceProvider> getAllProviders() {
		System.out.println("dao impl class "+dao.getClass().getName());
		return dao.findAll();
	}


	/*
	 * @Override public Optional<List<ServiceProvider>> getProviderDetails(String
	 * sName) { // TODO Auto-generated method stub return
	 * dao.findByServiceName(sName); }
	 */
	
	

	@Override
	public Optional<List<ServiceProvider>> getAllMatchingProviders(String sname) {
		// TODO Auto-generated method stub
		return dao.findByServiceName(sname);
	}
	


	@Override
	public ServiceProvider insertProvider(ServiceProvider sp) {
		// TODO Auto-generated method stub
		System.out.println(sp.getServiceName());
		return dao.save(sp);
	}


	@Override
	public ServiceProvider updateProvider(int sp_id,ServiceProvider oldDetails) {
		Optional<ServiceProvider>checkPresence=dao.findById(sp_id);
		if(checkPresence.isPresent())
		{
			ServiceProvider updatedDetails=checkPresence.get();
			updatedDetails.setFirstName(oldDetails.getFirstName());
			updatedDetails.setLastName(oldDetails.getLastName());
			updatedDetails.setEmail(oldDetails.getEmail());
			updatedDetails.setPassword(oldDetails.getPassword());
			updatedDetails.setCharges(oldDetails.getCharges());
			updatedDetails.setAadharNumber(oldDetails.getAadharNumber());
			updatedDetails.setAddress(oldDetails.getAddress());
			updatedDetails.setDob(oldDetails.getDob());
			updatedDetails.setExperience(oldDetails.getExperience());
			updatedDetails.setMobile(oldDetails.getMobile());
			updatedDetails.setGender(oldDetails.getGender());
			updatedDetails.setServiceName(oldDetails.getServiceName());
		
			return updatedDetails;
		}
		return null;
	}


	
	@Override
	public ServiceProvider deleteProvider(int spId) {
		dao.deleteById(spId);
		return null;
	}


	@Override
	public List<ServiceProvider> getService(int id) 
	{
		return dao.findByService_id(id);
	}


	@Override
	public ServiceProvider findServiceProvideById(int id) {
		// TODO Auto-generated method stub
		return dao.findBy_sp_id(id);
	}


	@Override
	public ServiceProvider ServiceProviderLogin(User u) {
		
		System.out.println(u.getUsername());
		System.out.println(u.getPassword());
		ServiceProvider s= dao.findByServiceProviderIdandPasswword(u.getUsername(), u.getPassword());
		System.out.println("List Of Data");
		System.out.println(s);
		return s;
	}


}





