package com.nomise.inventory.service;

import com.nomise.inventory.creator.product.ProductManager;
import com.nomise.inventory.dao.ProductDao;
import com.nomise.inventory.entities.Product;
import com.nomise.inventory.enums.FilterType;
import com.nomise.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Component
public class ProductService {

    private ProductRepository productRepository;

    private ProductManager productManager;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductManager productManager){
        this.productRepository = productRepository;
        this.productManager = productManager;
    }

    public List<Product> getProducts(){
        return productRepository.getProducts();
    }

    public List<Product> getProductsByOfferId(String offerId){
        return productRepository.getProductsByOfferId(offerId);
    }

    public List<Product> getProductsByCategory(String category){
        return productRepository.getProductByCategory(category);
    }

    public Optional<Product> getProductByExternalId(String externalId){
        return productRepository.getProductByExternalId(externalId);
    }

    public List<Product> getProductByFilterType(String filterType){
        return productRepository.getProductByFilterType(filterType);
    }

    public Optional<Product> updateProduct(Product product){
        return productRepository.update(product);
    }

    public Optional<Product> insertProduct(Product product){
        return productManager.createOrUpdate(product);
    }

}
