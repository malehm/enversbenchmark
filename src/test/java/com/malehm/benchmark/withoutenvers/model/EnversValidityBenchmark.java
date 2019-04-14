package com.malehm.benchmark.withoutenvers.model;

import java.util.Map;

public class EnversValidityBenchmark extends BenchmarkBase {

  public EnversValidityBenchmark() {
    super(Map.of("hibernate.integration.envers.enabled", "true",
        "org.hibernate.envers.audit_strategy",
        "org.hibernate.envers.strategy.ValidityAuditStrategy"));
  }

}
