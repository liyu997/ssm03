package com.yShen.sys.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import com.yShen.sys.constast.SysConstast;
import com.yShen.sys.dao.IUserDao;
import com.yShen.sys.model.User;
import com.yShen.sys.service.ILogInfoService;
import com.yShen.sys.service.IUserService;
import com.yShen.sys.service.impl.UserService;
import com.yShen.sys.util.WebUtils;
import com.yShen.sys.vo.LogInfoVo;
import com.yShen.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

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


    ILogInfoService logInfoService;

    public ILogInfoService getLogInfoService() {
        return logInfoService;
    }

    @Autowired
    public void setLogInfoService(ILogInfoService logInfoService) {
        this.logInfoService = logInfoService;
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

    @RequestMapping("/getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {


//        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116,36);
//        session.setAttribute("code",lineCaptcha.getCode());
//        ServletOutputStream outputStream = response.getOutputStream();
//        ImageIO.write(lineCaptcha.getImage(),"JPEG",outputStream);


        // 自定义纯数字的验证码（随机4位数字，可重复）
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36);
        lineCaptcha.setGenerator(randomGenerator);
// 重新生成code
        lineCaptcha.createCode();

        session.setAttribute("code", lineCaptcha.getCode());


        lineCaptcha.write(response.getOutputStream());


    }

    /**
     * 登陆方法
     */
    @RequestMapping("/loginin")
    public String logins() {
            return "system/main/index";
    }


    /**
     * 登陆方法
     */
    @RequestMapping("/login")
    public String login(UserVo userVo, Model model) {

        String code = (String) WebUtils.getHttpSession().getAttribute("code");

        if (userVo.getCode().equals(code)) {
            User user = this.userService.login(userVo);
            if (user != null) {
                WebUtils.getHttpSession().setAttribute("user", user);
//            插入登录日志
                LogInfoVo logInfoVo = new LogInfoVo();
                logInfoVo.setLogintime(new Date());
                logInfoVo.setLoginname(user.getRealname() + "-" + user.getLoginname());
                logInfoVo.setLoginip(WebUtils.getHttpServletRequest().getRemoteAddr());
                logInfoService.addLogInfo(logInfoVo);
                return "redirect:loginin";
            } else {
                model.addAttribute("error", SysConstast.USER_LOGIN_ERROR_MSG);
                return "system/main/login";
            }
        } else {
            model.addAttribute("error", SysConstast.USER_LOGIN_CODE_ERROR_MSG);
            return "system/main/login";
        }


    }


    @RequestMapping("/toDeskManager")
    public String toDeskManager() {
        return "/system/main/deskManager";
    }


}
