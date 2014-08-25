package com.ks.sort;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ks.sort.algorithm.*;

@State(Scope.Thread)
public class SortingAlgorithmBenchmark {

    private final int LIST_SIZE = 10000;

    private List<Integer> preSortedList;
    private List<Integer> unSortedList;
    private List<Integer> randomList;


    @Setup(Level.Iteration)
    public void setup(){
        preSortedList = new ArrayList<>();
        unSortedList = new ArrayList<>();
        randomList = new ArrayList<>();

        // Create sorted list and an inversely sorted list
        for (int i = 0; i < LIST_SIZE; i++) {
            preSortedList.add(i);
            unSortedList.add(LIST_SIZE - i - 1);
        }

        // Create a list and keep creating it until it doesn't match the sorted list
        do {
            // Copy the sorted list so random elements can be added to new list
            List<Integer> temporaryList = new ArrayList<>(preSortedList);

            // While the temporary list is non-empty
            while (temporaryList.size() > 0) {
                // Get a random index
                int randomIndex = (int)(Math.random() * temporaryList.size());

                // Add the value at the random index to the random list
                randomList.add(temporaryList.get(randomIndex));

                // Remove the value from the temporary list
                temporaryList.remove(randomIndex);
            }
        } while (randomList == preSortedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public List<Integer> bubblesortPreSortedList() throws InterruptedException{
        return new Bubblesort<Integer>().sort(preSortedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public List<Integer> bubblesortUnSortedList() throws InterruptedException{
        return new Bubblesort<Integer>().sort(unSortedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public List<Integer> bubblesortRandomList() throws InterruptedException{
        return new Bubblesort<Integer>().sort(randomList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public List<Integer> quicksortPreSortedList() throws InterruptedException{
        return new Quicksort<Integer>().sort(preSortedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public List<Integer> quicksortUnSortedList() throws InterruptedException{
        return new Quicksort<Integer>().sort(unSortedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public List<Integer> quicksortRandomList() throws InterruptedException{
        return new Quicksort<Integer>().sort(randomList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public List<Integer> insertionsortPreSortedList() throws InterruptedException{
        return new Insertionsort<Integer>().sort(preSortedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public List<Integer> insertionsortUnSortedList() throws InterruptedException{
        return new Insertionsort<Integer>().sort(unSortedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public List<Integer> insertionsortRandomList() throws InterruptedException{
        return new Insertionsort<Integer>().sort(randomList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public List<Integer> selectionsortPreSortedList() throws InterruptedException{
        return new Selectionsort<Integer>().sort(preSortedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public List<Integer> selectionsortUnSortedList() throws InterruptedException{
        return new Selectionsort<Integer>().sort(unSortedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public List<Integer> selectionsortRandomList() throws InterruptedException{
        return new Selectionsort<Integer>().sort(randomList);
    }

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(".*" + SortingAlgorithmBenchmark.class.getSimpleName() + ".*")
                .warmupIterations(3)
                .measurementIterations(10)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}