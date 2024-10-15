<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
<link rel="stylesheet" href="paymentinsertstyle.css">
</head>
<body>
    <img src = "/Users/pandukadeshan/Desktop/Java/payment/src/main/webapp/cc.png" alt="creditcard" class="creditcard">
    <div class = "form">
	<form action="paymentinsert" method="post" >
        
        <h1 class="entercarddetails">Enter card details</h1>
        <input type="text" placeholder="cardnumber" name="cardnumber" class="cardnumberbox" ><br><br>
        <input type="text" placeholder="cardholder name" name="cardholdername" class="cardholdernamebox"><br><br>
        <input type="text" placeholder="MM/YY" name="expiredate" class="expiredatebox"><br><br>
        <input type="text" placeholder="CVV" name="cvv" class="cvvbox"><br><br>
        
        <input type ="submit" name="submit" value="Save and Confirm" class="button">
    </form>
    </div>
</body>
</html>


