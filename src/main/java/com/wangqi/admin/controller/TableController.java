package com.wangqi.admin.controller;

import com.wangqi.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @Author 王琦
 * @Date 2021/8/13 23:16
 * @Discription
 */
@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basic_table(){
        return "tables/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        // 动态传递用户信息
        List<User> users = Arrays.asList(new User("zhangsan", "111wefd"),
                new User("lisi", "aslfj"),
                new User("wangwu", "asdf"),
                new User("zhaoliu", "asdfsadf"));
        model.addAttribute("users",users);
        return "tables/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "tables/editable_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "tables/responsive_table";
    }
}
