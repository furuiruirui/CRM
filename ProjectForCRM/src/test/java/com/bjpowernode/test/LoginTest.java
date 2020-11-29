package com.bjpowernode.test;

import com.bjpowernode.crm.utils.DateTimeUtil;
import com.bjpowernode.crm.utils.MD5Util;
import org.junit.Test;

/**
 * @author free
 * @version 1.0
 */
public class LoginTest {
    /*
    验证时间是否失效
     */
    @Test
    public void test01(){
        String time="2020-11-28 15:00:00";
        String nowTime = DateTimeUtil.getSysTime();
        int count = nowTime.compareTo(time);
        System.out.println(count);
    }
    /*
    验证是否锁定
     */
    public void test02(){
        String status="0";
        if("0".equals(status)){
            System.out.println("账号被锁定");
        }
    }
    /*
    md5加密
     */
    @Test
    public void test03(){
        String password="fr13759736955";
        String md5 = MD5Util.getMD5(password);
        System.out.println(md5);
    }
}
