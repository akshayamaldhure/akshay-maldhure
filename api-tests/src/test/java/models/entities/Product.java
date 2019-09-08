package models.entities;

import lombok.Getter;

import java.util.List;

@Getter
public class Product {
    private long id;
    private String name;
    private String type;
    private float price;
    private String upc;
    private int shipping;
    private String description;
    private String manufacturer;
    private String model;
    private String url;
    private String image;
    private String createdAt;
    private String updatedAt;
    private List<Category> categories;
}
