package cn.itcast.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/登录案例")
public class 登录案例 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");
        if (checkCode_session != null && checkCode_session.equals(checkcode)) {
            if ("wuqi".equals(username) && "123".equals(password)) {
                session.setAttribute("user", username);
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                request.setAttribute("login_error", "用户名或密码错误");
                request.getRequestDispatcher("/login/jsp").forward(request, response);


            }

        } else {
            //验证码不一致
            //存储提示信息到request
            request.setAttribute("cc_error", "验证码错误");
            //转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
