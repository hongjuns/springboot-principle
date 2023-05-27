package com.example.tobyspringboot.config.autoconfig;

import org.springframework.boot.context.properties.bind.Binder;
import com.example.tobyspringboot.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {

    @Bean
    public ServerProperties serverProperties(Environment environment) {
        return Binder.get(environment).bind("", ServerProperties.class).get();
    }
}
