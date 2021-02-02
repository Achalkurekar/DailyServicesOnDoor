package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "booking_cart")
public class BookingCart {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private Integer CartId;	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate BookingDate;
	
	@Column(name="duration")
	private Double Duration;
	
	//many to one relation of booking cart with user
	//many booking can be done by the same user
	@ManyToOne
	@JoinColumn(name = "UserId",nullable = false)
	private User user;
	
	//many to one relation of service provider with services
	//many sp can give the same service
	@ManyToOne
	@JoinColumn(name = "ServiceProviderId",nullable = false)
	private ServiceProvider sp;
			
	
	public BookingCart() {
		System.out.println("in constructor of "+getClass().getName());
	}
	
	

	public BookingCart(Integer cartId,LocalDate bookingDate, Double duration, User user, ServiceProvider sp) {
		super();
		CartId = cartId;
		BookingDate = bookingDate;
		Duration = duration;
		this.user = user;
		this.sp = sp;
	}



	public Integer getCartId() {
		return CartId;
	}



	public void setCartId(Integer cartId) {
		CartId = cartId;
	}



	public LocalDate getBookingDate() {
		return BookingDate;
	}



	public void setBookingDate(LocalDate bookingDate) {
		BookingDate = bookingDate;
	}



	public Double getDuration() {
		return Duration;
	}



	public void setDuration(Double duration) {
		Duration = duration;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public ServiceProvider getSp() {
		return sp;
	}



	public void setSp(ServiceProvider sp) {
		this.sp = sp;
	}



	@Override
	public String toString() {
		return "BookingCart [CartId=" + CartId + ", BookingDate=" + BookingDate + ", Duration=" + Duration + ", user="
				+ user + ", sp=" + sp + "]";
	}



	
}
