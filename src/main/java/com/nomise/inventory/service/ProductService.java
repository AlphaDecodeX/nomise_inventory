package com.nomise.inventory.service;

import com.nomise.inventory.creator.product.ProductManager;
import com.nomise.inventory.dao.ProductDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductDao productDao;

    private ProductManager productManager;



}
