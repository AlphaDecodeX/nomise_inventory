package com.nomise.inventory.creator.product;

import com.nomise.inventory.entities.Product;

import java.util.List;

public interface ProductManager {

    void validateProduct(Product product);

    void createOrUpdate(Product product);

    List<Product> getProductsToShowOnHomepage(ProductShowStrategy productShowStrategy);

    String getLockKey(Product p);

    Product getDuplicateProduct(Product product);

}
