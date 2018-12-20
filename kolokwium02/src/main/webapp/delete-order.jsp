<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<jsp:useBean id="allOrders" class="pl.sstenzel.ug.javaee.drawers.service.ShopService" scope="application"/>
<jsp:useBean id="userOrder" class="pl.sstenzel.ug.javaee.drawers.domain.Drawer" scope="session"/>

<%

    if (allOrders.removeOrder(Long.parseLong(request.getParameter("id"))))
        userOrder.clear();

    response.sendRedirect(request.getContextPath() + "/all-orders.jsp");
%>


</body>
</html>