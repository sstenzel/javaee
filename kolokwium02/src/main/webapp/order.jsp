<%@ page import="pl.sstenzel.ug.javaee.florists.domain.Drawer" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add/edit order</title>
</head>
<body>
<jsp:useBean id="allOrders" class="pl.sstenzel.ug.javaee.florists.service.ShopService" scope="application"/>
<jsp:useBean id="userOrder" class="pl.sstenzel.ug.javaee.florists.domain.Drawer" scope="session"/>

<form action="add-order.jsp" method="POST">

    <p>
        <label>Brand</label>
        <select name="brand" required>
            <%
                for(String brand: allOrders.getBrand()) {
                    out.print("<option value='" + brand + "'");
                    if (userOrder.getBrand() != null && userOrder.getBrand().equals(brand))
                        out.print(" selected ");
                    out.print(">" + brand + "</option>");
                }
            %>
        </select>

    </p>
    <p>

        <label>Extra glass</label>
        <input type='radio' name="extraGlass" value="true"
               <%
                    if (userOrder.isExtraGlass())
                        out.print(" checked ");
                %>
        required> Yes
        <input type='radio' name="extraGlass" value="false"
                 <%
                    if (!userOrder.isExtraGlass())
                        out.print(" checked ");
                %>
        > No

    </p>
    <p>

        <label>Production date</label>
        <input type='text' name='expirationDate'
                <%
                    if(userOrder.getProductionDate() != null)
                        out.print(" value='"+Drawer.dateToString(userOrder.getProductionDate())+"' ");
                %>
               placeholder="dd.mm.yyyy" required/>

    </p>
    <p>

        <label>Proposed price</label>
        <input type='text' name='packets'
                <%
                    if(userOrder != null && userOrder.getPrice() > 0)
                        out.print("value='"+userOrder.getPrice()+"' ");
                %>
               placeholder="Price" required/>

    </p>
    <p>
        <button type="submit">Save!</button>
    </p>
</form>


</body>
</html>