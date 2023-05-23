package com.nomise.inventory.dao;

import com.nomise.inventory.entities.Product;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface FilterDao {

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO products (external_id, name, description, price, rating, offer_id, no_of_ratings, img, stock, user_id, product_category, filter_type, created_at, updated_at, created_by, updated_by) VALUES (:a.externalId, :a.name, :a.description, :a.price, :a.rating, :a.offerId, :a.noOfRatings, :a.img, :a.stock, :a.userId, :a.productCategory, :a.filterType, :a.createdAt, :a.updatedAt, :a.createdBy, :a.updatedBy)")
    Long insert(@BindBean("a") Product product);

}
