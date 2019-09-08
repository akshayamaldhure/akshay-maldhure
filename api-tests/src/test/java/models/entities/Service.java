package models.entities;

import lombok.Getter;

@Getter
public class Service {
    private int id;
    private String name;
    private String createdAt;
    private String updatedAt;
    private StoreServices storeservices;
}
