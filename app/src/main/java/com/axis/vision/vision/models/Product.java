package com.axis.vision.vision.models;

/**
 * Created by new laptoop on 02/11/2017.
 */

public class Product {
    public String name;
    public String description;
    public String style;
    public int image;

    public Product(String name, String description, String style, int image) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.style = style;
    }


}
