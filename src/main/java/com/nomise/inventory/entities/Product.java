package com.nomise.inventory.entities;

import com.nomise.inventory.commons.Base;
import com.nomise.inventory.enums.FilterType;
import com.nomise.inventory.enums.ProductCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends Base {

    private String name;

    private String description;

    private long price;

    private int rating;

    private String offerId;

    private long noOfRatings;

    private String img;

    private long stock;

    private String userId;

    private ProductCategory productCategory;

    private FilterType filterType;

}
