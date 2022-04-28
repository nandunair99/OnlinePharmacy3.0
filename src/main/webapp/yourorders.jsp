<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.narola.pharmacy.utility.Constant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<style>
body {
	
}

.container-fluid {
	z-index: 3500;
	margin-top: 200px;
	background-color: rgb(0, 0, 0);
	background-color: rgb(0, 0, 0, 0.2);
	position: absolute;
	height: 100%;
}

.scrollingArea {
	overflow-y: auto;
	overflow-x: hidden;
}

p {
	font-size: 14px;
	margin-bottom: 7px
}

.small {
	letter-spacing: 0.5px !important
}

.card-1 {
	box-shadow: 2px 2px 10px 0px rgb(190, 108, 170);
	margin-top: 50px;
	height: 550px;
	width: 700px;
	border-radius: 10px;
}

hr {
	background-color: rgba(248, 248, 248, 0.667)
}

.bold {
	font-weight: 500
}

.change-color {
	color: #AB47BC !important
}

.card-2 {
	box-shadow: 1px 1px 3px 0px rgb(112, 115, 139)
}

.fa-circle.active {
	font-size: 8px;
	color: #AB47BC
}

.fa-circle {
	font-size: 8px;
	color: #aaa
}

.rounded {
	border-radius: 2.25rem !important
}

.progress-bar {
	background-color: #AB47BC !important
}

.progress {
	height: 5px !important;
	margin-bottom: 0
}

.invoice {
	position: relative;
	top: -70px
}

.Glasses {
	position: relative;
	top: -12px !important
}

.card-footer {
	background-color: #AB47BC;
	color: #fff
}

h2 {
	color: rgb(78, 0, 92);
	letter-spacing: 2px !important
}

.display-3 {
	font-weight: 500 !important
}

@media ( max-width : 479px) {
	.invoice {
		position: relative;
		top: 7px
	}
	.border-line {
		border-right: 0px solid rgb(226, 206, 226) !important
	}
}

@media ( max-width : 700px) {
	h2 {
		color: rgb(78, 0, 92);
		font-size: 17px
	}
	.display-3 {
		font-size: 28px;
		font-weight: 500 !important
	}
}

.card-footer small {
	letter-spacing: 7px !important;
	font-size: 12px
}

