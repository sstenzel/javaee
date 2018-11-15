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

<form action="addNewsletter.jsp">
    <input type='text' name='imie' placeholder='imie' >
    <input type='text' name='data' placeholder='yyyy-MM-dd' >
    <input type="radio" name="czestotliwosc" value = ${newslettery.czestotliwosci.get(0)} /> Codziennie
    <input type="radio" name="czestotliwosc" value = ${newslettery.czestotliwosci.get(1)} />Tygodniowo
    <input type="radio" name="czestotliwosc" value = ${newslettery.czestotliwosci.get(2)} /> Miesiecznie
    <input type="radio" name="tematyka" value = ${newslettery.tematyka.get(0)} />Kwiaciarnia
    <input type="radio" name="tematyka" value = ${newslettery.tematyka.get(1)} Leśnictwo/>
    <input type="radio" name="tematyka" value = ${newslettery.tematyka.get(2)} />Ogrodnictwo

    <input type="submit" value=" Dodaj newsletter">
</form>

</p>


</body>
</html>