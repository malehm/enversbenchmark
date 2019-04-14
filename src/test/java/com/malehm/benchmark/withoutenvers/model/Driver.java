package com.malehm.benchmark.withoutenvers.model;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class Driver extends BenchmarkBase {

  public Driver() {
    super(Map.of("hibernate.show_sql", "true", "hibernate.format_sql", "true",
        "hibernate.integration.envers.enabled", "true", "org.hibernate.envers.audit_strategy",
        "org.hibernate.envers.strategy.ValidityAuditStrategy"));
  }

  @Override
  @Test
  public void test() {
    super.setup();
    super.test();
    super.tearDown();
  }

}
