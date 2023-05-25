package com.nomise.inventory.creator.product;

import com.nomise.inventory.creator.filter.FilterType;
import com.nomise.inventory.creator.product.ProductShowStrategy;
import com.nomise.inventory.entities.Product;
import com.nomise.inventory.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ShowProductsByOffer implements ProductShowStrategy {

    private ProductService productService;

    @Override
    public List<Product> getProductsToShow(String offerId){
        return productService.getProductsByOfferId(offerId);
    }

    @Override
    public FilterType getFilterType() {
        return FilterType.OFFER;
    }
}
