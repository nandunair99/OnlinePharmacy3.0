<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.narola.pharmacy.utility.Constant" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>
        .card-registration .select-input.form-control[readonly]:not([disabled]) {
            font-size: 1rem;
            line-height: 2.15;
            padding-left: .75em;
            padding-right: .75em;
        }

        .card-registration .select-arrow {
            top: 13px;
        }
    </style>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body style="background-color:#60A3BC">
<section class="h-100 bg-dark">
    <div
            class="row d-flex container py-5 h-100 justify-content-center align-items-center">

        <div class="col">
            <div class="card card-registration my-4">
                <div class="row g-0 d-flex">
                    <div class="col-md-6">
                        <img
                                src="${pageContext.request.contextPath }${Constant.RESOURCE_IMG_FOLDER}loginWallpaper.png"
                                alt="Sample photo" class="img-fluid"
                                style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem; height: 612px; width: 570px"/>
                    </div>
                    <div class="col-xl-6">
                        <div class="card-body p-md-5 text-black">
                            <form method="post" action="RegisterAction">
                                <div class="col-md-6">
                                    <h1 class="mb-5 text-uppercase">Registration Form</h1>
                                    &nbsp;
                                </div>


                                <div class="row">
                                    <div class="col-md-3">
                                        <div class="form-outline">
                                            <label class="form-label" for="fnametxt">First name</label>
                                            <input type="text" id="fnametxt" name="fnametxt"
                                                   value="${CustomerBean.getFirstName()}"
                                                   class="form-control form-control-lg" value=""/>

                                        </div>
                                    </div>
                                    <div class="col-md-3 mb-4">
                                        <div class="form-outline">
                                            <label class="form-label" for="lnametxt">Last name</label> <input
                                                type="text" id="lnametxt" name="lnametxt"
                                                value="${CustomerBean.getLastName()}"
                                                class="form-control form-control-lg"/>

                                        </div>
                                    </div>
                                    <div class="col-md-3 mb-4">
                                        <div class="form-outline">
                                            <label class="form-label" for="contactNotxt">Contact
                                                no.</label> <input type="text" id="contactNotxt"
                                                                   value="${CustomerBean.getContactNo()}"
                                                                   name="contactNotxt"
                                                                   class="form-control form-control-lg"/>

                                        </div>
                                    </div>
                                    <div class="col-md-3 mb-4">
                                        <c:if test="${not empty CustomerBean.getDob()}">
                                            <c:set var="dob" value="${CustomerBean.getDob()}" scope="page"/>
                                        </c:if>

                                        <div class="form-outline">
                                            <label class="form-label" for="dobtxt">DOB</label> <input
                                                type="date" id="dobtxt" name="dobtxt" value="${dob}"
                                                class="form-control form-control-lg"/>

                                        </div>
                                    </div>

                                    <!-- <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <label class="form-label" for="gendertxt">Gender</label> <select
                                                class="select form-control" id="gendertxt" name="gendertxt">

                                                <option value="male">Male</option>
                                                <option value="female">Female</option>
                                                <option value="others">Others</option>
                                            </select>

                                        </div>
                                    </div> -->
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <label class="form-label" for="addresstxt">Address</label>
                                            <textarea class="form-control form-control-lg"
                                                      id="addresstxt"
                                                      name="addresstxt">${CustomerBean.getAddress()} </textarea>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <label class="form-label" for="mailtxt">Email ID</label> <input
                                                type="text" id="mailtxt" name="mailtxt"
                                                class="form-control form-control-lg"
                                                value="${CustomerBean.getEmailId()}"/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <label class="form-label" for="passwordtxt">Password</label>
                                            <input type="text" id="passwordtxt" name="passwordtxt"
                                                   class="form-control form-control-lg"/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <label class="form-label" for="cpasswordtxt">Confirm
                                                Password</label> <input type="text" id="cpasswordtxt"
                                                                        name="cpasswordtxt"
                                                                        class="form-control form-control-lg"/>
                                        </div>
                                    </div>
                                    &nbsp;

                                    <div class="col-md-6 mb-4">
                                        <div class="d-flex justify-content-end pt-3">

                                            <input type="submit" class="btn btn-lg ms-2"
                                                   style="background-color:#F39C12"
                                                   value="Submit
												form">
                                        </div>
                                        <h4 style="color: red">
                                            <c:out value="${errMsg}"></c:out>
                                        </h4>
                                    </div>


                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>