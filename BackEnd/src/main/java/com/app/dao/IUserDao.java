package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository
public interface IUserDao extends JpaRepository<User, Integer>{
	
	@Query(value ="select * from user where user_id=:id",nativeQuery = true)
	User findByUser_id(@Param("id") int id);
	
	@Query(value ="select * from user where email=:email and password=:password" ,nativeQuery = true)
	User findByUserIdandPasswword(@Param("email")String email , @Param("password")String password);
	

}




