package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.ServiceProvider;
import com.app.pojos.User;

import java.lang.String;

@Repository
public interface IServiceProviderDao extends JpaRepository<ServiceProvider, Integer>{
	
	Optional<List<ServiceProvider>> findByServiceName(String servicename);
	
	@Query(value ="select * from service_provider where sp_id=:id" ,nativeQuery = true)
	ServiceProvider findBy_sp_id(@Param("id") Integer id);
	
	@Query(value ="select * from service_provider where service_id=:id",nativeQuery = true)
	List<ServiceProvider> findByService_id(@Param("id") int id);
	
	List<ServiceProvider> findAll();
	

	@Query(value ="select * from service_provider where email=:email and password=:password" ,nativeQuery = true)
	ServiceProvider findByServiceProviderIdandPasswword(@Param("email") String email , @Param("password") String password);
	
	
}
