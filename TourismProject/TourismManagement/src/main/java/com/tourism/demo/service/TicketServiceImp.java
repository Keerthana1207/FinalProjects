package com.tourism.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.demo.dao.TicketRepository;
import com.tourism.demo.entity.Ticket;
@Service
public class TicketServiceImp implements TicketService{

	@Autowired TicketRepository dao;
	@Override
	public Ticket addTicket(Ticket t) {
		System.out.println("Ticket added Succesfully "+t);
		t.setDate(t.getDate());
		t.setBookingjoin(t.getBookingjoin());
		t.setTransportjoin(t.getTransportjoin());
		t.setCreatedTimesatmp(t.getCreatedTimesatmp());
		t.setUpdateTimestamp(t.getUpdateTimestamp());
		return dao.save(t);
	}

	@Override
	public List<Ticket> getAllTicket() {
		return this.dao.findAll();
	}

	@Override
	public Ticket getTicketById(long Ticket_id) {	
		return this.dao.findById(Ticket_id).orElse(null);
	}

	@Override
	public Ticket updateTicket(Ticket t) {
	Ticket existsticket=dao.findById(t.getTicket_id()).orElse(null);
	existsticket.setDate(t.getDate());
	existsticket.setBookingjoin(t.getBookingjoin());
	existsticket.setTransportjoin(t.getTransportjoin());
	existsticket.setCreatedTimesatmp(t.getCreatedTimesatmp());
	existsticket.setUpdateTimestamp(t.getUpdateTimestamp());
		return dao.save(existsticket);
	}

	@Override
	public String deleteTicket(long Ticket_id) {
		Ticket existsID=dao.findById(Ticket_id).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(Ticket_id);
		return "Ticket deleted!!";
		}
		else
		{
		return "Ticket does not exist!!";
		}
		
	}

}
