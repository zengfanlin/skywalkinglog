package com.geely.logbackskywalking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: fanlin.zeng
 * @time: 2020-8-10 10:06
 */
@Configuration
@EnableConfigurationProperties(LogbackProperties.class)
@ConditionalOnClass(LogbackSkyWalkingConfigration.class)
@ConditionalOnProperty(prefix = "logging", value = "enabled", matchIfMissing = true)
public class LogbackSkyWalkingAutoConfigration {
    @Autowired
    private LogbackProperties logbackProperties;

    @Bean
    @ConditionalOnMissingBean(LogbackSkyWalkingConfigration.class)
    public LogbackSkyWalkingConfigration logbackSkyWalkingConfigration() {
        LogbackSkyWalkingConfigration loggingsetting = new LogbackSkyWalkingConfigration();
        loggingsetting.setSkywalkingenable(logbackProperties.isSkywalkingenable());

        return loggingsetting;
    }

}
