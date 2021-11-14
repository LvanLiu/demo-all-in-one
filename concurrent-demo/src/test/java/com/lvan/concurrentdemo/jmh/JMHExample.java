package com.lvan.concurrentdemo.jmh;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

/**
 * @author Lvan
 * @since 2021/11/14
 */
@BenchmarkMode(Mode.All)
@Warmup(iterations = 3)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
public class JMHExample {


}
