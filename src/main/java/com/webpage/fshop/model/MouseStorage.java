/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.model;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author 04dkh
 */
@Entity
@Table(name = "MouseStorage")
public class MouseStorage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "mouse_id")
    public Mouse mouse;

    @ManyToOne
    @JoinColumn(name = "storage_id")
    public Storage storage;

    @Column(name = "quantity")
    public int quantity;

    public MouseStorage() {
    }

    public MouseStorage(int id, Mouse mouse, Storage storage, int quantity) {
        this.id = id;
        this.mouse = mouse;
        this.storage = storage;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
