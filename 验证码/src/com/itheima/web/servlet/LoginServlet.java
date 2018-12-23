package com.itheima.web.servlet;

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
import java.util.Map;

/**
 * 一次性验证
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //处理乱码
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");

            //1. 获取表单提交所有数据
            Map<String, String[]> map = request.getParameterMap();

            //2. 封装到User对象
            User user = new User();
            BeanUtils.populate(user, map);

            //3. 优先校验验证码
            //3.1 获取session存储的验证码
            HttpSession session = request.getSession();
            String session_code = (String) session.getAttribute("session_code");

            // 注意: 为了确保验证码只能使用一次.从session中获取后,删除验证码
            session.removeAttribute("session_code");


            //3.2 比较两码是否一致
            if (session_code != null && session_code.equalsIgnoreCase(user.getCheckCode())) {
                //验证码校验通过
                //4. 校验用户名和密码
                UserDao dao = new UserDao();
                User existUser = dao.login(user);
                if (existUser == null) {
                    // 登录失败
                    request.setAttribute("msg", "用户名或密码错误");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                } else {
                    // 登录成功
                    //将用户信息保存到session
                    session.setAttribute("user", existUser);
                    // 重定向到网站首首页,防止重复提交
                    response.sendRedirect(request.getContextPath() + "/success.jsp");
                }

            } else {
                //验证码校验失败
                request.setAttribute("msg", "验证码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
