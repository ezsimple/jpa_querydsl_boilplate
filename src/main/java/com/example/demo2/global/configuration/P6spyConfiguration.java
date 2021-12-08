package com.example.demo2.global.configuration;

import com.p6spy.engine.spy.P6SpyLoadableOptions;
import com.p6spy.engine.spy.P6SpyOptions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class P6spyConfiguration {
    @PostConstruct
    public void setLogMessageFormat() {
        P6SpyLoadableOptions active = P6SpyOptions.getActiveInstance();
        P6SpyOptions.getActiveInstance().setLogMessageFormat(P6spyPrettySqlFormatter.class.getName());
    }
}