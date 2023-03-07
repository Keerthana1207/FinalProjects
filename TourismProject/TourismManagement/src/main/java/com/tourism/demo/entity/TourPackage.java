package com.tourism.demo.entity;

//import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;
@Entity
public class TourPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name ="Package_id")
	private long Package_id;
	
	@Column(name ="package_name")
	private String package_name;
	
	@Column(name ="package_amount")
	private Long package_amount;
	

	public enum Package_Type{
		Couple,
		Family,
		Holiday
		
	}
	
	@Column(name ="")
	private String package_desc;
	@ManyToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
	)
	
	@JoinTable(name = "package_place_map",
		joinColumns = {@JoinColumn(name="pkg_id")},
		inverseJoinColumns = {@JoinColumn(name="place_id")}
	)

	private Set<Place> placejoin;
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "package_transport_map",
	joinColumns = {@JoinColumn(name="pkg_id")},
	inverseJoinColumns = {@JoinColumn(name="transport_id")})	
	private Set<Transport> transportjoin;
		
	
	
	public TourPackage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TourPackage(long Package_id, String package_name, Long package_amount, Double package_total,
			String package_desc) {
		super();
		this.Package_id = Package_id;
		this.package_name = package_name;
		this.package_amount = package_amount;
		this.package_desc = package_desc;
	}

	

	public long getPackage_id() {
		return Package_id;
	}

	public void setPackage_id(long package_id) {
		Package_id = package_id;
	}

	public String getPackage_name() {
		return package_name;
	}

	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}

	public Long getPackage_amount() {
		return package_amount;
	}

	public void setPackage_amount(Long package_amount) {
		this.package_amount = package_amount;
	}


	public String getPackage_desc() {
		return package_desc;
	}

	public void setPackage_desc(String package_desc) {
		this.package_desc = package_desc;
	}
	

	
	
	
	
}
