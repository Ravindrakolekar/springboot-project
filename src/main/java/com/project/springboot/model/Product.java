package com.project.springboot.model;

public class Product {

    private int id;
    private String ProductName;
    private double productPrize;

    public Product(int id, String productName, double productPrize) {
        this.id = id;
        ProductName = productName;
        this.productPrize = productPrize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getProductPrize() {
        return productPrize;
    }

    public void setProductPrize(double productPrize) {
        this.productPrize = productPrize;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", ProductName='" + ProductName + '\'' +
                ", productPrize=" + productPrize +
                '}';
    }
}
