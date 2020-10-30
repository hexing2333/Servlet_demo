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
        Integer isLogin = 0;//isLogin初始为0代表未登录
        if(username.equals("admin")&&password.equals("123456")){//登录用户名和密码正确，将isLogin置为1
            isLogin=1;
            out.println("<text>");
            out.println("success");
            out.println("</text></br>");
        }
        session.setAttribute("isLogin",isLogin);//设置session中的isLogin为1
        out.println("isLogin:");
        out.println(session.getAttribute("isLogin"));
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
