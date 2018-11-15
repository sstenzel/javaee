<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Rodo</title>
</head>
<body>


<jsp:useBean id="consent" class="pl.sstenzel.ug.javaee.rodo.domain.Consent" scope="session" />
<jsp:setProperty name="consent" property="*" />
<%--taka sama nazwa jak obiektu, takie same nazwy atrybutow xd--%>

<%

    if (consent.getRodo()) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }else
        response.sendRedirect(request.getContextPath() + "/rodo.jsp");

%>

</body>
</html>