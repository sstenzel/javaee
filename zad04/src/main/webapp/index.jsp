<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rodo</title>
    </head>
    <body>
    <jsp:useBean id="consent" class="pl.sstenzel.ug.javaee.rodo.domain.Consent" scope="session" />


    <%
        if (!consent.getRodo())
            response.sendRedirect(request.getContextPath() + "/rodo.jsp");
    %>

        <h2>Witaj na stronie</h2>

    </body>
</html>
