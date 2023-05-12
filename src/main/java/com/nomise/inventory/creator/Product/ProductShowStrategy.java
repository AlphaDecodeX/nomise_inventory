package com.nomise.inventory.creator.Product;

import com.nomise.inventory.entities.Product;

import java.util.List;

public interface ProductShowStrategy {
    List<Product> getProductsToShow(String filter);
}
