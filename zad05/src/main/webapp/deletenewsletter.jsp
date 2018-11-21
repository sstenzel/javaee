<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<jsp:useBean id="newslettery" class="pl.sstenzel.ug.javaee.florists.service.NewsletterService" scope="application" />

<%
    newslettery.delete(request.getParameter("id"));
    response.sendRedirect(request.getContextPath() + "/allnewsletters.jsp");
%>

</body>
</html>