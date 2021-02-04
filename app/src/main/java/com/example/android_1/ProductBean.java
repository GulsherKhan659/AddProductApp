package com.example.android_1;

public class ProductBean {

    private String name;
    private int quantity;
    private String catogery;
    private String company;
    private String expiry;


    public  ProductBean(){}
    public ProductBean(String name, int quantity, String catogery, String company, String expiry) {
        this.name = name;
        this.quantity = quantity;
        this.catogery = catogery;
        this.company = company;
        this.expiry = expiry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCatogery() {
        return catogery;
    }

    public void setCatogery(String catogery) {
        this.catogery = catogery;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
}
