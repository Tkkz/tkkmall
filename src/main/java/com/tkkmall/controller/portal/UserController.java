package com.tkkmall.controller.portal;

import com.tkkmall.common.Conts;
import com.tkkmall.common.ServerResponse;
import com.tkkmall.pojo.User;
import com.tkkmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 *
 */
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService IUserService;

    //登陆
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(HttpSession session, String username, String password) {

        ServerResponse<User> response = IUserService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Conts.CURRENT_USER, response.getData());
        }
        return response;
    }
    //推出登陆
    @RequestMapping(value = "logout.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse logout(HttpSession session) {
        session.removeAttribute(Conts.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    //注册用户
    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(User user){
        return null;
    }
}
