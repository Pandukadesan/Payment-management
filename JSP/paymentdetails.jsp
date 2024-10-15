<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="paymentboxstyle.css">
</head>
<body>
	 <div class="whitebox">
    <form>
  
	<c:forEach var="payment2" items="${paymentdetails}">
	
		<c:set var="id" value="${payment2.id}"/>
		<c:set var="crdnumber" value="${payment2.cardnumber}"/>
		<c:set var="crdholdername" value="${payment2.cardholdername}"/>
		<c:set var="expdate" value="${payment2.expiredate}"/>
		<c:set var="CVV" value="${payment2.cvv}"/>
		
		<h1 class="carddetails">Card details</h1><br>
        <input type="text" name="cardnumber" class="cardnumberbox" value="${payment2.cardnumber}" readonly><br><br>
        <input type="text" name="cardholdername" class="cardholdernamebox" value="${payment2.cardholdername}" readonly><br><br>
        <input type="text" name="expiredate" class="expiredatebox" value="${payment2.expiredate}"readonly><br><br>
        <input type="text" name="cvv" class="cvvbox" value="${payment2.cvv}" readonly><br><br>
		
	</c:forEach>
		
	
	<c:url value ="paymentupdate.jsp" var="updatepayment" >
		<c:param name="id" value="${id}"/>
		<c:param name="crdnumber" value="${crdnumber}"/>
		<c:param name="crdholdername" value="${crdholdername}"/>
		<c:param name="expdate" value="${expdate}"/>
		<c:param name="CVV" value="${CVV}"/>
	</c:url>
	
	<a href="${updatepayment}">
        <input type ="button" name="update" value="Update Card Details" class="updatedatabutton">
    </a>
	
	
	<c:url value ="deletecustomer.jsp" var="deletepayment" >
		<c:param name="id" value="${id}"/>
		<c:param name="crdnumber" value="${crdnumber}"/>
		<c:param name="crdholdername" value="${crdholdername}"/>
		<c:param name="expdate" value="${expdate}"/>
		<c:param name="CVV" value="${CVV}"/>
	</c:url>
	
	 <a href="${deletepayment}">
     <input type="button" name="delete" value="Delete Card" class="deletebutton">
     </a>
	 </form>
    </div>
</body>
</html>

