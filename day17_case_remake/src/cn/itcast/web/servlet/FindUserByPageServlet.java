package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String row = request.getParameter("row");
        if (currentPage != null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (row != null || "".equals(row)) {
            row = "5";
        }
        Map<String, String[]> condition = request.getParameterMap();

        UserService service=new UserServiceImpl();
         //  PageBean<User> pb=  service.findUserByPage(currentPage,rows,condition);
        System.out.println();



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
