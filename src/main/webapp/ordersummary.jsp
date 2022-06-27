<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.narola.pharmacy.utility.Constant" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
    <style>
        .card-Item {
            height: 340px;
            overflow-y: auto;
            overflow-x: hidden;
        }

        .card-Item > hr:last-child {
            display: none;
        }

        .cartDiv {
            max-width: 1000px;
        }

        @media ( min-width: 1025px) {
            .h-custom {
                height: 100%;
                position: fixed;
                z-index: 2000;
                top: 0;
                left: 0;
                width: 100%;
                overflow: auto;
                background-color: rgb(0, 0, 0);
                background-color: rgb(0, 0, 0, 0.2)
            }
        }

        .card-registration .select-input.form-control[readonly]:not([disabled]) {
            font-size: 1rem;
            line-height: 2.15;
            padding-left: .75em;
            padding-right: .75em;
        }

        .card-registration .select-arrow {
            top: 13px;
        }

        .bg-grey {
            height: 550px;
            background-color: #eae8e8;
        }

        @media ( min-width: 992px) {
            .card-registration-2 .bg-grey {
                border-top-right-radius: 16px;
                border-bottom-right-radius: 16px;
            }
        }

        @media ( max-width: 991px) {
            .card-registration-2 .bg-grey {
                border-bottom-left-radius: 16px;
                border-bottom-right-radius: 16px;
            }
        }
    </style>
</head>
<body>
<div style="align: center">
    <section class="h-100 h-custom">
        <div class="container py-5 h-100 cartDiv">
            <div
                    class="row d-flex justify-content-center align-items-center h-100">

                <div
                        class="col-12 row g-0 card card-registration card-registration-2 card-body p-0"
                        style="border-radius: 15px;">
                    <form method="post" action="PlaceOrderAction">

                        <div class="col-lg-8">
                            <div class="p-5">

                                <div
                                        class="d-flex justify-content-between align-items-center mb-5">
                                    <h1 class="fw-bold mb-0 text-black">Shopping Cart</h1>

                                    <h6 class="mb-0 text-muted">${CartWrapper.getTotalItems()}
                                        items</h6>
                                </div>
                                <hr class="my-4">
                                <div class="card-Item">

                                    <c:if test="${not empty CartWrapper.getMedicineBeans()}">
                                        <h3 class="cartHeading" align="center">Medicines</h3>
                                        <c:forEach var="MedicineBean"
                                                   items="${CartWrapper.getMedicineBeans()}">


                                            <div
                                                    class="row mb-4 d-flex justify-content-between align-items-center">
                                                <div class="col-md-2 col-lg-2 col-xl-2">
                                                    <input type="text" name="cartIdtxt"
                                                           value="${MedicineBean.getCartId()}" hidden="true">
                                                    <img style="height: 100px; width: 100px"
                                                         src="${MedicineBean.getMedicineBean().getImagesPath().get(0)}"
                                                         class="img-fluid rounded-3" alt="Cotton T-shirt">
                                                </div>
                                                <div class="col-md-2 col-lg-2 col-xl-2">
                                                    <h6 class="text-muted">Medicine</h6>
                                                    <h6 class="text-black mb-0">${MedicineBean.getMedicineBean().getMedName()}</h6>
                                                </div>
                                                <div class="col-md-2 col-lg-2 col-xl-2 d-flex">
                                                    <button class="btn btn-link px-2" type="button"
                                                            onclick="decrement(${MedicineBean.getCartId()},this)">
                                                        &#8722;
                                                    </button>

                                                    <input min="1" name="quantity"
                                                           onchange="manageQty(${MedicineBean.getCartId()},this);"
                                                           value="${MedicineBean.getQuantity()}" type="number"
                                                           class="form-control form-control-sm "/>

                                                    <button class="btn btn-link px-2" type="button"
                                                            onclick="increment(${MedicineBean.getCartId()},this)">
                                                        &#43;
                                                    </button>
                                                </div>
                                                <div class="col-md-2 col-lg-2 col-xl-2 offset-lg-1">
                                                    <h6 class="mb-0">${MedicineBean.getMedicineBean().getMedDiscountedPrice()}&#8377;</h6>
                                                </div>
                                                <div class="col-md-1 col-lg-1 col-xl-1 offset-lg-1">
                                                    <input type="button"
                                                           onclick="delete_item(${MedicineBean.getCartId()})"
                                                           value="&#10007"
                                                           style="background-color: white; border: none">
                                                </div>
                                                <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                    <a href="#!" class="text-muted"><i
                                                            class="fas fa-times"></i></a>
                                                </div>
                                            </div>
                                            <hr class="my-4">
                                        </c:forEach>
                                    </c:if>


                                    <c:if test="${not empty CartWrapper.getTestBeans()}">
                                        <h3 class="cartHeading" align="center">Tests</h3>
                                        <c:forEach var="TestBean"
                                                   items="${CartWrapper.getTestBeans()}">

                                            <c:if test="${not empty TestBean.getTestBean()}">

                                                <div
                                                        class="row mb-4 d-flex justify-content-between align-items-center">
                                                    <div class="col-md-2 col-lg-2 col-xl-2">
                                                        <input type="text" name="cartIdtxt"
                                                               value="${TestBean.getCartId()}" hidden="true">
                                                        <img style="height: 100px; width: 100px"
                                                             src="data:image/png;base64,${TestBean.getTestBean().getBase64String()}"
                                                             class="img-fluid rounded-3" alt="Cotton T-shirt">
                                                    </div>
                                                    <div class="col-md-2 col-lg-2 col-xl-2">
                                                        <h6 class="text-muted">Test</h6>
                                                        <h6 class="text-black mb-0">${TestBean.getTestBean().getTestName()}</h6>
                                                    </div>
                                                    <div class="col-md-2 col-lg-2 col-xl-2 d-flex">
                                                        <button class="btn btn-link px-2" type="button"
                                                                onclick="decrement(${TestBean.getCartId()},this)">
                                                            &#8722;
                                                        </button>

                                                        <input min="1" name="quantity"
                                                               onchange="manageQty(${TestBean.getCartId()},this);"
                                                               value="${TestBean.getQuantity()}" type="number"
                                                               class="form-control form-control-sm"/>

                                                        <button class="btn btn-link px-2" type="button"
                                                                onclick="increment(${TestBean.getCartId()},this)">
                                                            &#43;
                                                        </button>
                                                    </div>
                                                    <div class="col-md-2 col-lg-2 col-xl-2 offset-lg-1">
                                                        <h6 class="mb-0">${TestBean.getTestBean().getTestDiscountedPrice()}&#8377;</h6>
                                                    </div>
                                                    <div class="col-md-1 col-lg-1 col-xl-1 offset-lg-1">
                                                        <input type="button" value="&#10007"
                                                               onclick="delete_item(${TestBean.getCartId()})"
                                                               style="background-color: white; border: none">
                                                    </div>
                                                    <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                        <a href="#!" class="text-muted"><i
                                                                class="fas fa-times"></i></a>
                                                    </div>
                                                </div>
                                                <hr class="my-4">
                                            </c:if>


                                        </c:forEach>
                                    </c:if>

                                    <c:if
                                            test="${empty CartWrapper.getTestBeans() and empty CartWrapper.getMedicineBeans()}">
                                        <h4 style="color: red">
                                            <c:out value="${cartMessage}"/>
                                        </h4>
                                    </c:if>
                                </div>
                                <hr class="my-4">
                                <div class="pt-5">

                                    <h6 class="mb-0" id="hidecart">
                                        <a href="${referrer}"><i
                                                class="fas fa-long-arrow-alt-left me-2"></i>&#8636;Back to
                                            shopping </a>
                                    </h6>

                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 bg-grey">
                            <div class="p-5">
                                <h3 class="fw-bold mb-5 mt-2 pt-1">Order Details</h3>
                                <hr class="my-4">

                                <div class="d-flex justify-content-between mb-4">
                                    <h5 class="text-uppercase">Delivery Address</h5>
                                </div>

                                <h5 class="text-uppercase mb-3">${customerDetails.getAddress()}</h5>

                                <div class="mb-4 pb-2">
                                    <select class="select">
                                        <option value="1">Standard-Delivery- &#8377;5.00</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                        <option value="4">Four</option>
                                    </select>
                                </div>

                                <!-- <h5 class="text-uppercase mb-3">Give code</h5>

                                            <div class="mb-5">
                                                <div class="form-outline">
                                                    <input type="text" id="form3Examplea2"
                                                        class="form-control form-control-lg" /> <label
                                                        class="form-label" for="form3Examplea2">Enter
                                                        your code</label>
                                                </div>
                                            </div> -->

                                <hr class="my-4">

                                <div class="d-flex justify-content-between mb-5">
                                    <h5 class="text-uppercase">Total price</h5>
                                    <h5>&#8377;${CartWrapper.getTotalAmount()}</h5>
                                </div>

                                <input type="text" value="${CartWrapper.getTotalAmount()}"
                                       name="totalAmounttxt" hidden="true"> <input
                                    type="submit" class="btn btn-dark btn-block btn-lg"
                                    value="Pay Now" data-mdb-ripple-color="dark">
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>

    </section>
