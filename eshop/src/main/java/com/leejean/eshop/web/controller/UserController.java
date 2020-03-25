package com.leejean.eshop.web.controller;

import com.leejean.eshop.model.User;
import com.leejean.eshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    //注入userService给controller
    @Resource(name = "userService")
    private UserService us;

    /*
    去注册页面
     */
    @RequestMapping(name = "/toRegPage",method = RequestMethod.GET)
    public String toRegPage(){
        return "userReg" ;
    }

    /*
    完成注册
     */
    @RequestMapping(value = "/doReg", method = RequestMethod.POST)
    public String doReg(User user, HttpServletRequest reg, Model m){
        //获取确认密码
        String confirmPass = reg.getParameter("confirmPass");
        //判断先后输入的密码是否一致
        if (!user.getPassword().equals(confirmPass)){
            m.addAttribute("error", "两次密码输入不一致！！");
            return "userReg";
        }
        //2.判断email是否唯一
        boolean b = us.isRegisted(user.getEmail());
        if (b){
            m.addAttribute("error.email.registed","邮箱已经注册!");
            return "userReg" ;
        }

        us.saveEntity(user);
        System.out.println("注册成功");
        return "login";
    }

    /*
    去登录页面
     */
    @RequestMapping(value = "/toLoginPage",method =RequestMethod.GET)
    public String toLoginPage(){
        return "login";
    }
//
//
    /*
    User:封装用户信息
    Session: 保存登录成功的用户信息
    m: 登录失败，向客户端传递消息载体
     */
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public String doLogin(User user, HttpSession s, Model m){
        List<User> list = us.findByHQL("from User u where u.name = ? and u.password = ?", user.getName(), user.getPassword());
        if (list == null || list.isEmpty()){
            /*
            登录失败，回传数据
             */
            m.addAttribute("error", "用户名或密码错误！！");
        }else {
            /*
            如果登录成功，将用户信息保存到当前会话session中
             */
            User u = list.get(0);
            s.setAttribute("name", u.getName());

        }
        return "index";

    }
}
