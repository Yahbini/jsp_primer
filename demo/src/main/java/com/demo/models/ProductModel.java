package com.demo.models;

import com.demo.entity.Product;

import java.util.Date;
import java.util.List;

public class ProductModel {
    private List<Product> productList;

    public ProductModel(List<Product> productList) {
        this.productList = productList;
    }

    public ProductModel() {
        productList = List.of(new Product(1, "tivi", "a.png", new Date(), 10, 10, true),
                new Product(2, "phone", "b.png", new Date(), 10, 10, true));
    }

    public Product findById(int id) {
        return productList.stream().filter(product -> product.getId() == id).findFirst()
                          .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<Product> findAll() {
        return productList;
    }

    public double total() {
        return productList.stream().mapToDouble(p -> p.getPrice() * p.getQuantity()).sum();
    }

    public List<Product> findByKeyword(String keyword) {
        return productList.stream().filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase())).toList();
    }

    public List<Product> findByPrice(double min, double max) {
        return productList.stream().filter(p -> p.getPrice() >= min && p.getPrice() <= max).toList();
    }
}
