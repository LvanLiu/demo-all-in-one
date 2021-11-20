package com.lvan.promethuesdemo.service.impl;

import com.lvan.promethuesdemo.service.ApiCountService;
import io.micrometer.core.instrument.MeterRegistry;

/**
 * @author lvan
 * @date 2021/11/17
 */
public class MicrometerApiCountServiceImpl implements ApiCountService {

    private MeterRegistry meterRegistry;

    public MicrometerApiCountServiceImpl(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public void increment(String url) {

    }

    @Override
    public void increment(String url, Class<?> exceptionClass) {

    }

    @Override
    public void increment(String url, Class<?> exceptionClass, String status) {

    }
}
