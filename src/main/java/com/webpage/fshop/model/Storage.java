/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.model;

import jakarta.persistence.*;
import java.util.*;

/**
 *
 * @author 04dkh
 */
@Entity
@Table(name = "Storage")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    @Column(name = "name", length = 255)
    public String name;
    
    @OneToMany(mappedBy = "storage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<MouseStorage> mouseStorages;

    public Storage() {
    }

    public Storage(int id, String name, List<MouseStorage> mouseStorages) {
        this.id = id;
        this.name = name;
        this.mouseStorages = mouseStorages;
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

    public List<MouseStorage> getMouseStorages() {
        return mouseStorages;
    }

    public void setMouseStorages(List<MouseStorage> mouseStorages) {
        this.mouseStorages = mouseStorages;
    }
    
    
}
