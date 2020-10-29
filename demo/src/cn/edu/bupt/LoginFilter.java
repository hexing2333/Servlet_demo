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
        if (!target.equals("/addServlet/LoginServlet")) {
            if (session.getAttribute("isLogin") == null) {
                System.out.println("no find");
                RequestDispatcher rd = request.getRequestDispatcher("/login.html");
                rd.forward(request, response);
            }
            else {
                Integer isLogin = (Integer) session.getAttribute("isLogin");
                if (isLogin == 1) {
                    System.out.println(isLogin);
                    System.out.println("success");
                    chain.doFilter(req, resp);

                } else {
                    System.out.println("error");
                    RequestDispatcher rd = request.getRequestDispatcher("/login.html");
                    rd.forward(request, response);
                    chain.doFilter(request, response);
                }
            }
        }
        else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
