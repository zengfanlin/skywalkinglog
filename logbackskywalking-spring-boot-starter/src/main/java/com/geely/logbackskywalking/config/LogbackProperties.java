package com.geely.logbackskywalking.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description:
 * @author: fanlin.zeng
 * @time: 2020-8-10 9:59
 */
@ConfigurationProperties(prefix = "logging")
public class LogbackProperties {

    private boolean skywalkingenable;

    public boolean isSkywalkingenable() {
        return skywalkingenable;
    }

    public void setSkywalkingenable(boolean skywalkingenable) {
        this.skywalkingenable = skywalkingenable;
    }
}
