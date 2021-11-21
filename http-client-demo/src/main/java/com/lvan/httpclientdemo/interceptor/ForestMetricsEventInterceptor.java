package com.lvan.httpclientdemo.interceptor;

import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.AutoTimer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Lvan
 * @since 2021/11/21
 */
@Slf4j
@Component
public class ForestMetricsEventInterceptor<T> implements Interceptor<T> {

    private static final String ATTRIBUTE_START_TIME = "startTime";
    private static final String METRIC_NAME = "forest.request";
    @Autowired
    private MeterRegistry meterRegistry;

    @Override
    public boolean beforeExecute(ForestRequest request) {

        addAttribute(request, ATTRIBUTE_START_TIME, System.nanoTime());
        return true;
    }

    @Override
    public void onSuccess(T data, ForestRequest request, ForestResponse response) {
        timerRecord(request, response);
    }

    @Override
    public void onError(ForestRuntimeException ex, ForestRequest request, ForestResponse response) {
        timerRecord(request, response);
    }

    /**
     * 指标记录。
     */
    @SuppressWarnings("rawtypes")
    private void timerRecord(ForestRequest request, ForestResponse response) {

        long startTime = getAttribute(request, ATTRIBUTE_START_TIME, long.class);
        getTimerBuilder(request, response)
                .register(meterRegistry)
                .record(System.nanoTime() - startTime, TimeUnit.NANOSECONDS);
    }

    @SuppressWarnings("rawtypes")
    private Timer.Builder getTimerBuilder(ForestRequest request, ForestResponse response) {

        return AutoTimer.ENABLED.builder(METRIC_NAME)
                .tags(getTag(request, response))
                .description("Timer of Forest");
    }

    @SuppressWarnings("rawtypes")
    private Tags getTag(ForestRequest request, ForestResponse response) {

        Tags tags = Tags.of("method", request.getMethod().getMethodName())
                .and("uri", request.getURI().toString())
                .and("host", request.getURI().getHost())
                .and("status", String.valueOf(response.getStatusCode()));

        if (null != response.getException()) {
            tags = tags.and("exception", response.getException().getClass().getSimpleName());
        }
        return tags;
    }
}
