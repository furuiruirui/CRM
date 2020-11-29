package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.settings.domain.User;


/**
 * @author free
 * @version 1.0
 */
public interface UserService {
    User login(String username, String password, String ip) throws LoginException;
}
