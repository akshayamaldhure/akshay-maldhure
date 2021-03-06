package models.entities;

import lombok.Getter;

import java.util.List;

@Getter
public class Category {
    private String id;
    private String name;
    private String createdAt;
    private String updatedAt;
    private List<SubCategory> subCategories;
    private List<SubCategory> categoryPath;
}
