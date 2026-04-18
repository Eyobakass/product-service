package com.eyobandbaheran.productservice.dto;

import jakarta.validation.constraints.*;

public class ProductRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private double price;

    @Min(value = 0, message = "Stock quantity cannot be negative")
    private int stockQty;

    @NotBlank(message = "Category is required")
    private String category;

    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQty() { return stockQty; }
    public String getCategory() { return category; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setStockQty(int stockQty) { this.stockQty = stockQty; }
    public void setCategory(String category) { this.category = category; }
}