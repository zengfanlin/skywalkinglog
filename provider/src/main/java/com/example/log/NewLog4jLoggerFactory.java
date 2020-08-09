package com.example.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.spi.AbstractLoggerAdapter;
import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.logging.log4j.util.StackLocatorUtil;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * @author wangguodong
 */
public class NewLog4jLoggerFactory extends AbstractLoggerAdapter<Logger> implements ILoggerFactory {
    private static final String FQCN = NewLog4jLoggerFactory.class.getName();
    private static final String PACKAGE = "org.slf4j";

    public NewLog4jLoggerFactory() {
    }

    @Override
    protected Logger newLogger(String name, LoggerContext context) {
        String key = "ROOT".equals(name) ? "" : name;
        return new NewLog4jLogger(context.getLogger(key), name);
    }

    @Override
    protected LoggerContext getContext() {
        Class<?> anchor = StackLocatorUtil.getCallerClass(FQCN, "org.slf4j");
        return anchor == null ? LogManager.getContext() : this.getContext(StackLocatorUtil.getCallerClass(anchor));
    }
}


