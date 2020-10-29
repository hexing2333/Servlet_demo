package cn.edu.bupt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "doneServlet")
public class doneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Integer a=Integer.valueOf(request.getParameter("a"));
        Integer b=Integer.valueOf(request.getParameter("b"));
        Integer c=a+b;
        PrintWriter out=response.getWriter();
        out.println("<p style='font-size:30px;font-weight:bold;'>");
        out.println(c);
        out.println("</p>");

        System.out.println("ok");
    }
}