.border-line {
	border-right: 1px solid rgb(226, 206, 226)
}
</style>
</head>
<body>

	<div class="container-fluid my-5 d-flex justify-content-center">
		<div class="yourOrdersWrapper">

			<div class="card card-1">

				<div class="card-header bg-white">
					<div
						class="media flex-sm-row flex-column-reverse justify-content-between ">

						<div class="col my-auto">
							<h1 class="mb-0">
								Your Orders, <span class="change-color">${customerDetails.getFirstName()}</span>
								!
							</h1>
						</div>
						<div class="col-auto text-center my-auto pl-0 pt-sm-4">
							<img class="img-fluid my-auto align-items-center mb-0 pt-3"
								src="${pageContext.request.contextPath }${Constant.RESOURCE_IMG_FOLDER}box.png"
								width="115" height="115">

						</div>
						<a href="${referrer}">

							<button
								style="float: right; background-color: red; color: black; height: 20px; width: 20px">&times;</button>
						</a>
					</div>
				</div>
				<div class="scrollingArea">
					<c:forEach var="PastOrder" items="${PastOrders}">

						<div class="card-body">
							<div class="row justify-content-between mb-3">
								<div class="col-auto">
									<h6 class="color-1 mb-0 change-color">Receipt</h6>
								</div>
								<div class="col-auto ">
									<small>Order ID : ${PastOrder.getOrderId()}</small>
								</div>
							</div>
							<div class="row">
								<c:if
									test="${not empty PastOrder.getCartWrapper().getMedicineBeans()}"></c:if>
								<c:forEach var="MedicineBean"
									items="${PastOrder.getCartWrapper().getMedicineBeans()}">
									<div class="col">
										<div class="card card-2">
											<div class="card-body">
												<div class="media">
													<div class="sq align-self-center ">
														<img
															class="img-fluid my-auto align-self-center mr-2 mr-md-4 pl-0 p-0 m-0"
															src="${MedicineBean.getMedicineBean().getImagesPath().get(0)}"
															height="135" />
													</div>
													<div class="media-body my-auto text-right">
														<div class="row my-auto flex-column flex-md-row">
															<div class="col my-auto">
																<h6 class="mb-0">${MedicineBean.getMedicineBean().getMedName()}</h6>
															</div>
															<div class="col-auto my-auto">
																<small>Medicine </small>
															</div>
															<div class="col my-auto">
																<small>Manufacturer :
																	${MedicineBean.getMedicineBean().getMedManufacturer()}</small>
															</div>
															<div class="col my-auto">
																<small>Qty : ${MedicineBean.getQuantity()}</small>
															</div>
															<div class="col my-auto">
																<h6 class="mb-0">&#8377;${MedicineBean.getMedicineBean().getMedPrice()}</h6>
															</div>
														</div>
													</div>
												</div>
												<hr class="my-3 ">

											</div>
										</div>
									</div>
								</c:forEach>
								<c:if
									test="${not empty PastOrder.getCartWrapper().getTestBeans()}">

									<c:forEach var="TestBean"
										items="${PastOrder.getCartWrapper().getTestBeans()}">

										<c:if test="${not empty TestBean.getTestBean()}">
											<div class="col">
												<div class="card card-2">
													<div class="card-body">
														<div class="media">
															<div class="sq align-self-center ">
																<img
																	class="img-fluid my-auto align-self-center mr-2 mr-md-4 pl-0 p-0 m-0"
																	src="data:image/png;base64,${TestBean.getTestBean().getBase64String()}"
																	width="135" height="135" />
															</div>
															<div class="media-body my-auto text-right">
																<div class="row my-auto flex-column flex-md-row">
																	<div class="col my-auto">
																		<h6 class="mb-0">${TestBean.getTestBean().getTestName()}</h6>
																	</div>
																	<div class="col-auto my-auto">
																		<small>Test</small>
																	</div>
																	<div class="col my-auto">
																		<small>Pharmeasy</small>
																	</div>
																	<div class="col my-auto">
																		<small>Qty : ${TestBean.getQuantity()}</small>
																	</div>
																	<div class="col my-auto">
																		<h6 class="mb-0">&#8377;${TestBean.getTestBean().getTestPrice()}</h6>
																	</div>
																</div>
															</div>
														</div>
														<hr class="my-3 ">

													</div>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</c:if>

							</div>

							<div class="row mt-4">
								<div class="col">
									<div class="row justify-content-between">
										<div class="col-auto">
											<p class="mb-1 text-dark">
												<b>Order Details</b>
											</p>
										</div>
										<div class="flex-sm-col text-right col">
											<p class="mb-1">
												<b>Total</b>
											</p>
										</div>
										<div class="flex-sm-col col-auto">
											<p class="mb-1">&#8377;${PastOrder.getCartWrapper().getTotalAmountWithoutDiscount()}</p>
										</div>
									</div>
									<div class="row justify-content-between">
										<div class="flex-sm-col text-right col">
											<p class="mb-1">
												<b>Discount</b>
											</p>
										</div>
										<div class="flex-sm-col col-auto">
											<p class="mb-1">&#8377;${PastOrder.getCartWrapper().getTotalAmountWithoutDiscount()-PastOrder.getCartWrapper().getTotalAmount()}</p>
										</div>
									</div>

									<div class="row justify-content-between">
										<div class="flex-sm-col text-right col">
											<p class="mb-1">
												<b>Delivery Charges</b>
											</p>
										</div>
										<div class="flex-sm-col col-auto">
											<p class="mb-1">Free</p>
										</div>
									</div>
								</div>
							</div>
							<div class="row invoice ">
								<div class="col">
									<br>

									<p class="mb-1">Invoice Date : ${PastOrder.getDate()}</p>
									<p class="mb-1">Receipts Voucher:18KU-62IIK</p>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3 mb-3">
									<small> Track Order <span><i
											class=" ml-2 fa fa-refresh" aria-hidden="true"></i></span></small>
								</div>
								<div class="col mt-auto">
									<div class="progress my-auto">
										<c:choose>

											<c:when
												test="${PastOrder.getStatus()==Constant.ORDER_STATUS_NEW}">
            <c:set var="progress" scope="page" value="0%" />
         </c:when>

											<c:when
												test="${PastOrder.getStatus()==Constant.ORDER_STATUS_DISPATCHED}">
           <c:set var="progress" scope="page" value="25%" />
         </c:when>
											<c:when
												test="${PastOrder.getStatus()==Constant.ORDER_STATUS_IN_TRANSIT}">
           <c:set var="progress" scope="page" value="50%" />
         </c:when>

											<c:when
												test="${PastOrder.getStatus()==Constant.ORDER_STATUS_OUT_FOR_DELIVERY}">
            <c:set var="progress" scope="page" value="75%" />
         </c:when>
         <c:when
												test="${PastOrder.getStatus()==Constant.ORDER_STATUS_DELIVERED}">
           <c:set var="progress" scope="page" value="100%" />
         </c:when>

											<c:otherwise>
            No comment sir...
         </c:otherwise>
										</c:choose>
										<c:if
											test="${PastOrder.getStatus()==Constant.ORDER_STATUS_NEW}">
											<c:set var="progress" scope="page" value="0%" />
										</c:if>
										<div class="progress-bar progress-bar rounded"
											style="width: ${progress}" role="progressbar" aria-valuenow="25"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<div class="media row justify-content-between ">
										
										<div class="flex-col">
											<span> <small class="text-right mr-sm-2">Dispatched</small><i class="fa fa-circle active"></i></span>
										</div>
										<div class="col-auto flex-col-auto">
											<small class="text-right mr-sm-2">In-Transit</small><span>
												<i class="fa fa-circle"></i>
											</span>
										</div>
										<div class="flex-col">
											<span> <small class="text-right mr-sm-2">Out
													for delivery</small><i class="fa fa-circle active"></i></span>
										</div>
										<div class="col-auto flex-col-auto">
											<small class="text-right mr-sm-2">Delivered</small><span>
												<i class="fa fa-circle"></i>
											</span>
										</div>
										
									</div>
								</div>
							</div>
						</div>
						<div class="card-footer">
							<div class="jumbotron-fluid">
								<div class="row justify-content-between ">
									<div class="col-sm-auto col-auto my-auto">
										<img class="img-fluid my-auto align-self-center "
											src="${pageContext.request.contextPath }${Constant.RESOURCE_IMG_FOLDER}box.png"
											width="115" height="115">
									</div>
									<div class="col-auto my-auto ">
										<h2 class="mb-0 font-weight-bold">TOTAL PAID</h2>
									</div>
									<div class="col-auto my-auto ml-auto">
										<h1 class="display-3 ">&#8377;
											${PastOrder.getCartWrapper().getTotalAmount()}</h1>
									</div>
								</div>


							</div>
						</div>

					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>