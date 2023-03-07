package com.tourism.demo.service;

import java.util.List;

import com.tourism.demo.entity.Place;


public interface PlaceService {
	public  Place addPlace( Place p);
	public List<Place> getAllPlace();		
	public  Place getPlaceById(long place_id);	
	public  Place updatePlace(Place p);
	public String deletePlace(long place_id);
}
