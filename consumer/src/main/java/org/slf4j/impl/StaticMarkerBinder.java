package org.slf4j.impl;

import org.apache.logging.slf4j.Log4jMarkerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.spi.MarkerFactoryBinder;

public class StaticMarkerBinder  implements MarkerFactoryBinder {
    public static final org.slf4j.impl.StaticMarkerBinder SINGLETON = new org.slf4j.impl.StaticMarkerBinder();
    private final IMarkerFactory markerFactory = new Log4jMarkerFactory();

    public StaticMarkerBinder() {
    }

    @Override
    public IMarkerFactory getMarkerFactory() {
        return this.markerFactory;
    }

    @Override
    public String getMarkerFactoryClassStr() {
        return Log4jMarkerFactory.class.getName();
    }
}


