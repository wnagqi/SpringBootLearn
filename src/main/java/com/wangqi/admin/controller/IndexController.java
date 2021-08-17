package com.wangqi.admin.controller;

import com.wangqi.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author 王琦
 * @Date 2021/8/13 19:24
 * @Discription
 */
@Controller
public class IndexController {
    /**
     *  来登录页
     * @return
     */
    @RequestMapping({"/","/login"})
    public String loginPage(){
        return "login";
    }

    /**
     * 表单提交，使用重定向防止重复提交
     * @return
     */
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if (StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户名密码不能为空");
            // 回到登录页面
            return "login";
        }

    }

    /**
     * 跳转到主页面
     * @return
     */
    @GetMapping("/main.html")
    public String gotoMainPage(HttpSession session,Model model){
//        Object loginUser = session.getAttribute("loginUser");
//        // 是否登录，session里面有东西就是登录成功
//        if (loginUser != null){
//            return "main";
//        }else{
//            model.addAttribute("msg","请输入用户信息");
//            // 回到登录页面
//            return "login";
//        }
        return "main";

    }
}
