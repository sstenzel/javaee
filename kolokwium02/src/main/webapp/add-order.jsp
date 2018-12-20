<%@ page import="pl.sstenzel.ug.javaee.florists.domain.Drawer" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<jsp:useBean id="allOrders" class="pl.sstenzel.ug.javaee.florists.service.ShopService" scope="application"/>
<jsp:useBean id="userOrder" class="pl.sstenzel.ug.javaee.florists.domain.Drawer" scope="session"/>
<jsp:setProperty name="userOrder" property="brand"/>
<jsp:setProperty name="userOrder" property="price"/>

<%

    Date date = Drawer.stringToDate(request.getParameter("productionDate"));
    userOrder.setProductionDate(date);

    userOrder.setExtraGlass(new Boolean(request.getParameter("extraGlass")).booleanValue());

    System.out.println(allOrders.addOrder(userOrder));
    System.out.println(userOrder.getId());
    out.print(userOrder.printHTML());
%>

<p>
<a href="order.jsp"><button>Edit your order</button></a>
<a href="all-orders.jsp"><button>See all orders</button></a>
</p>
</body>
</html>