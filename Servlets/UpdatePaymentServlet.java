package com.payment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdatePaymentServlet")
public class UpdatePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String cardnumber = request.getParameter("crdnumber");
		String cardholdername = request.getParameter("crdholdername");
		String expiredate = request.getParameter("expdate");
		String cvv = request.getParameter("cvv");
		
		boolean boo;
		
		boo = paymentDBUtil.updatepaymentdetails(id,cardnumber, cardholdername, expiredate, cvv);
		
		if(boo == true) {
			List<PaymentDB> paymentdetails = paymentDBUtil.getCustomerDetails(id);
			request.setAttribute("paymentdetails", paymentdetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("paymentdetails.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
		}
	}

}
