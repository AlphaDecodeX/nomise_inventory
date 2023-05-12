package com.nomise.inventory.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jdbi.v3.core.Jdbi;

@AllArgsConstructor
public class ProductRepository {
    private final Jdbi jdbi;

}
