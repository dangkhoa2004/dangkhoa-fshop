/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import jakarta.persistence.*;

/**
 *
 * @author 04dkh
 */
@Entity
@Table(name = "Mouse")
public class Mouse implements Serializable {

    @Id
    @Column(name = "id", nullable = false, length = 50)
    public String id;

    @Column(name = "name", length = 255)
    public String name;

    @Column(name = "description", length = 255)
    public String description;

    @Column(name = "price")
    public double price;

    @Column(name = "saleprice")
    public double saleprice;

    @OneToMany(mappedBy = "mouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<image_url> imageUrl;

    public Mouse() {
    }

    public Mouse(String id, String name, String description, double price, double saleprice, List<image_url> imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.saleprice = saleprice;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public List<image_url> getimage_url() {
        return imageUrl;
    }

    public void setimage_url(List<image_url> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFormattedPrice() {
        NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        return formatter.format(price) + "₫";
    }

    public String getFormattedSalePrice() {
        NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        return formatter.format(saleprice) + "₫";
    }
    
}