</div>
<script>
    function delete_item(cartId) {
        var xhttp;
        xhttp = new XMLHttpRequest();

        xhttp.open("POST", "DeleteCartItemAction?cartId=" + cartId, true);
        xhttp.send();
        location.reload();

    }

    function update_quantity(cartId, quantity) {
        var xhttp;
        xhttp = new XMLHttpRequest();

        xhttp.open("POST", "UpdateCartQuantityAction?cartId=" + cartId + "&quantity=" + quantity, true);
        xhttp.send();
        location.reload();

    }

    function increment(cartId, el) {

        $(el).siblings("input").val(parseInt($(el).siblings("input").val()) + 1);
        update_quantity(cartId, parseInt($(el).siblings("input").val()));


    }

    function decrement(cartId, el) {
        if (parseInt($(el).siblings("input").val()) > 1) {
            $(el).siblings("input").val(parseInt($(el).siblings("input").val()) - 1);
            update_quantity(cartId, parseInt($(el).siblings("input").val()));

        }

    }

    function manageQty(cartId, el) {
        if (parseInt($(el).val()) >= 1) {
            update_quantity(cartId, parseInt($(el).val()));
        } else
            location.reload();

    }

    function place_order() {
        var xhttp;
        xhttp = new XMLHttpRequest();

        xhttp.open("POST", "PlaceOrderAction", true);
        xhttp.send();
        location.reload();

    }
</script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>