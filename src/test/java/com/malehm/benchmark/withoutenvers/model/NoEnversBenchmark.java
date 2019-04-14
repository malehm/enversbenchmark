package com.malehm.benchmark.withoutenvers.model;

import java.util.Map;

public class NoEnversBenchmark extends BenchmarkBase {

  public NoEnversBenchmark() {
    super(Map.of("hibernate.integration.envers.enabled", "false"));
  }

}
