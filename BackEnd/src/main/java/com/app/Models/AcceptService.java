package com.app.Models;

public class AcceptService 
{
  int serviceId;
  int rating;
  String description;
  
public int getServiceId() {
	return serviceId;
}
public void setServiceId(int serviceId) {
	this.serviceId = serviceId;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "AcceptService [serviceId=" + serviceId + ", rating=" + rating + ", description=" + description + "]";
}
  
 
  
}
