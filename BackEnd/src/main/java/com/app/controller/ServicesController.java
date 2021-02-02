package com.app.controller;

import java.io.Console;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.Iservices;
import com.app.pojos.Services;

@RestController
@CrossOrigin(origins = "*")
public class ServicesController 
{
  @Autowired
  private Iservices service;
  
  @GetMapping("/services/findAll")
  List<Services> findAllServices()
  {
	  return service.findAll();
  }
  
 
  @GetMapping("/getservices/{id}")
  List<Services> findAllServices(@PathVariable String id)
  {
	  return service.findByUser_Id(Integer.parseInt(id));
  }
 
  @PostMapping("/addService")
  Services SaveService(@RequestBody Services serv) 
  {
	  LocalDate today=LocalDate.now();
	  serv.setSerDate(today);
	  System.out.println(serv.getSerDate());
	  System.out.println(serv);
	  return this.service.save(serv);
  }
  
  @GetMapping("/Services/{id}")
  List<Services> ListServicesToBeAccepted(@PathVariable String id)
  {
	  System.out.println(this.service.findToUnaccepted(Integer.parseInt(id)));
	  return this.service.findToUnaccepted(Integer.parseInt(id));
  }
  
  @GetMapping("/service/allow/{id}")
  Optional<Services> Allow(@PathVariable String id)
  {
	  System.out.println("allow");
	  Optional<Services> existing=this.service.findById(Integer.parseInt(id));
	  Services exist=existing.get();
	  exist.setFeedbackstatus(2);
	  exist.setSerstatus(2);
	  service.save(exist);
	  return this.service.findById(Integer.parseInt(id));
  }
  
  @GetMapping("/service/deny/{id}")
  Optional<Services> Deny(@PathVariable String id)
  {
	  System.out.println("deny");

	  Optional<Services> existing=this.service.findById(Integer.parseInt(id));
	  Services exist=existing.get();
	  exist.setSerstatus(3);
	  exist.setFeedbackstatus(3);
	  service.save(exist);
	  return this.service.findById(Integer.parseInt(id));
  }
  
  
  @GetMapping("/FindAllServices")
  List<Services> findwholeAllServices()
  {
	  return this.service.findAll();
  }
  

}
