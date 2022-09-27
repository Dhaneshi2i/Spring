package com.ideas2it.controller;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class MyFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
