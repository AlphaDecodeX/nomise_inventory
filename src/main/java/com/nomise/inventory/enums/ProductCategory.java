package com.nomise.inventory.enums;

public enum ProductCategory {
    ELECTRONICS("electronics"),
    FOOD("food"),
    TOYS("toys"),
    CLOTHES("clothes");

    private String value;

    ProductCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
