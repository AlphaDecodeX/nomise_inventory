package com.nomise.inventory.repository;

import com.nomise.inventory.dao.ProductDao;
import com.nomise.inventory.entities.Product;
import lombok.AllArgsConstructor;
import org.jdbi.v3.core.Jdbi;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductRepository {
    private final Jdbi jdbi;

    public Product insert(Product product){
        long id = jdbi.withExtension(ProductDao.class, dao -> dao.insert(product));
        product.setId(id);
        return product;
    }

    public Product update(Product product) {
        product.preUpdate();
        jdbi.useExtension(ProductDao.class, dao -> dao.update(product));
        return product;
    }

    public List<Product> getProducts() {
        return jdbi.withExtension(ProductDao.class, ProductDao::getProducts);
    }

    public List<Product> getProductsByOfferId(String offerId){
        return jdbi.withExtension(ProductDao.class, dao->dao.getProductByOfferId(offerId));
    }

    public List<Product> getProductByCategory(String category){
        return jdbi.withExtension(ProductDao.class, dao -> dao.getProductByCategory(category));
    }

    public Optional<Product> getProductByExternalId(String externalId){
        return jdbi.withExtension(ProductDao.class, dao -> dao.getByExternalId(externalId));
    }

}
