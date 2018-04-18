package com.tkkmall.service;

import com.tkkmall.common.ServerResponse;
import com.tkkmall.pojo.User;

/**
 * Created by sssss on 2018/4/18.
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);
}
