package com.yShen.sys.controller;


import com.yShen.sys.constast.SysConstast;
import com.yShen.sys.dao.IUserDao;
import com.yShen.sys.model.User;
import com.yShen.sys.service.IUserService;
import com.yShen.sys.service.impl.UserService;
import com.yShen.sys.util.WebUtils;
import com.yShen.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/login")
public class loginController {

    IUserService userService;

    public IUserService getUserService() {
        return userService;
    }
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    /**
     * 跳转到登陆页面
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "system/main/login";

    }

    @RequestMapping("/ce")
    public String ceshi() {
        return "ha";

    }



    /**登陆方法*/
    @RequestMapping("/login")
    public String login(UserVo userVo ,Model model){


        User user = this.userService.login(userVo);


        if (user != null) {
            WebUtils.getHttpSession().setAttribute("user",user);
//            插入登录日志
            return "system/main/index";
        }else {
            model.addAttribute("error", SysConstast.USER_LOGIN_ERROR_MSG);

            return "system/main/login";
        }

    }


    @RequestMapping("/toDeskManager")
    public String toDeskManager(){
        return "/system/main/deskManager";
    }


}
