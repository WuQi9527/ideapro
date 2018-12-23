package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Proxy.newProxyInstance(req.getClass().getClassLoader(),req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParamater")){
                    String value= (String) method.invoke(req,args);
                    if (value!=null){
                        for (String s : list) {
                            if (value.contains(s)){
                               value = value.replace(s, "***");
                            }
                        }
                    } return value;
                }
         return method.invoke(req,args); }
        });



        chain.doFilter(req, resp);
    }


    public void destroy() {
    }

    private List<String> list=new ArrayList<>();
    public void init(FilterConfig config) throws ServletException {


        try{
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            BufferedReader br=new BufferedReader(new FileReader(realPath));
            String str=null;
             while ((str=br.readLine())!=null){
                 list.add(str);

             }
             br.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
