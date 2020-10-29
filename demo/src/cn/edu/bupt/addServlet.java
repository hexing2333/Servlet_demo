package cn.edu.bupt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "addServlet")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        System.out.println("enter");
        String para=request.getPathInfo();
        int a_index=para.indexOf("a");
        int b_index=para.indexOf("b");
        if(request.getParameter("a")!=null&&request.getParameter("b")!=null){
            String a=request.getParameter("a");
            String b=request.getParameter("b");
            System.out.println(a);
            System.out.println(b);
            if(isNumberByType(a)&&isNumberByType(b)){
                System.out.println("Valid");
                request.setAttribute("a",Integer.valueOf(a));
                request.setAttribute("b",Integer.valueOf(b));
                request.getRequestDispatcher("/doneServlet").forward(request,response);
            }
        }
        else {
            out.println("<p style='font-size:30px;font-weight:bold;'>");
            out.println("Invalid parameter");
            out.println("</p>");
        }

    }
    public static boolean isNumberByType(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
