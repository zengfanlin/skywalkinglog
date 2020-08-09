package com.example.provider;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;

public class SkLogAppender extends UnsynchronizedAppenderBase<ILoggingEvent> {
    @Override
    protected void append(ILoggingEvent eventObject) {
//        doc.setTime(DateFormatUtils.format(eventObject.getTimeStamp(), "yyyy-MM-dd HH:mm:ss"));
//        doc.setLevel(eventObject.getLevel().toString());
//        doc.setLogger(eventObject.getLoggerName());
//        doc.setThread(eventObject.getThreadName());
//        doc.setCurThread(Thread.currentThread().getName());
//        doc.setMessage(eventObject.getFormattedMessage());

        // 这里对log信息重新调用放到链路里
        if (Level.ERROR.equals(eventObject.getLevel())) {
            ActiveSpan.error(eventObject.getFormattedMessage());
//            ActiveSpan.error(eventObject.getThrown());
        } else if (Level.INFO.equals(eventObject.getLevel())) {
            ActiveSpan.info(eventObject.getFormattedMessage());
        } else if (Level.DEBUG.equals(eventObject.getLevel())) {
            ActiveSpan.debug(eventObject.getFormattedMessage());
        }
    }
}
