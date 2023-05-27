package com.nomise.inventory.creator.product;

import com.nomise.inventory.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductManager {

    void validateProduct(Product product);

    Optional<Product> createOrUpdate(Product product);

    List<Product> getProductsToShowOnHomepage(ProductShowStrategy productShowStrategy, String filter);

}
