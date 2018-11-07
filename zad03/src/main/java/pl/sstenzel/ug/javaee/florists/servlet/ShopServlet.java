package pl.sstenzel.ug.javaee.florists.servlet;

import pl.sstenzel.ug.javaee.florists.domain.Flower;
import pl.sstenzel.ug.javaee.florists.service.BasketService;
import pl.sstenzel.ug.javaee.florists.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if("DELETE".equals(request.getParameter("method"))) {
            doDelete(request, response);
            return;
        }

        StorageService storage = (StorageService) getServletContext().getAttribute("shop_storage");

        storage.add(
                request.getParameter("name"),
                request.getParameter("pickDate"),
                request.getParameter("dogToxic"),
                request.getParameter("price"),
                request.getParameter("amount")
        );

        response.sendRedirect(request.getContextPath() + "/shop");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StorageService storage = (StorageService)getServletContext().getAttribute("shop_storage");

        HttpSession session = request.getSession();
        BasketService basket;
        if (session.getAttribute("basket")==null) {
            basket = new BasketService();
        } else {
            basket = (BasketService) session.getAttribute("basket");
        }

        String disabled = "";

        out.println("<html><body>");
        out.println("<h1>Available flowers:</h1>");
        for (Flower flower: storage.getAssortment()) {

            if (!flower.isOneMoreItem(basket.getAmount(flower.getId())))
                disabled = "disabled='true'";

            out.println("<form action=\"basket\" method='post'>");
            out.println("<p>"+ flower.toString() + "</p>");
            out.println("<input type='text' name=\"id\" value=\"" + flower.getId() + "\" hidden>");
            out.println("<input type=\"submit\" value=\"Dodaj do koszyka\" " +
                    "onclick='alert(\"Dodano " + flower.getName() + " !\")' " +
                    disabled +"'>");
            out.println("</form>");
            System.out.println(!flower.isOneMoreItem(basket.getAmount(flower.getId())));
            System.out.println(basket.getAmount(flower.getId()));
            System.out.println(flower.getId());

        }


        out.println("<h3>Add new flower</h3>");
        out.println("<form action='shop' method='post'>");
        out.println("<input type='text' name='name' placeholder='Name'>");
        out.println("<input type='date' name='pickDate' value''>");
        out.println("<input type='checkbox' name='dogToxic' value='false'>Toxic for dogs</input>");
        out.println("<input type='text' name='price' placeholder='Price'>");
        out.println("<input type='text' name='amount' placeholder='Amount'>");
        out.println("<input type=\"submit\" value=\"Zapisz!\">");
        out.println("</form>");
        out.println("");
        out.println("");
        out.println("<h1>");
        out.println("<a href='/florists/basket'><button>Go to your basket -></button></a>");
        out.println("</h1>");

        out.println("</body></html>");
        out.close();

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StorageService storage = (StorageService)getServletContext().getAttribute("shop_storage");

        HttpSession session = request.getSession();
        BasketService basket = (BasketService) session.getAttribute("basket");

        if(basket!=null) {
            for(Map.Entry<Long,Long> e: basket.getItems()) {
                storage.get(e.getKey()).substractAmount(e.getValue());
            }
        }

        session.removeAttribute("basket");
        response.sendRedirect(request.getContextPath()+"/basket");
    }


    @Override
    public void init() throws ServletException {

        getServletContext().setAttribute("shop_storage", new StorageService());

    }
}
