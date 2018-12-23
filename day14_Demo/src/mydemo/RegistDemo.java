package mydemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

//修改之后要重启服务器 草
@WebServlet("/RegistDemo")
public class RegistDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       /* String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobby");

        System.out.println(username);
       System.out.println(password);
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/

        /*Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            System.out.println(s);
            String name = req.getParameter(s);
            System.out.println(name);
            System.out.println("==============");
        }*/

        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String string : strings) {
            System.out.println(string);
            String[] strings1 = parameterMap.get(string);
            for (String s : strings1) {
                System.out.println(s);
            }
            System.out.println("===================");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
