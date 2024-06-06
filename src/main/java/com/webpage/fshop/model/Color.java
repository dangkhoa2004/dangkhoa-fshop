/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 04dkh
 */
@Entity
@Table(name = "Color")
public class Color implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "name", length = 255)
    public String name;

    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Mouse> mice;

    public Color() {
    }

    public Color(int id, String name, List<Mouse> mice) {
        this.id = id;
        this.name = name;
        this.mice = mice;
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

    public List<Mouse> getMice() {
        return mice;
    }

    public void setMice(List<Mouse> mice) {
        this.mice = mice;
    }

}
