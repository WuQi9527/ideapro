package com.itheima.servlet;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;utf-8");
            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user, map);
            HttpSession session = request.getSession();
            String session_code = (String) session.getAttribute("session_code");
            session.removeAttribute("sessiom_code");

            if (session_code!=null&&session_code.equalsIgnoreCase("checkCode")){
                UserDao dao=new UserDao();
                User exsitUser= dao.login(user);
                if (exsitUser==null){
                    request.setAttribute("msg","用户名或密码错误!");
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                }else{
                    request.setAttribute("user",exsitUser);
                    response.sendRedirect(request.getContextPath()+"/success.jsp");
                }
            }else{
                request.setAttribute("msg","验证码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
