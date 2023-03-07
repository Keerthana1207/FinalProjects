package com.tourism.demo.entity;

import java.sql.Date;
import org.hibernate.annotations.Check;
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
public class Payment{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name="Payment_id")
	private long payment_id;
	public enum PaymentMode{
		CARD,
		UPI,
		INTERNET_BANKING,
		WALLET
	}
	
	public enum PaymentStatus{
		SUCCESS,
		PENDING,
		FAILED
	}
	
	
	
	@Column(name="mode")
	@NotNull
	@Enumerated(EnumType.STRING)
	private PaymentMode mode= PaymentMode.CARD;
	

	@Column(name="status")
	@NotNull
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	
	 @OneToOne
	 @JoinColumn(name="tour_bookingid",insertable=false,updatable=false) 
	 private Booking bookingjoin;
	
 
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public Payment(long payment_id, @NotNull PaymentMode mode, @NotNull PaymentStatus status, Booking bookingjoin) {
		super();
		this.payment_id = payment_id;
		this.mode = mode;
		this.status = status;
		this.bookingjoin = bookingjoin;
	}




	public long getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(long payment_id) {
		this.payment_id = payment_id;
	}

	

	public PaymentMode getMode() {
		return mode;
	}

	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}


	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}


	public Booking getBookingjoin() {
		return bookingjoin;
	}


	public void setBookingjoin(Booking bookingjoin) {
		this.bookingjoin = bookingjoin;
	}
	
	 
}
