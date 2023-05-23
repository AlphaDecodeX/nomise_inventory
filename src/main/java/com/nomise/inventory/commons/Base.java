package com.nomise.inventory.commons;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Base {
    @JsonIgnore
    private Long id;

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
    }

    public void preUpdate() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
        this.updatedBy = ADMIN;
    }
}

