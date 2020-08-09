package org.slf4j.impl;

import org.apache.logging.slf4j.Log4jMDCAdapter;
import org.slf4j.spi.MDCAdapter;

public class StaticMDCBinder {
    public static final org.slf4j.impl.StaticMDCBinder SINGLETON = new org.slf4j.impl.StaticMDCBinder();

    private StaticMDCBinder() {
    }

    public MDCAdapter getMDCA() {
        return new Log4jMDCAdapter();
    }

    public String getMDCAdapterClassStr() {
        return Log4jMDCAdapter.class.getName();
    }
}

