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

<jsp:useBean id="consent" class="pl.sstenzel.ug.javaee.florists.domain.Consent" scope="session" />

<p>

<form action="addRodo.jsp">
    <input type="checkbox" name="rodo"  />
    Wyrazam zgode na przetwarzanie danych osobowych<br />
    <input type="checkbox"  name="newsletter" />
    Wyrazam zgode na przesylanie newslettera<br />
    <input type="submit" value=" Przejdź do strony ->">
</form>

</p>


</body>
</html>