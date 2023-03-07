package com.tourism.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.demo.dao.PlaceRepository;
import com.tourism.demo.entity.Place;
@Service
public class PlaceServiceImp implements  PlaceService{

	@Autowired
	PlaceRepository dao;
	@Override
	
	public Place addPlace(Place p) {
		System.out.println("place added Succesfully "+p);
		p.setPlace_name(p.getPlace_name());
		p.setStreet(p.getStreet());
		p.setDistrict(p.getDistrict());
		p.setZip(p.getZip());
		p.setStreet(p.getStreet());
		return dao.save(p);
	}

	@Override
	public List<Place> getAllPlace() {		
		return dao.findAll();
	}

	@Override
	public Place getPlaceById(long Place_id) {
	
		return this.dao.findById(Place_id).orElse(null);
	}

	@Override
	public Place updatePlace(Place p) {
		Place existspkg=dao.findById(p.getPlace_id()).orElse(null);
		existspkg.setPlace_name(p.getPlace_name());
		existspkg.setStreet(p.getStreet());
		existspkg.setDistrict(p.getDistrict());
		existspkg.setZip(p.getZip());
		existspkg.setStreet(p.getStreet());
		return dao.save(existspkg);
	}

	@Override
	public String deletePlace(long Place_id) {
		Place existsID=dao.findById(Place_id).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(Place_id);
		return "palce deleted!!";
		}
		else
		{
		return "Place  does not exist!!";
		}
		
	}

}
