/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.mifos.group.service.internal.repository;

import io.mifos.core.mariadb.util.LocalDateTimeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "ptah_group_commands")
public class GroupCommandEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "group_id", nullable = false)
  private GroupEntity group;
  @Column(name = "a_action")
  private String action;
  @Column(name = "note")
  private String note;
  @Column(name = "created_on", nullable = false)
  @Convert(converter = LocalDateTimeConverter.class)
  private LocalDateTime createdOn;
  @Column(name = "created_by", nullable = false)
  private String createdBy;

  public GroupCommandEntity() {
    super();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public GroupEntity getGroup() {
    return this.group;
  }

  public void setGroup(final GroupEntity group) {
    this.group = group;
  }

  public String getAction() {
    return this.action;
  }

  public void setAction(final String action) {
    this.action = action;
  }

  public String getNote() {
    return this.note;
  }

  public void setNote(final String note) {
    this.note = note;
  }

  public LocalDateTime getCreatedOn() {
    return this.createdOn;
  }

  public void setCreatedOn(final LocalDateTime createdOn) {
    this.createdOn = createdOn;
  }

  public String getCreatedBy() {
    return this.createdBy;
  }

  public void setCreatedBy(final String createdBy) {
    this.createdBy = createdBy;
  }
}
