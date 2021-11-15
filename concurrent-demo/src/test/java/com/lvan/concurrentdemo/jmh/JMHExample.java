package com.lvan.concurrentdemo.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Lvan
 * @since 2021/11/14
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
public class JMHExample {

    private final static String DATA = "DUMMY DATA";
    private List<String> arrayList;
    private List<String> linkedList;

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(JMHExample.class.getSimpleName())
                .forks(1)
                .measurementIterations(1)
                .warmupIterations(1)
                .build();
        new Runner(options).run();
    }

    @Setup(Level.Iteration)
    public void setup() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
    }

    @Benchmark
    public void addToArrayList() {
        arrayList.add(DATA);
    }

    @Benchmark
    public void addToLinkedList() {
        linkedList.add(DATA);
    }
}
