package models.entities;

import lombok.Getter;

@Getter
public class Store {
    private String name;
    private String type;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private float lat;
    private float lng;
    private String hours;
    private Object services;
}