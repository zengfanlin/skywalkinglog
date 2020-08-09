package org.slf4j.impl;

import com.example.log.NewLog4jLoggerFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * @author wangguodong
 */
public class StaticLoggerBinder
        implements LoggerFactoryBinder {
    public static String REQUESTED_API_VERSION = "1.6";
    private static final String LOGGER_FACTORY_CLASS_STR = NewLog4jLoggerFactory.class.getName();
    private static final org.slf4j.impl.StaticLoggerBinder SINGLETON = new org.slf4j.impl.StaticLoggerBinder();
    private final ILoggerFactory loggerFactory = new NewLog4jLoggerFactory();

    private StaticLoggerBinder() {
    }

    public static org.slf4j.impl.StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    @Override
    public ILoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }

    @Override
    public String getLoggerFactoryClassStr() {
        return LOGGER_FACTORY_CLASS_STR;
    }
}

