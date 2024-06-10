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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 04dkh
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
