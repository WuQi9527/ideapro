package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

       //强制转换
        HttpServletRequest request= (HttpServletRequest) req;
        //获取请求路径
        String uri = request.getRequestURI();
        if (uri.contains("/login.jsp")||uri.contains("/loginServlet")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/checkCode")||uri.contains("/fonts/")){
            chain.doFilter(req, resp);
        }
else{
            Object user = request.getSession().getAttribute("user");
            if (user!=null){
                chain.doFilter(req, resp);
            }
            else{
                request.setAttribute("log_msg","您尚未登录!");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
        //chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
