package models.entities;

import lombok.Getter;

import java.util.List;

@Getter
public class Store {
    private int id;
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
    private String createdAt;
    private String updatedAt;
    private List<Service> services;
}