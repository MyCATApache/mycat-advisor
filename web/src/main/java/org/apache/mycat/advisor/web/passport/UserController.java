package org.apache.mycat.advisor.web.passport;

import org.apache.mycat.advisor.persistence.model.usercenter.UserInfo;
import org.apache.mycat.advisor.service.usercenter.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * package: springboot.simple.controller <br/>
 * functional describe:
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/3/13 16:03
 */
@RestController
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/rest")
    public UserInfo userInfoRest(){
        return userInfoService.findById(1);
    }

    @RequestMapping("/ftl")
    public ModelAndView userInfoFtl(){
        ModelAndView modelAndView=new ModelAndView("userInfo");
        UserInfo userInfo=userInfoService.findById(1);
        modelAndView.addObject("user",userInfo);
        return modelAndView;
    }
}
