package com.malehm.benchmark.withoutenvers.model;

import java.util.Map;

public class EnversBenchmark extends BenchmarkBase {

  public EnversBenchmark() {
    super(Map.of("hibernate.integration.envers.enabled", "true"));
  }

}
