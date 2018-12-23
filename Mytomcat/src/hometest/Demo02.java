package hometest;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/demo02")
public class Demo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* 1. 获取文件名称
        2. 使用字节输入流加载文件进内存
        3. 指定response的响应头： content-disposition:attachment;filename=xxx
        4. 将数据写出到response输出流*/
        String filename = request.getParameter("filename");
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        FileInputStream fileInputStream=new FileInputStream(realPath);

        
       //设置响应头
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        response.setHeader("content-disposition","attachment;filename="+filename);


        byte[] bytes = new byte[1024 * 8];
        int len=0;

        ServletOutputStream outputStream = response.getOutputStream();
        while((len=fileInputStream.read())!=0){
            outputStream.write(bytes,0,len);
        }
        fileInputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
