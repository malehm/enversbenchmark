package com.malehm.benchmark.withoutenvers.model;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

// @BenchmarkMode(Mode.AverageTime)
@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 5, time = 5)
@Measurement(iterations = 10, time = 10)
public abstract class BenchmarkBase {

  private EntityManagerFactory emf;
  private EntityManager em;
  private final Map<String, String> properties;
  private long taskId;

  public BenchmarkBase(final Map<String, String> properties) {
    // TODO enabel bulk inserts
    this.properties = properties;
  }

  @Setup
  public void setup() {
    this.emf = Persistence.createEntityManagerFactory("myPU", this.properties);
    this.em = this.emf.createEntityManager();
    this.em.clear();
    this.em.getTransaction().begin();
    final Task task = Task.builder().withExternalId(UUID.randomUUID()).withCurrentUser(null)
        .withStatus("created").build();
    final List<Metadata> metaData =
        List.of(Metadata.builder().withTask(task).withKey("key1").withValue("value1").build(),
            Metadata.builder().withTask(task).withKey("key2").withValue("value2").build());
    task.setMetadata(metaData);
    this.em.persist(task);
    this.em.getTransaction().commit();
    this.taskId = task.getId();
  }

  @TearDown
  public void tearDown() {
    this.em.close();
    this.emf.close();
  }

  @Benchmark
  public void test() {
    this.em.clear();
    this.em.getTransaction().begin();
    final Task task = this.em.find(Task.class, this.taskId);
    task.setCurrentUser("someone");
    task.setAssignee(List.of(Assignee.builder().withTask(task).withAssigne("me").build(),
        Assignee.builder().withTask(task).withAssigne("you").build()));
    this.em.getTransaction().commit();
  }

}
