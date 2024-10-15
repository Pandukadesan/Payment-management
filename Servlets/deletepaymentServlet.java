package com.payment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletepaymentServlet")
public class deletepaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String cardnumber = request.getParameter("crdnumber");
		String cardholdername = request.getParameter("crdholdername");
		String expiredate = request.getParameter("expdate");
		String cvv = request.getParameter("cvv");
		
		boolean boo;
		boo = paymentDBUtil.deletepaymentdetails(id);
		
		if(boo == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("paymentinsert.jsp");
			dispatcher.forward(request, response);
		}
		else {
			List<PaymentDB> paymentdetails = paymentDBUtil.getCustomerDetails(id);
			request.setAttribute("paymentdetails", paymentdetails);

			RequestDispatcher dispatcher = request.getRequestDispatcher("paymentdetails.jsp");
			dispatcher.forward(request, response);
		}
	}

}

