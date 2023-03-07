package com.tourism.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity

public class Transport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name ="Transport_id")
	private long Transportation_id;
	
	@Column(name ="transport_name")
	private String transport_name;
	
	@Column(name ="vtype")
	private String vtype;
	
	@Column(name ="trans_desc")
	private String trans_desc;

	
	  @OneToMany(mappedBy="transportjoin") 
	  private Set<Ticket>ticket;
	
		@ManyToMany(
				cascade = CascadeType.ALL,
				mappedBy = "transportjoin",
				fetch = FetchType.EAGER
		)

		private Set<TourPackage> packages;
		
	public Transport() {
		super();
		
	}



	public Transport(long transportation_id, String transport_name, String vtype, String trans_desc, Set<Ticket> ticket,
			Set<TourPackage> packages) {
		super();
		Transportation_id = transportation_id;
		this.transport_name = transport_name;
		this.vtype = vtype;
		this.trans_desc = trans_desc;
		this.ticket = ticket;
		this.packages = packages;
	}




	public Set<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(Set<Ticket> ticket) {
		this.ticket = ticket;
	}


	public Set<TourPackage> getPackages() {
		return packages;
	}

	public void setPackages(Set<TourPackage> packages) {
		this.packages = packages;
	}

	public long getTransportation_id() {
		return Transportation_id;
	}

	public void setTransportation_id(long transportation_id) {
		Transportation_id = transportation_id;
	}


	public String getTransport_name() {
		return transport_name;
	}

	public void setTransport_name(String transport_name) {
		this.transport_name = transport_name;
	}


	public String getVtype() {
		return vtype;
	}


	public void setVtype(String vtype) {
		this.vtype = vtype;
	}


	public String getTrans_desc() {
		return trans_desc;
	}


	public void setTrans_desc(String trans_desc) {
		this.trans_desc = trans_desc;
	}

	
}