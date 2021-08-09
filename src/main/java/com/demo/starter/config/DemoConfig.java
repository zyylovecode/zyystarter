package com.demo.starter.config;

import com.demo.starter.properties.Demo1Properties;
import com.demo.starter.properties.DemoProperties;
import com.demo.starter.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/5/7 21:50
 * @Version V1.0
 **/
@Configuration
@EnableConfigurationProperties({Demo1Properties.class, DemoProperties.class})
@ConditionalOnProperty(//控制@Configuration是否生效
        prefix = "demo",//prefix为配置文件中的前缀,
        name = "isopen",//name为配置的名字
        havingValue = "true"//havingValue是与配置的值对比值,当两个值相同返回true,配置类生效.
)

public class DemoConfig {
    @Autowired
    private Demo1Properties demo1Properties;
    @Autowired
    private DemoProperties demoProperties;

    @Bean(name = "demo")
    public DemoService demoService(){
        return new DemoService(demoProperties.getSayWhat(), demoProperties.getToWho());
    }
    @Bean(name = "demo1")
    public DemoService  demo1Service(){
        return new DemoService(demo1Properties.getSayWhat(), demo1Properties.getToWho());
    }
}
