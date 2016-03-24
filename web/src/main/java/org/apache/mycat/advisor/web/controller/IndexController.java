package org.apache.mycat.advisor.web.controller;

import org.apache.mycat.advisor.persistence.model.TabUserInfo;
import org.apache.mycat.advisor.service.um.userinfo.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * package: org.apache.mycat.advisor.desktop.passport <br/>
 * blog:<a href="http://dr-yanglong.github.io/">dr-yanglong.github.io</a><br/>
 * functional describe:登录控制器，提供基于JWT（json web token）方式的登录认证接口，常规web登录接口，ajax登录接口。
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/3/11
 */
@Controller
@RequestMapping("/")
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("")
    public String root() {
        return "redirect:index";
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        TabUserInfo userInfo = (TabUserInfo) request.getSession().getAttribute("session_user");
        if (userInfo != null) {
            return "index";
        }

        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> doLogin(HttpServletRequest request,@RequestParam Map<String,String> param) {
        Map<String, Object> data = new HashMap<String, Object>();
        TabUserInfo userInfo = userInfoService.findUserByUsername(param.get("username"));
        String password = param.get("password");
        if (userInfo != null && userInfo.getPassword().equals(password)) {
            request.getSession().setAttribute("session_user",userInfo);
            data.put("flag", "true");
        }else
            data.put("msg", "用户名或密码不正确");
        return data;
    }

}
