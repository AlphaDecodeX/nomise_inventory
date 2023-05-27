package com.nomise.inventory.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nomise.inventory.commons.Base;
import com.nomise.inventory.enums.FilterType;
import com.nomise.inventory.enums.ProductCategory;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
