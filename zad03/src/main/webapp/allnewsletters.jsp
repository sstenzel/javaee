<%--<%@page import="pl.sstenzel.ug.javaee.rodo.domain.Consent"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Rodo</title>
</head>
<body>

<jsp:useBean id="newsletter" class="pl.sstenzel.ug.javaee.florists.domain.Newsletter" scope="session" />
<jsp:useBean id="newslettery" class="pl.sstenzel.ug.javaee.florists.service.NewsletterService" scope="application" />
<jsp:setProperty name="newslettery" property="*" />


<p>


    for (Newsletter n : newslettery.getAll()) {
    out.println("<p>"+n.toString() +"</p>");
}

</p>


</body>
</html>