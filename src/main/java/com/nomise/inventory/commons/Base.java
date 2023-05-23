package com.nomise.inventory.commons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Base {
    @JsonIgnore
    private Long id;

    private String externalId;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    private String createdBy;

    private String updatedBy;

    private static final String ADMIN = "admin";

    public void prePersist() {
        final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.createdAt = timestamp;
        this.updatedAt = timestamp;
        this.createdBy = ADMIN;
        this.updatedBy = ADMIN;
        if (Strings.isNullOrEmpty(this.externalId)) {
            this.externalId = UUID.randomUUID().toString();
        }
    }

    public void preUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
        this.updatedBy = ADMIN;
        if (Strings.isNullOrEmpty(this.externalId)) {
            this.externalId = UUID.randomUUID().toString();
        }
    }
}

