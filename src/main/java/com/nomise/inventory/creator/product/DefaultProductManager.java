package com.nomise.inventory.creator.product;

import com.nomise.inventory.entities.Product;
import com.nomise.inventory.exception.InventoryException;
import com.nomise.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultProductManager implements ProductManager {

    private ProductRepository productRepository;

    @Autowired
    public DefaultProductManager(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void validateProduct(Product product) throws RuntimeException{
        Optional<Product> duplicateProduct = productRepository.getProductByExternalId(product.getExternalId());
        duplicateProduct.orElseThrow(InventoryException.VALIDATION_ERROR::getException);
    }

    @Override
    public Optional<Product> createOrUpdate(Product product){
        try{
            validateProduct(product);
            return productRepository.update(product);
        }catch(Exception ex){
            if(ex.equals(InventoryException.VALIDATION_ERROR.getException())){
                return productRepository.insert(product);

            }
        }
        return Optional.empty();
    }

    @Override
    public List<Product> getProductsToShowOnHomepage(ProductShowStrategy ps, String filter){
        return ps.getProductsToShow(filter);
    }

}
