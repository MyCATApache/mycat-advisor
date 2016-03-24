package org.apache.mycat.advisor.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * package: springboot.simple <br/>
 * functional describe:
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/3/13 13:49
 */
@EnableWebMvc
@SpringBootApplication
@ComponentScan("org.apache.mycat.advisor")
public class Application extends SpringBootServletInitializer {
    private static final Logger logger= LoggerFactory.getLogger(Application.class);

  /*  @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }*/



    /**
     * 程序启动入口
     * @param args 参数
     */
    public static void main(String []args){
        logger.info("*********************正在启动*********************************");
        //SpringApplication.run(springboot.simple.ServerStart.class,args);
        SpringApplication application=new SpringApplication(Application.class);
        application.run(args);
        logger.info("*********************启动成功*********************************");
    }
}
