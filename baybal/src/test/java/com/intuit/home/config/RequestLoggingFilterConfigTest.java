package com.intuit.home.config;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import static org.junit.Assert.*;

public class RequestLoggingFilterConfigTest {
    RequestLoggingFilterConfig requestLoggingFilterConfig;

    @Before
    public void init() {
        requestLoggingFilterConfig = new RequestLoggingFilterConfig();
    }

    @Test
    public void logFilter() {
        CommonsRequestLoggingFilter requestLoggingFilter = requestLoggingFilterConfig.logFilter();
        assertNotNull(requestLoggingFilter);
    }
}
