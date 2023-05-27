package com.nomise.inventory.resource;

import com.nomise.inventory.entities.Product;
import com.nomise.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory/v1")
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{offerId}")
    public List<Product> getProductsByOfferId(@PathVariable String offerId) {
        return productService.getProductsByOfferId(offerId);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/external/{externalId}")
    public Optional<Product> getProductByExternalId(@PathVariable String externalId) {
        return productService.getProductByExternalId(externalId);
    }

    @PutMapping
    public Optional<Product> updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

}
