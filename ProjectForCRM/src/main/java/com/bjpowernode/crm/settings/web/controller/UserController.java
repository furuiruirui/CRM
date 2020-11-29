package com.bjpowernode.crm.settings.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        }else if ("/settings/user/xxx.do".equals(path)){

        }


    }
}
