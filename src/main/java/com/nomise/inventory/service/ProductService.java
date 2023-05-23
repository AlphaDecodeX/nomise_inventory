package com.nomise.inventory.service;

import com.nomise.inventory.creator.product.ProductManager;
import com.nomise.inventory.dao.ProductDao;
import com.nomise.inventory.entities.Product;
import com.nomise.inventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductDao productDao;

    private ProductManager productManager;

    private ProductRepository productRepository;

    List<Product> getProducts(){
        return productRepository.getProducts();
    }

    List<Product> getProductsByOfferId(String offerId){
        return productRepository.getProductsByOfferId(offerId);
    }

    List<Product> getProductsByCategory(String category){
        return productRepository.getProductByCategory(category);
    }

}
