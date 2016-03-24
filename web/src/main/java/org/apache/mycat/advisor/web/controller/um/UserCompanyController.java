package org.apache.mycat.advisor.web.controller.um;

import org.apache.mycat.advisor.common.controller.BaseController;
import org.apache.mycat.advisor.common.controller.Page;
import org.apache.mycat.advisor.common.controller.ResultMap;
import org.apache.mycat.advisor.persistence.model.TabCompany;
import org.apache.mycat.advisor.service.um.company.UserCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by cjl on 2016/3/18.
 */
@RestController
@RequestMapping("/um/company/")
public class UserCompanyController extends BaseController {
    @Autowired
    UserCompanyService userCompanyService;


    @RequestMapping("list")

    public ResultMap list(@RequestParam Map<String, Object> param) {
        Page page = userCompanyService.page(param);
        return sucess(page);
    }


    @RequestMapping("save")
    public ResultMap save(TabCompany company) {
        if (userCompanyService.save(company)) {
            return success();
        } else {
            return failure("保存操作失败!");
        }
    }

    @RequestMapping("init")
    public ResultMap init() {
        return success();
    }

    @RequestMapping("get/{id}")
    public ResultMap info(@PathVariable long id) {
        TabCompany info = userCompanyService.get(id);
        return success(info);
    }

    @RequestMapping("del/{id}")
    public ResultMap del(@PathVariable long id) {
        if (userCompanyService.delete(id)) {
            return success();
        } else {
            return failure("删除操作失败！");
        }
    }


}
