package com.tourism.demo.service;

import java.util.List;

import com.tourism.demo.entity.Transport;

public interface TransportService {
	public  Transport addTransport( Transport ts);
	public List<Transport> getAllTransport();		
	public  Transport getTransportById(long Transport_id);	
	public  Transport updateTransport(Transport ts);
	public String deleteTransport(long Transport_id);
	
}
