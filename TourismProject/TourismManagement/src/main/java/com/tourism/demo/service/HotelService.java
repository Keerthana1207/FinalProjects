package com.tourism.demo.service;

import java.util.List;

import com.tourism.demo.entity.Hotel;


public interface HotelService {
	public  Hotel addHotel( Hotel h);
	public List<Hotel> getAllHotel();		
	public  Hotel getHotelById(long Hotel_id);	
	public  Hotel updateHotel(Hotel h);
	public String deleteHotel(long Hotel_id);
	//public void deleteHotel(int hotel_id);

	
	
}
