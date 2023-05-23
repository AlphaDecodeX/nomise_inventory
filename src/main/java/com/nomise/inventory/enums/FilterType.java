package com.nomise.inventory.enums;

public enum FilterType {
    NORMAL_DEAL("normal_deal"),
    FESTIVAL_OFFER("festival_offer"),
    WEEKLY_DEAL("weekly_deal");

    private final String value;

    FilterType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}