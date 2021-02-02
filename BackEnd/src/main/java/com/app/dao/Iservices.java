package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.ServiceProvider;
import com.app.pojos.Services;

public interface Iservices extends JpaRepository<Services, Integer> 
{
   @Query(value ="select * from services where user_id=:id",nativeQuery = true)
  List<Services> findByUser_Id(@Param("id") int id);	
   
   @Query(value = "select * from services where service_provider=:id and serstatus=1", nativeQuery = true)
   List<Services> findToUnaccepted(@Param("id") int id);
   
}
