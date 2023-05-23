package com.nomise.inventory.creator.product;

import com.nomise.inventory.entities.Product;
import com.nomise.inventory.exception.InventoryException;
import com.nomise.inventory.service.ProductService;

import java.util.List;
import java.util.Optional;

public class DefaultProductManager implements ProductManager {

    private ProductService productService;

    @Override
    public void validateProduct(Product product){
        Optional<Product> duplicateProduct = productService.getProductByExternalId(product.getExternalId());
        duplicateProduct.orElseThrow(throw InventoryException.VALIDATION_ERROR);
    }

    @Override
    public createOrUpdate(Product product){

    }

    @Override
    public List<Product> getProductsToShow(ProductShowStrategy ps, String filter){
        return ps.getProductsToShow(filter);
    }

    @Override
    public String getLockKey(Product p){

    }

    @Override
    public getDuplicateProduct(Product product){

    }
}
