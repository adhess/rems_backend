package com.adhessit.rems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "property")
@Data
public class CProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Boolean isCentralHeating;
    private Boolean isCleaningMachine;
    private Boolean isClimatisation;
    private Boolean isConcierge;
    private Boolean isElevator;
    private Boolean isFirePlace;
    private Boolean isGarden;
    private Boolean isInternet;
    private Boolean isMicrowave;
    private Boolean isModernKitchen;
    private Boolean isMountainView;
    private Boolean isOven;
    private Boolean isRefrigerator;
    private Boolean isSatelliteDish;
    private Boolean isSeaView;
    private Boolean isSecurity;
    private Boolean isSwimmingPool;
    private Boolean isTV;
    private Boolean isTerrace;

    private double latitude;
    private double longitude;


    private FormType formType;
    private PropertyType propertyType;
    private int nbBathrooms;
    private int nbBedrooms;
    private int nbFloors;
    private int price;
    @Max(value = 250)
    @Min(value = 0)
    private int age;
    private int area;

    @ElementCollection
    private List<String> images;

    @Override
    public String toString() {
        return "CProperty{" +
                "id=" + id +
                ", age=" + age +
                ", area=" + area +
                ", formType=" + formType +
                ", isCentralHeating=" + isCentralHeating +
                ", isCleaningMachine=" + isCleaningMachine +
                ", isClimatisation=" + isClimatisation +
                ", isConcierge=" + isConcierge +
                ", isElevator=" + isElevator +
                ", isFirePlace=" + isFirePlace +
                ", isGarden=" + isGarden +
                ", isInternet=" + isInternet +
                ", isMicrowave=" + isMicrowave +
                ", isModernKitchen=" + isModernKitchen +
                ", isMountainView=" + isMountainView +
                ", isOven=" + isOven +
                ", isRefrigerator=" + isRefrigerator +
                ", isSatelliteDish=" + isSatelliteDish +
                ", isSeaView=" + isSeaView +
                ", isSecurity=" + isSecurity +
                ", isSwimmingPool=" + isSwimmingPool +
                ", isTV=" + isTV +
                ", isTerrace=" + isTerrace +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", nbBathrooms=" + nbBathrooms +
                ", nbBedrooms=" + nbBedrooms +
                ", nbFloors=" + nbFloors +
                ", price=" + price +
                ", propertyType=" + propertyType +
                ", images=" + images +
                '}';
    }
}
