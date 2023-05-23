package com.nomise.inventory.dao;

import com.nomise.inventory.entities.Product;
import com.nomise.inventory.enums.ProductCategory;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;


public interface ProductDao {

    @SqlQuery("SELECT id, created_at, created_by, updated_by, name, description, price, rating, offer_id, no_of_ratings, img, stock, user_id, product_category, filter_type FROM products WHERE external_id = :external_id")
    @RegisterBeanMapper(Product.class)
    Product getByExternalId(@Bind("external_id") final String externalId);

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO products (external_id, name, description, price, rating, offer_id, no_of_ratings, img, stock, user_id, product_category, filter_type, created_at, updated_at, created_by, updated_by) VALUES (:a.externalId, :a.name, :a.description, :a.price, :a.rating, :a.offerId, :a.noOfRatings, :a.img, :a.stock, :a.userId, :a.productCategory, :a.filterType, :a.createdAt, :a.updatedAt, :a.createdBy, :a.updatedBy)")
    Long insert(@BindBean("a") Product product);

    @SqlUpdate("UPDATE products SET created_at = :a.createdAt, created_by = :a.createdBy, updated_at = :a.updatedAt, updated_by = :a.updatedBy, name = :a.name, description = :a.description, price = :a.price, rating = :a.rating, offer_id = :a.offerId, no_of_ratings = :a.noOfRatings, img = :a.img, stock = :a.stock, user_id = :a.userId, product_category = :a.productCategory, filter_type = :a.filterType WHERE external_id = :a.externalId")
    void update(@BindBean("a") Product product);

    @SqlQuery("SELECT id, created_at, created_by, updated_by, external_id, name, description, price, rating, offer_id, no_of_ratings, img, stock, user_id, product_category, filter_type FROM products")
    List<Product> getProducts();

    @SqlQuery("SELECT id, created_at, created_by, updated_by, external_id, name, description, price, rating, offer_id, no_of_ratings, img, stock, user_id, product_category, filter_type FROM products WHERE product_category = :pc")
    List<Product> getProductByCategory(@Bind("pc") String pc);

    @SqlQuery("SELECT id, created_at, created_by, updated_by, external_id, name, description, price, rating, offer_id, no_of_ratings, img, stock, user_id, product_category, filter_type FROM products WHERE offer_id = :offerId")
    List<Product> getProductByOfferId(@Bind("offerId") String offerId);

}