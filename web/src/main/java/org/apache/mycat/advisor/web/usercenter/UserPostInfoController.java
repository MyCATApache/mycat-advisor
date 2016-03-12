package org.apache.mycat.advisor.web.usercenter;


import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.usercenter.UserPostInfo;
import org.apache.mycat.advisor.service.usercenter.UserPostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by cjl on 2016/3/11.
 */
@RestController
@RequestMapping("/user/post")
public class UserPostInfoController extends BaseController {
    @Autowired
    private UserPostInfoService service;

    @RequestMapping("/init")
    public ResultMap init() {
        return success(new UserPostInfo());
    }


    @RequestMapping("/list")
    public ResultMap list(@RequestParam Map<String,Object> param) {
        Page page = service.page(param);
        return sucess(page);
    }

    @RequestMapping("/get/{id}")
    public ResultMap list(@PathVariable Integer id) {
        UserPostInfo postInfo = service.get(id);
        return success(postInfo);
    }

    @RequestMapping("/save")
    public ResultMap save(UserPostInfo userPostInfo) {
        System.out.println(userPostInfo);
        if (service.save(userPostInfo)) {
            return success();
        } else {
            return failure("新增失败");
        }

    }

    @RequestMapping("/del/{id}")
    public ResultMap del(@PathVariable Integer id) {
        if (service.del(id)) {
            return success();
        } else {
            return failure("删除失败");
        }
    }






}
