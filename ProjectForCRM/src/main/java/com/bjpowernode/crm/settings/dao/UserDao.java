package com.bjpowernode.crm.settings.dao;

import com.bjpowernode.crm.settings.domain.User;

import java.util.Map;

/**
 * @author free
 * @version 1.0
 */
public interface UserDao {

    User login(Map<String, String> map);
}
