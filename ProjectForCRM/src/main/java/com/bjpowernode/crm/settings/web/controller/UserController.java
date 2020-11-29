package com.bjpowernode.crm.settings.web.controller;

import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.settings.service.impl.UserServiceImpl;
import com.bjpowernode.crm.utils.MD5Util;
import com.bjpowernode.crm.utils.PrintJson;
import com.bjpowernode.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author free
 * @version 1.0
 */
public class UserController  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("进入用户控制器");
        String path=req.getServletPath();
        if ("/settings/user/login.do".equals(path)){
            System.out.println("进入登录方法");
            login(req,resp);
        }else if ("/settings/user/xxx.do".equals(path)){

        }


    }


    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        password = MD5Util.getMD5(password);
        String ip=req.getRemoteAddr();
        UserService userService=(UserService) ServiceFactory.getService(new UserServiceImpl());
        try {
            User user=userService.login(username,password,ip);
            req.getSession().setAttribute("user",user);
            PrintJson.printJsonFlag(resp,true);
        }catch (Exception e){
            e.printStackTrace();
            String message = e.getMessage();
            Map<String,Object> map=new HashMap<>();
            map.put("success",false);
            map.put("msg",message);
            PrintJson.printJsonObj(resp,map);
        }

    }
}
