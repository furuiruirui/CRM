package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.settings.dao.UserDao;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.utils.DateTimeUtil;
import com.bjpowernode.crm.utils.SqlSessionUtil;


import java.util.HashMap;
import java.util.Map;


/**
 * @author free
 * @version 1.0
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao= SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String username, String password, String ip) throws LoginException {
        Map<String,String> map=new HashMap<String,String>();
        map.put("username",username);
        map.put("password",password);
        User user=userDao.login (map);
        if (user == null){
            throw new LoginException("用户名或密码错误");
        }
        String experiTime=user.getExpireTime();
        String sysTime = DateTimeUtil.getSysTime();
        if (experiTime.compareTo(sysTime)<0){
            throw new LoginException("时间已失效");
        }
        String lockState = user.getLockState();
        if ("0".equals(lockState)){
            throw new LoginException("账号被锁定");
        }

        return user;
    }
}
