<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Rodo</title>
</head>
<body>


<jsp:useBean id="newsletter" class="pl.sstenzel.ug.javaee.florists.domain.Newsletter" scope="session" />
<jsp:useBean id="newslettery" class="pl.sstenzel.ug.javaee.florists.service.NewsletterService" scope="application" />
<jsp:setProperty name="newsletter" property="*" />
<%--taka sama nazwa jak obiektu, takie same nazwy atrybutow xd--%>

<%
    newslettery.add(newsletter);
%>

</body>
</html>