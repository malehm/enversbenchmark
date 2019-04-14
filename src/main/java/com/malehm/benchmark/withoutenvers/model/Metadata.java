package com.malehm.benchmark.withoutenvers.model;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class Metadata {

  @Id
  @GeneratedValue
  private long id;
  @ManyToOne
  @JoinColumn(name = "taskId", nullable = false)
  private Task task;
  private String key;
  private String value;

  @Generated("SparkTools")
  private Metadata(final Builder builder) {
    this.id = builder.id;
    this.task = builder.task;
    this.key = builder.key;
    this.value = builder.value;
  }

  public Metadata() {}

  /**
   * Creates builder to build {@link Metadata}.
   *
   * @return created builder
   */
  @Generated("SparkTools")
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Metadata}.
   */
  @Generated("SparkTools")
  public static final class Builder {
    private long id;
    private Task task;
    private String key;
    private String value;

    private Builder() {}

    public Builder withId(final long id) {
      this.id = id;
      return this;
    }

    public Builder withTask(final Task task) {
      this.task = task;
      return this;
    }

    public Builder withKey(final String key) {
      this.key = key;
      return this;
    }

    public Builder withValue(final String value) {
      this.value = value;
      return this;
    }

    public Metadata build() {
      return new Metadata(this);
    }
  }

}
