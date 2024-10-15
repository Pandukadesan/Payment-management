package com.payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class paymentDBUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs   = null;
	
	public static List<PaymentDB> validate(String id,String cardnumber,String cardholdername,String expiredate,String cvv){
		ArrayList<PaymentDB> bank = new ArrayList<>();
		
		try {
			con = DBConnect.getconnection();
			stmt = con.createStatement();
			String sql = " select * from Bank where Card_Number ='"+cardnumber+"' AND Card_Holder_Name ='"+cardholdername+"' Expire_Date = '"+expiredate+"' AND CVV = '"+cvv+"' ";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				String ID = rs.getString(1);
				String cardnum = rs.getString(2);
				String chname = rs.getString(3);
				String exp = rs.getString(4);
				String CVV = rs.getString(5);
				
				PaymentDB paymentdb = new PaymentDB(id,cardnum,chname,exp,CVV);
				bank.add(paymentdb);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return bank;
	}
	
	

	public static boolean insertpayment(String cardnumber,String cardholdername,String expiredate,String cvv) {
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getconnection();
			stmt = con.createStatement();
			String sql = "insert into card_details values (0,'"+cardnumber+"','"+cardholdername+"','"+expiredate+"','"+cvv+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return isSuccess;
	}
	
	public static boolean updatepaymentdetails(String id,String cardnumber,String cardholdername,String expiredate,String cvv) {
		
		try {
			con = DBConnect.getconnection();
			stmt = con.createStatement();
			String sql = "Update card_details set Card_Number='"+cardnumber+"',Card_Holder_Name='"+cardholdername+"',Expire_Date='"+expiredate+"',CVV='"+cvv+"'" + "where id='"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false; 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public static List<PaymentDB> getCustomerDetails(String id){
		ArrayList<PaymentDB> bank2 = new ArrayList<>();
		
		try {
			con = DBConnect.getconnection();
			stmt = con.createStatement();
			String sql = "select * from card_details where id = '"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String ID = rs.getString(1);
				String crdnumber = rs.getString(2);
				String cardholdername = rs.getString(3);
				String expiredate = rs.getString(4);
				String cvv = rs.getString(5);
				
				PaymentDB payment2 = new PaymentDB(ID,crdnumber,cardholdername,expiredate,cvv);
				bank2.add(payment2);
			}
		}
		catch(Exception e) {
			e.printStackTrace();		}
		
		return bank2;
	}
	
	public static List<PaymentDB> getCustomerDetails(String cardnumber,String cardholdername,String exipredate,String cvv){
		ArrayList<PaymentDB> bank3 = new ArrayList<>();
		
		try {
			con = DBConnect.getconnection();
			stmt = con.createStatement();
			String sql = "select * from card_details where Card_Number='"+cardnumber+"' AND Card_Holder_Name='"+cardholdername+"' AND Expire_Date='"+exipredate+"' AND CVV='"+cvv+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString(1);
				String crdnumber = rs.getString(2);
				String crdholdername = rs.getString(3);
				String expdate = rs.getString(4);
				String CVV = rs.getString(5);
				
				PaymentDB payment2 = new PaymentDB(id,crdnumber,crdholdername,expdate,CVV);
				bank3.add(payment2);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return bank3;
	}
	
	public static boolean deletepaymentdetails(String id) {
		try {
			con = DBConnect.getconnection();
			stmt = con.createStatement();
			String sql = "delete from card_details where id ='"+id+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

}


