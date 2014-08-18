package com.ks.hashmap;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.ks.hashmap.basic.*;

@State(Scope.Thread)
public class HashMapBenchmark {

    private final int LENGTH = 10000;
    private HashFunction basicHashFunction = new BasicHashFunction();
    private com.ks.hashmap.HashMap<String, Long> basicHashMap = new BasicHashMap<>(basicHashFunction, LENGTH);
    private HashMap<String, Long> hashMap = new HashMap<>();
    private long key;

    @Setup(Level.Iteration)
    public void setup(){
        key = 0;

        for (long i = 0; i < LENGTH; i++) {
            hashMap.put(String.valueOf(i), i);
            basicHashMap.put(String.valueOf(i), i);
        }
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public long collectionsHashMapGetExistingKeys() throws InterruptedException{

        if (key >= LENGTH) {
            key = 0;
        }

        return hashMap.get(String.valueOf(key++));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public long basicHashMapGetExistingKeys() throws InterruptedException{

        if(key >= LENGTH) {
            key = 0;
        }

        return basicHashMap.get(String.valueOf(key++));
    }


    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(".*" + HashMapBenchmark.class.getSimpleName() + ".*")
                .warmupIterations(5)
                .measurementIterations(25)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}