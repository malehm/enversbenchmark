package com.malehm.benchmark.withoutenvers.model;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class Assignee {

  @Id
  @GeneratedValue
  private long id;
  @ManyToOne
  @JoinColumn(name = "taskId", nullable = false)
  private Task task;
  private String assigne;

  @Generated("SparkTools")
  private Assignee(final Builder builder) {
    this.id = builder.id;
    this.task = builder.task;
    this.assigne = builder.assigne;
  }

  public Assignee() {}

  /**
   * Creates builder to build {@link Assignee}.
   *
   * @return created builder
   */
  @Generated("SparkTools")
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Assignee}.
   */
  @Generated("SparkTools")
  public static final class Builder {
    private long id;
    private Task task;
    private String assigne;

    private Builder() {}

    public Builder withId(final long id) {
      this.id = id;
      return this;
    }

    public Builder withTask(final Task task) {
      this.task = task;
      return this;
    }

    public Builder withAssigne(final String assigne) {
      this.assigne = assigne;
      return this;
    }

    public Assignee build() {
      return new Assignee(this);
    }
  }

}
