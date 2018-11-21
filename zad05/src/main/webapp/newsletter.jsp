
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Florists - newsletter</title>
</head>
<body>

<jsp:useBean id="newsletter" class="pl.sstenzel.ug.javaee.florists.domain.Newsletter" scope="session" />
<jsp:useBean id="newslettery" class="pl.sstenzel.ug.javaee.florists.service.NewsletterService" scope="application" />


<%
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String dataOd = "";
    if(newsletter.getDataOd() != null)
        dataOd = format.format(newsletter.getDataOd());
    String dataDo = "";
    if(newsletter.getDataDo() != null)
        dataDo = format.format(newsletter.getDataDo());

%>

<form action="addNewsletter.jsp">
    <label>Imię:</label>

    <input type='text' name='imie' value='${newsletter.imie}' placeholder='Imie' required ><br>

    <label>Data od:</label>
    <%
    out.println ("<input type='text' name='dataOd' value='");
    if(!dataOd.equals(""))
        out.print(dataOd);
    else
        out.print("' placeholder = 'yyyy-MM-dd");
             out.print("' required ><br>");
    %>

    <label>Data do:</label>
   <%
       out.println ("<input type='text' name='dataDo' value='");
        if(!dataDo.equals(""))
            out.print(dataDo);
        else
            out.print("' placeholder = 'yyyy-MM-dd");
        out.print("' required ><br>");

    %>
    <p>Częstotliwość</p>
    <%
        for (String czestotliwosc : newslettery.getCzestotliwosci()) {
        out.println ("<input type='radio' name='czestotliwosc' value = "
                + czestotliwosc+" required ");
            if (newsletter.getCzestotliwosc()!= null)
                out.print(newsletter.getCzestotliwosc().equals(czestotliwosc) ? "checked" : " ");
        out.print("/> "+czestotliwosc );
        }
    %>
    <p>Tematyka</p>
    <%
        for (String tematyka : newslettery.getTematyka()) {
            out.println ("<input type='radio' name='tematyka' value = "
                    + tematyka+" required ");
            if (newsletter.getTematyka()!= null)
                out.print(newsletter.getTematyka().equals(tematyka) ? "checked" : " ");
            out.println ("/> "+tematyka );
        }
    %>
    <br>
    <input type="submit" value=" Zapisz newsletter">
</form>



</body>
</html>