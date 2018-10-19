package javaee.servlet.counter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/counter")
public class CounterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        Counter sCounter;

        if (session.getAttribute("session_counter")==null) {
            sCounter = new Counter();
        } else {
            sCounter = ((Counter) session.getAttribute("session_counter"));  // ---> robic rzutowanie typu !!!
        }


        Counter gCounter =  (Counter)getServletContext().getAttribute("application_counter");
        gCounter.increment();

        sCounter.increment();

        session.setAttribute("session_counter", sCounter);

//        session.setMaxInactiveInterval(3);      // po trzech sekundach bedzie nowa sesja

        out.println("<html><body>");
        out.println("<H1>Sessja id" +session.getId()+"</H1>");
        out.println("<H1>Sessja counter: " +sCounter.getValue()+"</H1>");
        out.println("<H1>Global counter: " +gCounter.getValue()+"</H1>");

        out.println("</body></html>");

//        application context getServletContext();

        // nowe okienko = ta sama sesja, nowy tab tak samo
    }

    @Override
    public void init() throws ServletException {


    getServletContext().setAttribute("application_counter", new Counter());
        // tworzymy na inicie i potem mozemy sie do niego odniesc w getcie??



    }


}
