package pl.sstenzel.ug.javaee.kolokwium.servlet;

import pl.sstenzel.ug.javaee.kolokwium.service.BasketService;
import pl.sstenzel.ug.javaee.kolokwium.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if("DELETE".equals(request.getParameter("method"))) {
            doDelete(request, response);
            return;
        }

        HttpSession session = request.getSession();
        BasketService basket;

        if (session.getAttribute("basket")==null) {
            basket = new BasketService();
        } else {
            basket = (BasketService) session.getAttribute("basket");
        }

        if (request.getParameter("id") != null) {
            basket.add((long) Long.parseLong(request.getParameter("id")));
            session.setAttribute("basket", basket);
        }

        response.sendRedirect(request.getContextPath() + "/shop");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        BasketService basket = (BasketService) session.getAttribute("basket");
        StorageService storage = (StorageService) getServletContext().getAttribute("shop_storage");

        out.println("<html><body>");


        out.println("<h1>Flowers in your basket:</h1>");

        if(basket!=null) {
            for(Map.Entry<Long,Long> e: basket.getItems()) {
                out.println("<form action='basket' method='post'>");
                out.println("<p>" + storage.get(e.getKey())+ "    |  IN BASKET: "+e.getValue()+"</p>");
                out.println("<input type='text' name='id' value='"+e.getKey()+"' hidden>");
                out.println("<input type='text' name='method' value='DELETE' hidden>");
                out.println("<input type=\"submit\" value=\"Delete flower\">");
                out.println("</form>");
            }
        }

        if (basket != null && !basket.getItems().isEmpty()) {
            out.println("<form action='shop' method='post'>");
            out.println("<input type='text' name='method' value='DELETE' hidden>");
            out.println("<input type=\"submit\" value=\"-- Buy --\">");
            out.println("</form>");
        }
            out.println("<a href='/florists/shop'><button>Go to the shop -></button></a>");
            out.println("</body></html>");

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        BasketService basket = (BasketService) session.getAttribute("basket");

        if(request.getParameter("id")!=null && session.getAttribute("basket")!=null){
            basket.remove(Long.parseLong(request.getParameter("id")));
        }

        response.sendRedirect(request.getContextPath()+"/basket");
    }
}
