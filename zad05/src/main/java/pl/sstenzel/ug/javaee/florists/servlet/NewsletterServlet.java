package pl.sstenzel.ug.javaee.florists.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newsletter")
public class NewsletterServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/newsletter.jsp");
    }
}

//@WebServlet("/allnewsletters")
//public class NewslettersServlet extends HttpServlet{
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        response.sendRedirect(request.getContextPath() + "/allnewsletters.jsp");
//    }
//}