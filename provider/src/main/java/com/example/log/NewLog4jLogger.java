package com.example.log;


import org.apache.logging.log4j.message.FormattedMessage;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.slf4j.Log4jLogger;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.slf4j.Marker;
import org.slf4j.spi.LocationAwareLogger;

import java.io.Serializable;

public class NewLog4jLogger implements LocationAwareLogger, Serializable {
    private Log4jLogger log4jLogger;

    public NewLog4jLogger(ExtendedLogger logger, String name) {
        log4jLogger = new Log4jLogger(logger, name);
    }

    @Override
    public void log(Marker marker, String s, int i, String s1, Object[] objects, Throwable throwable) {
        log4jLogger.log(marker, s, i, s1, objects, throwable);
    }

    @Override
    public String getName() {
        return log4jLogger.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return log4jLogger.isTraceEnabled();
    }

    @Override
    public void trace(String s) {
        log4jLogger.trace(s);

    }

    @Override
    public void trace(String s, Object o) {
        log4jLogger.trace(s, o);
    }

    @Override
    public void trace(String s, Object o, Object o1) {
        log4jLogger.trace(s, o, o1);
    }

    @Override
    public void trace(String s, Object... objects) {
        log4jLogger.trace(s, objects);
    }

    @Override
    public void trace(String s, Throwable throwable) {
        log4jLogger.trace(s, throwable);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return log4jLogger.isTraceEnabled(marker);
    }

    @Override
    public void trace(Marker marker, String s) {
        log4jLogger.trace(marker, s);
    }

    @Override
    public void trace(Marker marker, String s, Object o) {
        log4jLogger.trace(marker, s, o);
    }

    @Override
    public void trace(Marker marker, String s, Object o, Object o1) {
        log4jLogger.trace(marker, s, o, o1);
    }

    @Override
    public void trace(Marker marker, String s, Object... objects) {
        log4jLogger.trace(marker, s, objects);
    }

    @Override
    public void trace(Marker marker, String s, Throwable throwable) {
        log4jLogger.trace(marker, s, throwable);
    }

    @Override
    public boolean isDebugEnabled() {
        return log4jLogger.isDebugEnabled();
    }

    @Override
    public void debug(String s) {
        log4jLogger.debug(s);
        ActiveSpan.debug(s);
    }

    @Override
    public void debug(String s, Object o) {
        log4jLogger.debug(s, o);
        ActiveSpan.info(new FormattedMessage(s, o).getFormattedMessage());
    }

    @Override
    public void debug(String s, Object o, Object o1) {
        log4jLogger.debug(s, o, o1);
        ActiveSpan.info(new FormattedMessage(s, o, o1).getFormattedMessage());
    }

    @Override
    public void debug(String s, Object... objects) {
        log4jLogger.debug(s, objects);
        ActiveSpan.info(new FormattedMessage(s, objects).getFormattedMessage());
    }

    @Override
    public void debug(String s, Throwable throwable) {
        log4jLogger.debug(s, throwable);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return log4jLogger.isDebugEnabled(marker);
    }

    @Override
    public void debug(Marker marker, String s) {
        log4jLogger.debug(marker, s);
    }

    @Override
    public void debug(Marker marker, String s, Object o) {
        log4jLogger.debug(marker, s, o);
    }

    @Override
    public void debug(Marker marker, String s, Object o, Object o1) {
        log4jLogger.debug(marker, s, o, o1);
    }

    @Override
    public void debug(Marker marker, String s, Object... objects) {
        log4jLogger.debug(marker, s, objects);
    }

    @Override
    public void debug(Marker marker, String s, Throwable throwable) {
        log4jLogger.debug(marker, s, throwable);
    }

    @Override
    public boolean isInfoEnabled() {
        return log4jLogger.isInfoEnabled();
    }

    @Override
    public void info(String s) {
        log4jLogger.info(s);
        ActiveSpan.info(s);
    }

    @Override
    public void info(String s, Object o) {
        log4jLogger.info(s, o);
        ActiveSpan.info(new FormattedMessage(s, o).getFormattedMessage());
    }

