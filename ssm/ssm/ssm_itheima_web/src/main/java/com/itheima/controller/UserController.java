package com.itheima.controller;

import com.itheima.domain.Pages;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpSession session, User user, Integer ck, HttpServletResponse response) throws Exception {
        User u=userService.findUser(user);
        if (u!=null){
            session.setAttribute("user",u);
            Cookie cookieName=new Cookie("name",u.getUsername());
            Cookie cookiePwd=new Cookie("pwd",u.getPwd());
            if (ck!=null){
                cookieName.setMaxAge(7*24*60*60);
                cookiePwd.setMaxAge(7*24*60*60);
            }else{
                cookieName.setMaxAge(0);
                cookiePwd.setMaxAge(0);

            }//设置路径
            cookieName.setPath("/");
            cookiePwd.setPath("/");

            response.addCookie(cookieName);
            response.addCookie(cookiePwd);

            return "index1";
        }
        return "loginError";
    }

    @RequestMapping("/findAll")
    public String findAll(Pages pages, Model model) throws Exception {
        if(pages.getPageNum()==null){
            pages.setPageNum(1);
        }
        if(pages.getPageCounts()==null){
            pages.setPageCounts(3);//
        }
        //查询总条数
        Integer counts=userService.findCounts(pages);
        //分页查询
        List<User> userList = userService.findAll(pages);
        pages.setCounts(counts);
        Integer page= counts%pages.getPageCounts()==0?counts/pages.getPageCounts():counts/pages.getPageCounts()+1;
        pages.setPages(page);

        model.addAttribute("userList",userList);
        model.addAttribute("pages",pages);
        return "list";
    }
    @RequestMapping("/saveUser")
    public String saveUser(User user) throws Exception {
        userService.saveUser(user);
        return "redirect:/user/findAll";
    }
}
