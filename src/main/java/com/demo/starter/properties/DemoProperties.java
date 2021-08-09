package com.demo.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/5/7 22:08
 * @Version V1.0
 **/

//把相同前缀的配置信息通过配置项名称映射成实体类
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {
    private String sayWhat;
    private String toWho;

    public String getSayWhat() {
        return sayWhat;
    }

    public void setSayWhat(String sayWhat) {
        this.sayWhat = sayWhat;
    }

    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }
}
