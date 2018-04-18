package com.tkkmall.service.impl;

import com.tkkmall.common.ServerResponse;
import com.tkkmall.dao.UserMapper;
import com.tkkmall.pojo.User;
import com.tkkmall.service.IUserService;
import com.tkkmall.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.spi.ServiceRegistry;

/**
 *
 */
@Service("iUserService")
public class UserServiceImp implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public ServerResponse<User> login(String username,String password){
        /**
         * 1检查用户名是否存在
         *   ->存在，继续登陆 不存在返回
         *
         * 将密码转换成MD5
         * 进行登陆 对用户名和密码进行校验（数据库加密存储的）
         *
         */
        int relustRow= userMapper.checkUsername(username);
        if (relustRow == 0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        String md5Password= MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username, md5Password);
        if (user==null){
            return ServerResponse.createByErrorMessage("密码错误");
        }
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功",user);
    }

    public ServerResponse<String> register(User user){
        /**
         * 1 检测用户名 邮箱 电话 等是否存在
         * 2 不存在才可以注册
         */

        return null;

    }

    public ServerResponse<String> checkValid(String str,String type){
        return null;
    }
}
