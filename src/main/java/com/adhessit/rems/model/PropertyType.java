package com.adhessit.rems.model;

public enum PropertyType {
    HOUSE("Mansion, Villa, Townhouse, House..."),
    LOT("Lot, Agricultural Parcel..."),
    FLAT("Flat"),
    COMMERCIAL("Commercial, Garage...");

    String label;

    PropertyType(String label) {
        this.label = label;
    }
}