    @Override
    public void info(String s, Object o, Object o1) {
        log4jLogger.info(s, o, o1);
        ActiveSpan.info(new FormattedMessage(s, o, o1).getFormattedMessage());

    }

    @Override
    public void info(String s, Object... objects) {
        log4jLogger.info(s, objects);
        ActiveSpan.info(new FormattedMessage(s, objects).getFormattedMessage());

    }

    @Override
    public void info(String s, Throwable throwable) {
        log4jLogger.info(s, throwable);//{},o,o

        ActiveSpan.info(new FormattedMessage(s, throwable).getFormattedMessage());

    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return log4jLogger.isInfoEnabled(marker);
    }

    @Override
    public void info(Marker marker, String s) {
        log4jLogger.info(marker, s);
    }

    @Override
    public void info(Marker marker, String s, Object o) {
        log4jLogger.info(marker, s, o);
    }

    @Override
    public void info(Marker marker, String s, Object o, Object o1) {
        log4jLogger.info(marker, s, o, o1);
    }

    @Override
    public void info(Marker marker, String s, Object... objects) {
        log4jLogger.info(marker, s, objects);
    }

    @Override
    public void info(Marker marker, String s, Throwable throwable) {
        log4jLogger.info(marker, s, throwable);
    }

    @Override
    public boolean isWarnEnabled() {
        return log4jLogger.isWarnEnabled();
    }

    @Override
    public void warn(String s) {
        log4jLogger.warn(s);
    }

    @Override
    public void warn(String s, Object o) {
        log4jLogger.warn(s, o);
    }

    @Override
    public void warn(String s, Object... objects) {
        log4jLogger.warn(s, objects);
    }

    @Override
    public void warn(String s, Object o, Object o1) {
        log4jLogger.warn(s, o, o1);
    }

    @Override
    public void warn(String s, Throwable throwable) {
        log4jLogger.warn(s, throwable);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return log4jLogger.isWarnEnabled(marker);
    }

    @Override
    public void warn(Marker marker, String s) {
        log4jLogger.warn(marker, s);
    }

    @Override
    public void warn(Marker marker, String s, Object o) {
        log4jLogger.warn(marker, s, o);
    }

    @Override
    public void warn(Marker marker, String s, Object o, Object o1) {
        log4jLogger.warn(marker, s, o, o1);
    }

    @Override
    public void warn(Marker marker, String s, Object... objects) {
        log4jLogger.warn(marker, s, objects);
    }

    @Override
    public void warn(Marker marker, String s, Throwable throwable) {
        log4jLogger.warn(marker, s, throwable);
    }

    @Override
    public boolean isErrorEnabled() {
        return log4jLogger.isErrorEnabled();
    }

    @Override
    public void error(String s) {
        log4jLogger.error(s);
        ActiveSpan.error(s);
    }

    @Override
    public void error(String s, Object o) {
        log4jLogger.error(s, o);
        ActiveSpan.error(new FormattedMessage(s, o).getFormattedMessage());
    }

    @Override
    public void error(String s, Object o, Object o1) {
        log4jLogger.error(s, o, o1);
        ActiveSpan.error(new FormattedMessage(s, o, o1).getFormattedMessage());
    }

    @Override
    public void error(String s, Object... objects) {
        log4jLogger.error(s, objects);
        ActiveSpan.error(new FormattedMessage(s, objects).getFormattedMessage());
    }

    @Override
    public void error(String s, Throwable throwable) {
        log4jLogger.error(s, throwable);
        ActiveSpan.error(s);
        ActiveSpan.error(throwable);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return log4jLogger.isErrorEnabled(marker);
    }

    @Override
    public void error(Marker marker, String s) {
        log4jLogger.error(marker, s);
    }

    @Override
    public void error(Marker marker, String s, Object o) {
        log4jLogger.error(marker, s, o);
    }

    @Override
    public void error(Marker marker, String s, Object o, Object o1) {
        log4jLogger.error(marker, s, o, o1);
    }

    @Override
    public void error(Marker marker, String s, Object... objects) {
        log4jLogger.error(marker, s, objects);
    }

    @Override
    public void error(Marker marker, String s, Throwable throwable) {
        log4jLogger.error(marker, s, throwable);
    }
}

