<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>


<jsp:useBean id="newsletter" class="pl.sstenzel.ug.javaee.florists.domain.Newsletter" scope="session" />
<jsp:useBean id="newslettery" class="pl.sstenzel.ug.javaee.florists.service.NewsletterService" scope="application" />
<jsp:setProperty name="newsletter" property="imie"  />
<jsp:setProperty name="newsletter" property="tematyka" />
<jsp:setProperty name="newsletter" property="czestotliwosc" />
<%--przypisuje wartosci z requesta--%>

<%
    try {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        newsletter.setDataOd(format.parse(request.getParameter("dataOd")));
        newsletter.setDataDo(format.parse(request.getParameter("dataDo")));
    }catch (ParseException e) {
        response.sendRedirect(request.getContextPath() + "/newsletter.jsp");
    }

    newsletter.setId((long) newslettery.add(newsletter));
    out.println("Dodano/edytowano newsletter: ");
    out.println(newsletter);

%>
<a href="newsletter.jsp"><button>Dodaj kolejny newsletter</button></a>
<a href="allnewsletters.jsp"><button>Zobacz wszystkie</button></a>
</body>
</html>