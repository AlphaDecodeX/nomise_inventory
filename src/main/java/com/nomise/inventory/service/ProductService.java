package com.nomise.inventory.service;

import com.nomise.inventory.creator.product.ProductManager;
import com.nomise.inventory.dao.ProductDao;
import com.nomise.inventory.entities.Product;
import com.nomise.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductDao productDao;

    private ProductManager productManager;

    private ProductRepository productRepository;

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

    public Optional<Product> updateProduct(Product product){
        return productRepository.update(product);
    }

}
