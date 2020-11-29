package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.settings.dao.UserDao;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.utils.SqlSessionUtil;


/**
 * @author free
 * @version 1.0
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao= SqlSessionUtil.getSqlSession().getMapper(UserDao.class);



}
