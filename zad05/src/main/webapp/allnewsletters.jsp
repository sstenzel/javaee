<%@ page import="pl.sstenzel.ug.javaee.florists.domain.Newsletter" %>

<%--dzieki temu wie co to newsletter dla newsletterService ze scope'u aplikacji--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Florists - all newsletters</title>
</head>
<body>

<jsp:useBean id="newslettery" class="pl.sstenzel.ug.javaee.florists.service.NewsletterService" scope="application" />


<p>

    <%

    for (Newsletter n : newslettery.getNewslettery().values()) {
        out.println("<p>" + n.toString());
        out.println("<form action='deletenewsletter.jsp'>");
        out.println("<input type='text' name='id' value='" + n.getId() + "' hidden />");
        out.println("<button type='submit'> Usuń </button> ");
        out.println("</form>");
        out.println("</p>");
    }

    %>

    <a href="newsletter.jsp"><button>Dodaj kolejny newsletter</button></a>
</p>


</body>
</html>