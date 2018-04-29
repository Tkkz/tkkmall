package com.tkkmall.service;

import com.tkkmall.common.ServerResponse;
import com.tkkmall.pojo.User;

/**
 * Created by sssss on 2018/4/29.
 */
public interface IUserService {

    public ServerResponse<User> login(String username, String password);

    public ServerResponse<String> register(User user);

    public ServerResponse<String> checkValid(String str, String type);
}
