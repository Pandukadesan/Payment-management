<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="deletepayment.css">
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
	<form action="deletepaymentServlet" method="post">
		<h1 class="updatecarddetails">Delete Card Details</h1><br>
		<input type="hidden" name="id" value="<%=id%>">
		<input type="text" class="cardnumberbox" name="crdnumber" value="<%=crdnumber%>"><br><br>
		<input type="text" class="cardholdernamebox" name="crdholdername" value="<%=crdholdername%>"><br><br>
		<input type="text" class="expiredatebox" name="expdate" value="<%=expdate%>"><br><br>
		<input type="text" class="cvvbox" name="cvv" value="<%=CVV%>"><br><br>
		
		<input type="submit" name="submit" value="Delete Card" class="deletebutton">
	</form>
	</div>
</body>
</html>