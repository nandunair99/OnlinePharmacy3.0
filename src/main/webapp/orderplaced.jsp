<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>
        #orderSuccessDiv {
            padding: 30px;
            z-index: 3000;
            max-height: 500px;
            max-width: 500px;
            overflow: auto;
            border: 5px solid black;
            border-radius: 15px;
            min-height: 300px;
        }

        #messageBody {
            background-color: rgb(0, 0, 0);
            background-color: rgb(0, 0, 0, 0.2);
            min-height: 100vh;
            vertical-align: middle;
            display: flex;
            font-family: Muli;
            font-size: 14px;
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            overflow: auto;
            top: 0;
            left: 0;
            z-index: 3000;
            width: 100%;
            text-align: center;
        }

        .card {
            margin: auto;
            width: 320px;
            max-width: 600px;
            border-radius: 20px
        }

        .mt-50 {
            margin-top: 50px
        }

        .mb-50 {
            margin-bottom: 50px
        }

        @media ( max-width: 767px) {
            .card {
                width: 80%
            }
        }

        @media ( height: 1366px) {
            .card {
                width: 75%
            }
        }

        #orderno {
            padding: 1vh 2vh 0;
            font-size: smaller
        }

        .gap .col-2 {
            background-color: rgb(213, 217, 233);
            width: 1.2rem;
            padding: 1.2rem;
            margin-top: -2.5rem;
            border-radius: 1.2rem
        }

        .title {
            display: flex;
            text-align: center;
            font-size: 2rem;
            font-weight: bold;
            padding: 12%
        }

        .main {
            padding: 0 2rem
        }

        .main img {
            border-radius: 7px
        }

        .main p {
            margin-bottom: 0;
            font-size: 0.75rem
        }

        #sub-title p {
            margin: 1vh 0 2vh 0;
            font-size: 1rem
        }

        .row-main {
            padding: 1.5vh 0;
            align-items: center
        }

        hr {
            margin: 1rem -1vh;
            border-top: 1px solid rgb(214, 214, 214)
        }

        .total {
            font-size: 1rem
        }

        @media ( height: 1366px) {
            .main p {
                margin-bottom: 0;
                font-size: 1.2rem
            }

            .total {
                font-size: 1.5rem
            }
        }

        .btn {
            background-color: rgb(3, 122, 219);
            border-color: rgb(3, 122, 219);
            color: white;
            margin: 7vh 0;
            border-radius: 7px;
            width: 200px;
            font-size: 0.8rem;
            padding: 0.8rem;
            justify-content: center
        }

        .btn:focus {
            box-shadow: none;
            outline: none;
            box-shadow: none;
            color: white;
            -webkit-box-shadow: none;
            -webkit-user-select: none;
            transition: none
        }

        .btn:hover {
            color: white
        }
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
</head>
<body>
<div id="messageBody">
    <div id="orderSuccessDiv" class="card mt-50 mb-50"
         style="padding: 30px; z-index: 3000; max-height: 500px; max-width: 500px; overflow: auto; border: 5px solid black; border-radius: 15px; min-height: 300px">

        <div style="">
            <div style="height: 100px; width: 100px; margin-left: 70px">
                <c:if test="${ShowOrderSuccess=='true'}">
                    <c:set var="imageSource" scope="page"
                           value="${pageContext.request.contextPath }/images/resource/shopping-cart.png"/>
                </c:if>
                <c:if test="${ShowOrderSuccess=='false'}">
                    <c:set var="imageSource" scope="page"
                           value="${pageContext.request.contextPath }/images/resource/payment-failure.png"/>
                </c:if>
                <img style="height: 100px; width: 100px" src="${imageSource}">
            </div>
        </div>
        <c:if test="${ShowOrderSuccess=='true'}">
            <c:set var="paymentMessage" scope="page"
                   value="Thank you for your order!"/>
        </c:if>
        <c:if test="${ShowOrderSuccess=='false'}">
            <c:set var="paymentMessage" scope="page"
                   value="Sorry, ${paymentErrorMsg} !"/>
        </c:if>
        <div class="title mx-auto">${paymentMessage}</div>
        <c:if test="${ShowOrderSuccess=='true'}">
            <button class="btn d-flex mx-auto">Track your order</button>
        </c:if>

        <a onclick="hideSuccessPage()"><i
                class="fas fa-long-arrow-alt-left me-2"></i>&#8636;Back to shopping
        </a>
    </div>
</div>
<script src="resources/js/bootstrap.min.js"></script>
<script>
    function hideSuccessPage() {
        //<c:set var="ShowOrderSuccess" value="false" scope="request"/>
        $("#messageBody").hide();
        //alert(<c:out value="${ShowOrderSuccess}"/>);


    }
</script>
</body>
</html>