package com.tourism.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.tourism.demo.entity.Booking;

public interface BookingService {

	public List<Booking> getAllBooking();		
	public  Booking getBookingById(long Booking_id);	
	public  Booking updateBooking(Booking b);
	public String deleteBooking(long Booking_id);

	
}
