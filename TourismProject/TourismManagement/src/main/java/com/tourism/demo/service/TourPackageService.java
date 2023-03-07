package com.tourism.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.tourism.demo.entity.TourPackage;


public interface TourPackageService  {
	public  TourPackage addTourPackage( @Valid TourPackage pa);
	public List<TourPackage> getAllPackage();		
	public  TourPackage getPackageById(long Package_id);	
	public  TourPackage updateTourPackage(TourPackage pa);
	public String deleteTourPackage(long Package_id);

	
}
