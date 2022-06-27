<%@ page import="com.narola.pharmacy.category.CategoryDAO" %>
<%@ page import="com.narola.pharmacy.utility.Constant" %>
<%@ page import="com.narola.pharmacy.category.CategoryBean" %>
<%@ page import="com.narola.pharmacy.medicine.model.MedicineBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Medicine</title>
    <script>
        var data = 0;

        //printing default value of data that is 0 in h2 tag
        document.getElementById("quantitytxt").innerText = data;


    </script>

    <script
            src="https://cdn.ckeditor.com/ckeditor5/12.4.0/classic/ckeditor.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/commonLayout.css">
</head>
<body>
<c:import var="sidebar" url="sidebar.jsp"/>
${sidebar}
<div class="mainArea">
    <div class="headingArea">
        <h1>Add Medicine</h1>
    </div>
    <jsp:useBean id="categorydao"
                 class="com.narola.pharmacy.category.CategoryDAO" scope="page"/>

    <c:if test="${not empty MedicineBean}">
        <c:set var="mbean" value="${MedicineBean}"/>
    </c:if>


    <div class="superDiv">
        <form method="post"
              action="${pageContext.request.contextPath}/medicine${Constant.URL_MEDICINE_ADD_ACTION}"
              enctype="multipart/form-data">
            <table>
                <tr>
                    <td>
                        <div class="form-group">
                            <label for="categoryName">Category Name:</label> <select
                                name="catId" id="categoryName" class="form-control">
                            <c:forEach var="categoryBean"
                                       items="${categorydao.showAllCategory()}">
                                <c:if test="${not empty mbean}">
                                    <c:if test="${mbean.getCatId()==categoryBean.getCatId()}">
                                        <c:set var="isselected" value="selected"/>
                                    </c:if>
                                    <c:if test="${mbean.getCatId()!=categoryBean.getCatId()}">
                                        <c:set var="isselected" value=""/>
                                    </c:if>
                                </c:if>
                                <option value="${categoryBean.getCatId()}" ${isselected}>${categoryBean.getCatName()}</option>

                            </c:forEach>

                        </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="form-group">
                            <label for="medNametxt">Medicine Name:</label> <input
                                type="text" class="form-control" name="medName"
                                id="medNametxt" placeholder="Enter medicine name..."
                                value="${mbean.getMedName()}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="form-group">
                            <label for="medPricetxt">Price:</label>
                            <c:if test="${mbean.getMedPrice()==-1.0}">
                                <c:set var="price" value=""/>
                            </c:if>
                            <c:if test="${mbean.getMedPrice()!=-1.0}">
                                <c:set var="price" value="${mbean.getMedPrice()}"/>
                            </c:if>
                            <input type="text" class="form-control" name="medPrice"
                                   id="medPricetxt" placeholder="Enter medicine price..."
                                   value="${price}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="form-group">
                            <label for="medDiscounttxt">Discount:</label>
                            <c:if test="${mbean.getMedDiscount()==-1.0}">
                                <c:set var="discount" value=""/>
                            </c:if>
                            <c:if test="${mbean.getMedDiscount()!=-1.0}">
                                <c:set var="discount" value="${mbean.getMedDiscount()}"/>
                            </c:if>
                            <input type="text" class="form-control" name="medDiscount"
                                   id="medDiscounttxt" placeholder="Enter medicine discount..."
                                   value="${discount}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="form-group">
                            <label for="medManufacturertxt">Manufacturer:</label> <input
                                type="text" class="form-control" name="medManufacturer"
                                id="medManufacturertxt"
                                placeholder="Enter manufacturer name..."
                                value="${mbean.getMedManufacturer()}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="form-group">
                            <label for="medDescriptiontxt">Medicine Description:</label>
                            <textarea name="medDescription"
                                      id="medDescriptiontxt">${mbean.getMedDescription()}</textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="form-group">
                            <label for="medMfgDatetxt">Mfg date:</label>
                            <c:set var="mfg" value="${mbean.getMedMfgDate()}"/>
                            <c:set var="exp" value="${mbean.getMedExpDate()}"/>

                            <input type="date" name="medMfgDatetxt" id="medMfgDatetxt"
                                   value="${mfg}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="form-group">
                            <label for="medExpDate">Exp date:</label> <input type="date"
                                                                             name="medExpDatetxt" id="medExpDate"
                                                                             value="${exp}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="form-group">
                            <label for="picturetxt">Upload Medicine Image:</label> <input
                                type="file" class="form-control" name="imagePart"
                                id="picturetxt" multiple>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div class="form-group">
                            <label for="quantitytxt">Quantity:</label>
                            <c:if test="${not empty mbean}">
                                <c:set var="qty" value="${mbean.getQuantity()}"/>
                            </c:if>
                            <c:if test="${empty mbean}">
                                <c:set var="qty" value="1"/>
                            </c:if>
                            <input type="number" name="quantity" id="quantitytxt" min="1"
                                   value="${qty}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan=2><c:if test="${not empty errMsg}">
                        <h4 style="color: red">${errMsg}</h4>
                    </c:if></td>
                </tr>
                <tr>
                    <td colspan=2><input type="submit" value="Add Medicine">
                    </td>
                </tr>
            </table>
        </form>
        <p>
            <a href="ShowAllMedicine">Go back</a>
        </p>
    </div>

</div>
<script>
    ClassicEditor
        .create(document.querySelector('#medDescriptiontxt'))
        .catch(error => {
            console.error(error);
        });
</script>
</body>

</html>