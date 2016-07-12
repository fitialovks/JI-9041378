package ru.yandex.javacannprocessorbug;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

/**
 * Sample benchmark that relies on {@link org.openjdk.jmh.generators.BenchmarkProcessor}
 *
 * @author fitialovks
 */
public class SomeBenchmark {
    @Benchmark
    public void sqrt(Blackhole blackhole) {
        blackhole.consume(Math.sqrt(10.0));
    }
}
