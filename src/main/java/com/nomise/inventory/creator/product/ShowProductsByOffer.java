package com.nomise.inventory.creator.product;

import com.nomise.inventory.creator.product.ProductShowStrategy;
import com.nomise.inventory.entities.Product;
import com.nomise.inventory.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ShowProductsByOffer implements ProductShowStrategy {

    private ProductService productService;

    @Override
    public List<Product> getProductsToShow(String offerId){
        return productService
    }
}
