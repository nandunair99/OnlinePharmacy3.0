<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.narola.pharmacy.utility.Constant" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
</head>
<body>

<form method="POST" id="checkoutForm" action="https://api.razorpay.com/v1/checkout/embedded">
    <input type="hidden" name="key_id" value="${Constant.RAZORPAY_KEY_ID}">
    <input type="hidden" name="amount" value="${OrderBean.getTotalAmount()}">
    <input type="hidden" name="order_id" value="${OrderBean.getRazorpayOrderId()}">
    <input type="hidden" name="name" value="PharmEasy">
    <input type="hidden" name="description" value="Online pharmacy">
    <input type="hidden" name="image" value="https://assets.pharmeasy.in/web-assets/dist/fca22bc9.png">
    <input type="hidden" name="prefill[name]"
           value="${OrderBean.getCustomerBean().getFirstName()}${OrderBean.getCustomerBean().getLastName()}">
    <input type="hidden" name="prefill[contact]" value="${OrderBean.getCustomerBean().getContactNo()}">
    <input type="hidden" name="prefill[email]" value="${OrderBean.getCustomerBean().getEmailId()}">
    <input type="hidden" name="notes[shipping address]" value="${OrderBean.getCustomerBean().getAddress()}">
    <input type="hidden" name="callback_url" value="${callBackUrl }">
    <input type="hidden" name="cancel_url" value="${callBackUrl}">

</form>

</body>
<script type="text/javascript">

    function formAutoSubmit() {

        var frm = document.getElementById("checkoutForm");

        frm.submit();

    }

    window.onload = formAutoSubmit;

</script>
</html>