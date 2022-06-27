<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.narola.pharmacy.utility.Constant" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/commonLayout.css">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        * {
            box-sizing: border-box;
        }

        #myInput {
            background-image: url('/css/searchicon.png');
            background-position: 10px 10px;
            background-repeat: no-repeat;
            width: 100%;
            font-size: 16px;
            padding: 12px 20px 12px 40px;
            border: 1px solid #ddd;
            margin-bottom: 12px;
        }

        #myTable {
            border-collapse: collapse;
            width: 100%;
            border: 1px solid #ddd;
            font-size: 18px;
        }

        #myTable th, #myTable td {
            text-align: left;
            padding: 12px;
        }

        #myTable tr {
            border-bottom: 1px solid #ddd;
        }

        #myTable tr.header, #myTable tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
<c:import var="sidebar" url="sidebar.jsp"/>
${sidebar}
<div class="mainArea">
    <div class="headingArea">
        <h1>Manage Order Status</h1>
    </div>
    <div style="height: 100%; overflow: scroll;">
        <h2>Customer Orders</h2>

        <input type="text" id="myInput" onkeyup="myFunction()"
               placeholder="Search..." title="Type in a name">

        <table id="myTable">
            <thead>
            <tr class="header">
                <th style="width: 20%;">OrderId</th>
                <th style="width: 20%;">UserId</th>
                <th style="width: 20%;">Date</th>
                <th style="width: 20%;">Total Amount</th>
                <th style="width: 20%;">Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="orderBean" items="${OrderBeans}">
                <tr class="tableBody">
                    <td>${orderBean.getOrderId() }</td>
                    <td>${orderBean.getUserId() }</td>
                    <td>${orderBean.getDate() }</td>
                    <td>${orderBean.getTotalAmount() }</td>
                    <td><select onchange="updateStatus(${orderBean.getOrderId() },this);"
                                <c:if test="${Constant.ORDER_STATUS_CANCELLED == orderBean.getStatus()}">disabled</c:if>>
                        <option
                                <c:if test="${Constant.ORDER_STATUS_NEW == orderBean.getStatus()}"> selected</c:if>
                                value="${Constant.ORDER_STATUS_NEW}">${Constant.ORDER_STATUS_NEW}</option>
                        <option
                                <c:if test="${Constant.ORDER_STATUS_DISPATCHED == orderBean.getStatus()}"> selected</c:if>
                                value="${Constant.ORDER_STATUS_DISPATCHED}">${Constant.ORDER_STATUS_DISPATCHED}</option>
                        <option
                                <c:if test="${Constant.ORDER_STATUS_IN_TRANSIT == orderBean.getStatus()}"> selected</c:if>
                                value="${Constant.ORDER_STATUS_IN_TRANSIT}">${Constant.ORDER_STATUS_IN_TRANSIT}</option>
                        <option
                                <c:if test="${Constant.ORDER_STATUS_OUT_FOR_DELIVERY == orderBean.getStatus()}"> selected</c:if>
                                value="${Constant.ORDER_STATUS_OUT_FOR_DELIVERY}">${Constant.ORDER_STATUS_OUT_FOR_DELIVERY}</option>
                        <option
                                <c:if test="${Constant.ORDER_STATUS_DELIVERED == orderBean.getStatus()}"> selected</c:if>
                                value="${Constant.ORDER_STATUS_DELIVERED}">${Constant.ORDER_STATUS_DELIVERED}</option>
                        <option
                                <c:if test="${Constant.ORDER_STATUS_CANCELLED == orderBean.getStatus()}"> selected</c:if>
                                value="${Constant.ORDER_STATUS_CANCELLED}">${Constant.ORDER_STATUS_CANCELLED}</option>
                    </select></td>
                </tr>
            </c:forEach>
            </tbody>

        </table>

        <script>
            function load_ajax(orderId, status) {

                var xhttp;
                xhttp = new XMLHttpRequest();

                xhttp.open("POST", "UpdateOrderStatusAction?orderId="
                    + orderId + "&status=" + status, true);
                xhttp.send();


            }

            function myFunction() {
                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByClassName("tableBody");
                for (i = 0; i < tr.length; i++) {
                    td = tr[i];
                    if (td) {
                        txtValue = td.textContent || td.innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }

            function updateStatus(orderId, el) {

                var status = $('option:selected', $(el)).text();
                load_ajax(orderId, status);

            }
        </script>
    </div>
</div>
</body>
</html>