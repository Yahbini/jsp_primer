package com.demo.entity;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String photo;
    private Date created;
    private double price;
    private int quantity;
    private boolean status;

    public Product() {
    }

    public Product(int id, String name, String photo, Date created, double price, int quantity, boolean status) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.created = created;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
