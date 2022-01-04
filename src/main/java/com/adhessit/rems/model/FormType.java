package com.adhessit.rems.model;

public enum FormType {
    RENT("rent"),
    SELL("sell");

    String label;

    FormType(String label) {
        this.label = label;
    }
}
