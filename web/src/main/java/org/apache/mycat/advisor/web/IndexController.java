package org.apache.mycat.advisor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by cjl on 2016/3/11.
 */
@Controller

public class IndexController {

    @RequestMapping("/index")
    public String index(Map<String,Object> model) {
        System.out.println("index");
        return "index";
    }

}
