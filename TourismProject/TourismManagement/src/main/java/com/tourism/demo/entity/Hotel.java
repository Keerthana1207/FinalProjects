package com.tourism.demo.entity;

import org.hibernate.validator.constraints.Length;

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
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;

@Entity

public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name ="hotel_id")
	 private Long hotel_id;
	
	@Column(name ="hotel_name")
	 private String hotel_name;
	
	@Column(name = "street")
	@NotNull
	private String street;
	
	@Column(name = "district")
	@NotNull
	private String district;
	

	@Column(name = "state")
	@NotNull
	/* @Length(min = 2, max =10) */
	private String state;
	
	@Column(name = "zip" , length = 6)
	@NotNull
	private int zip;
	
	@Column(name ="hotel_desc")
	 private String hotel_desc;
	
	@Column(name ="hotel_fair")
	 private String hotel_fair;
		
		
		/*
		 * @ManyToOne(cascade = CascadeType.ALL)
		 * 
		 * @JoinColumn(name = "tour_placeid",referencedColumnName = "id") private Place
		 * placejoin;
		 */
			/*
			 * @ManyToOne(cascade = CascadeType.ALL)
			 * 
			 * @JoinColumn(name = "dest_id",referencedColumnName = "id") 
			 * private Place place;
			 */
	  @ManyToOne(targetEntity=Place.class,fetch=FetchType.EAGER) 
	  @JoinColumn(name="tour_placeid",insertable=false,updatable=false) 
	  private Place placejoin;
			 
	
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Hotel(Long hotel_id, String hotel_name, @NotNull String street, @NotNull String district,
			 String state, @NotNull @Pattern(regexp = "(^$|[0-9]{6})") int zip,
			String hotel_desc, String hotel_fair, Set<Place> place) {
		super();
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.street = street;
		this.district = district;
		this.state = state;
		this.zip = zip;
		this.hotel_desc = hotel_desc;
		this.hotel_fair = hotel_fair;
	
	}




	public void setHotel_id(Long hotel_id) {
		this.hotel_id = hotel_id;
	}


	public long getHotel_id() {
		return hotel_id;
	}


	public void setHotel_id(long  hotel_id) {
		this.hotel_id = hotel_id;
	}


	public String getHotel_name() {
		return hotel_name;
	}


	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZip() {
		return zip;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}


	public String getHotel_desc() {
		return hotel_desc;
	}


	public void setHotel_desc(String hotel_desc) {
		this.hotel_desc = hotel_desc;
	}


	public String getHotel_fair() {
		return hotel_fair;
	}


	public void setHotel_fair(String hotel_fair) {
		this.hotel_fair = hotel_fair;
	}



	
}
