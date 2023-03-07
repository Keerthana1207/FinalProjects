package com.tourism.demo.service;

import java.util.List;

import com.tourism.demo.entity.Ticket;

public interface TicketService {
	public  Ticket addTicket( Ticket t);
	public List<Ticket> getAllTicket();		
	public  Ticket getTicketById(long Ticket_id);	
	public  Ticket updateTicket(Ticket t);
	public String deleteTicket(long Ticket_id);
}
