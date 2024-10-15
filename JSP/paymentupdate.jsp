<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="updatepaymentboxstyle.css">
</head>
<body>

	<%
		String id = request.getParameter("id");
		String crdnumber = request.getParameter("crdnumber");
		String crdholdername = request.getParameter("crdholdername");
		String expdate = request.getParameter("expdate");
		String CVV = request.getParameter("CVV");
	%>
	
	<div class="whitebox">
	<form action="UpdatePaymentServlet" method="post">
	
	 <h1 class="updatecarddetails">Update Card Details</h1><br>
        <input type="text" name="crdnumber" value="<%=crdnumber%>" class="cardnumberbox"><br><br>
        <input type="text" name="crdholdername" value="<%=crdholdername%>" class="cardholdernamebox"><br><br>
        <input type="text" name="expdate" value="<%=expdate%>" class="expiredatebox"><br><br>
        <input type="text" name="cvv" value="<%=CVV%>" class="cvvbox"><br><br>
	
		<input type="hidden" name="id" value="<%=id%>"><br>
		
		<input type="submit" name="submit" value="Update Card details" class="updatedatabutton">
	</form>
	</div>
	
</body>
</html>