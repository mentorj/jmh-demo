package com.javaxpert.demos.benchmark;

import com.javaxpert.demos.HashGenerator;
import com.javaxpert.demos.adapters.CommonsCodecsAdapter;
import com.javaxpert.demos.adapters.GuavaCodecAdapter;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

/**
 * JMH instrumented class containing benchmarks for Murmur3 algorithms
 */
@State(Scope.Benchmark)
public class Murmur3Benchmark {
    @Param({"10","25","100"})
    private int loopsCounter;
    private HashGenerator codec;
    private List<String> inputList;


    @Setup
    public void setUp(){
        inputList = Stream.from(1).take(100).map(i -> ""+i ).toList();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    @Warmup(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
    @Measurement(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
    public void runHashing32WithGuava(Blackhole bh){
        codec = new GuavaCodecAdapter();
        inputList.forEach( s -> bh.consume(codec.generate32BitsHash(s)));
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 1)
    @Warmup(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
    @Measurement(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
    public void runHashing32WithApache(Blackhole bh){
        codec = new CommonsCodecsAdapter();
        inputList.forEach( s -> bh.consume(codec.generate32BitsHash(s)));
    }
}
