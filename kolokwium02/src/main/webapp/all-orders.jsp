<%@ page import="pl.sstenzel.ug.javaee.drawers.domain.Drawer" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add/edit order</title>
</head>
<body>
<jsp:useBean id="allOrders" class="pl.sstenzel.ug.javaee.drawers.service.ShopService" scope="application"/>

<ul>
<% for(Drawer order : allOrders.getOrders().values()){
        out.println("<li><p>");
        out.println("<form action='delete-order.jsp'>");
        out.println("<input type='text' name='id' value='" + order.getId() + "' hidden/>");
        out.print(order.printHTML());
        out.println("<button type='submit' style='danger'>Usun</button>");
        out.println("</form>");
        out.println("</p></li>");
    }
%>
    <a href="order.jsp"><button>Edit your order</button></a>

</ul>
</body>
</html>