package com.bjpowernode.test;

import com.bjpowernode.crm.settings.dao.UserDao;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author free
 * @version 1.0
 */
public class test {

    @Test
    public void test01(){
        UserDao dao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
        Map<String,String> map=new HashMap<>();
        map.put("username","zs");
        map.put("password","202cb962ac59075b964b07152d234b70");
        User user = dao.login(map);
        System.out.println(user);
    }
}
