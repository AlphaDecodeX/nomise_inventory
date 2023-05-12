package com.nomise.inventory.creator.product;

import com.nomise.inventory.entities.Product;

import java.util.List;

public interface ProductManager {

    void validateProduct(Product productRequest);

    void createOrUpdate(Product product);

    List<Product> getProductsToShow(ProductShowStrategy productShowStrategy);

    String getLockKey(Product p);

}
