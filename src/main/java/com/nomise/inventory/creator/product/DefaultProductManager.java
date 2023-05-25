package com.nomise.inventory.creator.product;

import com.nomise.inventory.entities.Product;
import com.nomise.inventory.exception.InventoryException;
import com.nomise.inventory.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class DefaultProductManager implements ProductManager {

    private ProductRepository productRepository;

    @Override
    public void validateProduct(Product product) throws RuntimeException{
        Optional<Product> duplicateProduct = productRepository.getProductByExternalId(product.getExternalId());
        duplicateProduct.orElseThrow(InventoryException.VALIDATION_ERROR::getException);
    }

    @Override
    public void createOrUpdate(Product product){
        try{
            validateProduct(product);
            productRepository.insert(product);
        }catch(Exception ex){
            if(ex.equals(InventoryException.VALIDATION_ERROR.getException())){
                productRepository.update(product);
            }
        }
    }

    @Override
    public List<Product> getProductsToShowOnHomepage(ProductShowStrategy ps, String filter){
        return ps.getProductsToShow(filter);
    }

}
