package cn.edu.bupt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session=request.getSession();
        PrintWriter out = response.getWriter();
        String username=request.getParameter("user");
        String password=request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        Integer isLogin = 0;
        if(username.equals("admin")&&password.equals("123456")){
            isLogin=1;
            out.println("<text>");
            out.println("success");
            out.println("</text></br>");
        }
        session.setAttribute("isLogin",isLogin);
        Enumeration e=session.getAttributeNames();
        while (e.hasMoreElements()){
            String name=(String)e.nextElement();
            String value=session.getAttribute(name).toString();
            out.println(name+"="+value);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        out.println("123");
    }
}
