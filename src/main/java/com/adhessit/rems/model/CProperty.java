package com.adhessit.rems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "property")
@Data
public class CProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Boolean hasCentralHeating;
    private Boolean hasCleaningMachine;
    private Boolean hasCooling;
    private Boolean hasConcierge;
    private Boolean hasElevator;
    private Boolean hasFirePlace;
    private Boolean hasGarden;
    private Boolean hasInternet;
    private Boolean hasMicrowave;
    private Boolean hasModernKitchen;
    private Boolean hasMountainView;
    private Boolean hasOven;
    private Boolean hasRefrigerator;
    private Boolean hasSatelliteDish;
    private Boolean hasSeaView;
    private Boolean hasSecurity;
    private Boolean hasSwimmingPool;
    private Boolean hasTV;
    private Boolean hasTerrace;

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
    private Date availableDate;

    @ElementCollection
    private List<String> images;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @ManyToOne
    private User user;
}
