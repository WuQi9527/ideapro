package com.itheima01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/mylogin")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //查询数据库
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/db1";
            Connection con = DriverManager.getConnection(url,"root","root");

            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,password);

            ResultSet rs = pst.executeQuery();

            resp.setContentType("text/html;charset=utf-8");

            if(rs.next()) {
                resp.getWriter().write("登录成功，欢迎您：" + username);
            }else {
                resp.getWriter().write("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
