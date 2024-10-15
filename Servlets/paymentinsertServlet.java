package com.payment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/paymentinsertServlet")
public class paymentinsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardnumber = request.getParameter("cardnumber");
		String cardholdername = request.getParameter("cardholdername");
		String exipredate = request.getParameter("expiredate");
		String cvv = request.getParameter("cvv");
		
		boolean boo;
		
		boo = paymentDBUtil.insertpayment(cardnumber, cardholdername, exipredate, cvv);
		
		if(boo == true) {
			List<PaymentDB> paymentdetails = paymentDBUtil.getCustomerDetails(cardnumber, cardholdername, exipredate, cvv);
			request.setAttribute("paymentdetails", paymentdetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("paymentdetails.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
		}
		
		
	}

}
