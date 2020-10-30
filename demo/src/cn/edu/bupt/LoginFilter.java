package cn.edu.bupt;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/addServlet/*"})
public class LoginFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String ctxPath=request.getContextPath();
        String current_path=request.getRequestURI();
        String target=current_path.substring(ctxPath.length());
        if (!target.equals("/addServlet/Login")) {
            if (session.getAttribute("isLogin") == null) {//判断session中是否有登录成功标志isLogin
                System.out.println("no find");
                RequestDispatcher rd = request.getRequestDispatcher("/login.html");//重定向到登录界面
                rd.forward(request, response);
            }
            else {
                Integer isLogin = (Integer) session.getAttribute("isLogin");
                if (isLogin == 1) {//登录状态为1,表示登录成功，放行
                    System.out.println(isLogin);
                    System.out.println("success");
                    chain.doFilter(req, resp);

                } else {//登录状态不为1，登录失败，重定向到登录界面
                    System.out.println("error");
                    RequestDispatcher rd = request.getRequestDispatcher("/login.html");
                    rd.forward(request, response);
                    chain.doFilter(request, response);
                }
            }
        }
        else {//访问的是登录界面，直接放行
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
