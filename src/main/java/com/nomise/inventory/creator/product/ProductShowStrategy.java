package com.nomise.inventory.creator.product;

import com.nomise.inventory.creator.filter.FilterType;
import com.nomise.inventory.entities.Product;

import java.util.List;

public interface ProductShowStrategy {
    List<Product> getProductsToShow(String filter);

    FilterType getFilterType();
}
