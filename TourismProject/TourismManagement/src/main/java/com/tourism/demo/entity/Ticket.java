package com.tourism.demo.entity;

import java.security.Timestamp;
import java.util.Date;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;
@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Ticket_id")
	private long Ticket_id;
	
	@Column(name ="date")
	@NotNull
	private Date date;

	@Column(name = "created_at", updatable = false)
	@PastOrPresent
	private Timestamp createdTimesatmp=null;

	@Column(name = "last_update")
	@PastOrPresent
	private Timestamp updateTimestamp=null;

	public Timestamp getCreatedTimesatmp() {
	return createdTimesatmp;	 
	}
	
	@ManyToOne(targetEntity=Booking.class,fetch=FetchType.EAGER)  
	@JoinColumn(name="tour_bookingid",insertable=false,updatable=false) 
	private Booking bookingjoin;
	  
	 
	 @ManyToOne(targetEntity=Transport.class,fetch=FetchType.EAGER)	 
	 @JoinColumn(name="tour_tranid",insertable = false,updatable = false) 
	 private Transport transportjoin;
	
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Ticket(long ticket_id, @NotNull Date date, @PastOrPresent Timestamp createdTimesatmp,
			@PastOrPresent Timestamp updateTimestamp, Booking bookingjoin, Transport transportjoin) {
		super();
		Ticket_id = ticket_id;
		this.date = date;
		this.createdTimesatmp = createdTimesatmp;
		this.updateTimestamp = updateTimestamp;
		this.bookingjoin = bookingjoin;
		this.transportjoin = transportjoin;
	}




	public Booking getBookingjoin() {
		return bookingjoin;
	}





	public void setBookingjoin(Booking bookingjoin) {
		this.bookingjoin = bookingjoin;
	}





	public Transport getTransportjoin() {
		return transportjoin;
	}





	public void setTransportjoin(Transport transportjoin) {
		this.transportjoin = transportjoin;
	}





	public long getTicket_id() {
		return Ticket_id;
	}

	public void setTicket_id(long ticket_id) {
		Ticket_id = ticket_id;
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Timestamp getUpdateTimestamp() {
		return updateTimestamp;
	}


	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}



	public void setCreatedTimesatmp(Timestamp createdTimesatmp) {
		this.createdTimesatmp = createdTimesatmp;
	}

	

}
