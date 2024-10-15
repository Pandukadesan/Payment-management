package com.payment;

public class PaymentDB {
	private String id;
	private String cardnumber;
	private String cardholdername;
	private String expiredate;
	private String cvv;
	
	public PaymentDB(String id,String cardnumber,String cardholdername,String expiredate,String cvv) {
		this.id = id;
		this.cardnumber = cardnumber;
		this.cardholdername = cardholdername;
		this.expiredate = expiredate;
		this.cvv = cvv;
	}
	
	public String getid() {
		return this.id;
	}
	
	public String getcardnumber() {
		return this.cardnumber;
	}

	public String getcardholdername() {
		return this.cardholdername;
	}
	
	public String getexpiredate() {
		return this.expiredate;
	}
	
	public String getcvv() {
		return this.cvv;
	}
}