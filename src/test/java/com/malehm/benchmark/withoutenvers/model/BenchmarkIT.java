package com.malehm.benchmark.withoutenvers.model;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkIT {

  @Test
  public void test() throws RunnerException {
    final Options options = new OptionsBuilder().include(".*Benchmark").forks(1).build();
    new Runner(options).run();
  }

}
