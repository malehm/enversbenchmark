package com.malehm.benchmark.withoutenvers.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import org.hibernate.envers.Audited;

@Entity
@Audited
public class Task {

  @Id
  @GeneratedValue
  private long id;
  @Version
  private LocalDateTime version;
  private UUID externalId;
  private String currentUser;
  private String status;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
  private List<Metadata> metadata = new ArrayList<>();
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
  private List<Assignee> assignee = new ArrayList<>();

  @Generated("SparkTools")
  private Task(final Builder builder) {
    this.id = builder.id;
    this.version = builder.version;
    this.externalId = builder.externalId;
    this.setCurrentUser(builder.currentUser);
    this.status = builder.status;
    this.metadata = builder.metadata;
    this.assignee = builder.assignee;
  }

  public Task() {}

  public long getId() {
    return this.id;
  }

  public void setId(final long id) {
    this.id = id;
  }

  public String getCurrentUser() {
    return this.currentUser;
  }

  public void setCurrentUser(final String currentUser) {
    this.currentUser = currentUser;
  }

  public List<Metadata> getMetadata() {
    return this.metadata;
  }

  public void setMetadata(final List<Metadata> metadata) {
    this.metadata = metadata;
  }

  public List<Assignee> getAssignee() {
    return this.assignee;
  }

  public void setAssignee(final List<Assignee> assignee) {
    this.assignee = assignee;
  }

  /**
   * Creates builder to build {@link Task}.
   *
   * @return created builder
   */
  @Generated("SparkTools")
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Task}.
   */
  @Generated("SparkTools")
  public static final class Builder {
    private long id;
    private LocalDateTime version;
    private UUID externalId;
    private String currentUser;
    private String status;
    private List<Metadata> metadata = Collections.emptyList();
    private List<Assignee> assignee = Collections.emptyList();

    private Builder() {}

    public Builder withId(final long id) {
      this.id = id;
      return this;
    }

    public Builder withVersion(final LocalDateTime version) {
      this.version = version;
      return this;
    }

    public Builder withExternalId(final UUID externalId) {
      this.externalId = externalId;
      return this;
    }

    public Builder withCurrentUser(final String currentUser) {
      this.currentUser = currentUser;
      return this;
    }

    public Builder withStatus(final String status) {
      this.status = status;
      return this;
    }

    public Builder withMetadata(final List<Metadata> metadata) {
      this.metadata = metadata;
      return this;
    }

    public Builder withAssignee(final List<Assignee> assignee) {
      this.assignee = assignee;
      return this;
    }

    public Task build() {
      return new Task(this);
    }
  }

}
