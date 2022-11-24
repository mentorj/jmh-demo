package com.javaxpert.demos.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Main  class using  JMH API to start the benchmark
 * @author deadbrain
 */
public class StartBenchmark {
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(Murmur3Benchmark.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
