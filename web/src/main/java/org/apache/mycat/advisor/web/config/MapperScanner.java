package org.apache.mycat.advisor.web.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * package: springboot.simple.config <br/>
 * functional describe:配置Mybatis的mapper接口自动注入
 * 此配置必须在{@see MyBatisConfig}配置完成后才能配置
 *
 * @author DR.YangLong [410357434@163.com]
 * @version 1.0    2016/3/13 17:08
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MapperScanner {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer scanner=new MapperScannerConfigurer();
        //配置mapper接口所在的包
        scanner.setBasePackage("org.apache.mycat.advisor.persistence.dao");
        //配置默认的sqlSessionFactory，与MyBatisConfig中配置的别名一致
        scanner.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //配置只扫描某个注解的接口
        //scanner.setAnnotationClass(MyBatisRepository.class);
        return scanner;
    }
}
