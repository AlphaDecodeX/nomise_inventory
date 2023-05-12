package com.nomise.inventory.creator.filter;

import com.google.common.collect.Maps;
import com.nomise.inventory.creator.product.ProductShowStrategy;
import com.nomise.inventory.entities.Product;

import java.util.Map;

public class FilterFactory {
    private final Map<FilterType, ProductShowStrategy> productShowStrategyMap = Maps.newHashMap();

    public ProductShowStrategy get(Product product) {
        return productShowStrategyMap.get(product.getFilterType());
    }

    public void register(ProductShowStrategy productShowStrategy) {
        productShowStrategyMap.putIfAbsent(productShowStrategy.getFilterType(), productShowStrategy);
    }
}
