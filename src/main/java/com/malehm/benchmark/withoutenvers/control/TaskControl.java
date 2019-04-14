package com.malehm.benchmark.withoutenvers.control;

import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;
import com.malehm.benchmark.withoutenvers.model.Assignee;
import com.malehm.benchmark.withoutenvers.model.Metadata;
import com.malehm.benchmark.withoutenvers.model.Task;

public class TaskControl {

  private final EntityManager em;

  public TaskControl(final EntityManager em) {
    this.em = em;
  }

  public void saveTask() {
    this.em.clear();
    this.em.getTransaction().begin();
    // TODO enabel bulk inserts
    final Task task = Task.builder().withExternalId(UUID.randomUUID()).withCurrentUser("someone")
        .withStatus("created")
        .withAssignee(List.of(Assignee.builder().withAssigne("me").build(),
            Assignee.builder().withAssigne("you").build()))
        .withMetadata(List.of(Metadata.builder().withKey("key1").withValue("value1").build(),
            Metadata.builder().withKey("key2").withValue("value2").build()))
        .build();
    this.em.persist(task);
    this.em.getTransaction().commit();
  }

}
