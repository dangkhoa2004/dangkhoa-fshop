/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

/**
 * @author 04dkh
 */
@Entity
@Table(name = "Mouse")
public class Mouse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 50)
    public int id;

    @Column(name = "name", length = 255)
    public String name;

    @Column(name = "description", length = 255)
    public String description;

    @Column(name = "price")
    public double price;

    @Column(name = "saleprice")
    public double saleprice;

    @OneToMany(mappedBy = "mouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Imageurl> imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    public Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "connect_id")
    public Connect connect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "led_id")
    public LED led;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    public Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "battery_id")
    public Battery battery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    public Color color;

    public Mouse() {
    }

    public Mouse(int id, String name, String description, double price, double saleprice, List<Imageurl> imageUrl, Brand brand, Connect connect, LED led, Type type, Battery battery, Color color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.saleprice = saleprice;
        this.imageUrl = imageUrl;
        this.brand = brand;
        this.connect = connect;
        this.led = led;
        this.type = type;
        this.battery = battery;
        this.color = color;
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

    public List<Imageurl> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<Imageurl> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Connect getConnect() {
        return connect;
    }

    public void setConnect(Connect connect) {
        this.connect = connect;
    }

    public LED getLed() {
        return led;
    }

    public void setLed(LED led) {
        this.led = led;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
