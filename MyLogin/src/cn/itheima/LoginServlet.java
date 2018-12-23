package cn.itheima;
/*作业题目：
        1.创建一个JavaEE的项目：MyLogin
        2.自定义一个Servlet类：LoginServlet    继承 HttpServlet  重写doGet和doPost这两个方法
        3.指定虚拟路径为：day26login
        4.指定Servlet资源路径为：/mylogin
        5.在web文件夹下，写一个login.html文件。
        提供：
        表单：提交方式是POST  action提交路径：/day26login/mylogin
        用户名输入框
        密码输入框
        登录按钮
        6.在doPost方法中，获取用户名和密码的信息。   getParamter(键名);
        7.创建一个day26数据库
        8.创建一个users数据表
        9.通过JDBC连接数据库，通过获取到的用户名和密码去数据库中查询用户。
        如果有数据：在控制台输出：登录成功
        如果没有查询到数据：在控制台输出：登录失败*/

import javax.servlet.http.HttpServlet;

public class LoginServlet extends HttpServlet {

}
