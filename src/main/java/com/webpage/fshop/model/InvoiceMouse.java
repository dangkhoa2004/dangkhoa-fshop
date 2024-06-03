/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 *
 * @author 04dkh
 */
@Entity
@Table(name = "invoiceMouse")
public class InvoiceMouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    public Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "mouse_id")
    public Mouse mouse;

    @Column(name = "quantity")
    public int quantity;

    @Column(name = "money")
    public BigDecimal money;

    @Column(name = "total")
    public BigDecimal total;

    public InvoiceMouse() {
    }

    public InvoiceMouse(int id, Invoice invoice, Mouse mouse, int quantity, BigDecimal money, BigDecimal total) {
        this.id = id;
        this.invoice = invoice;
        this.mouse = mouse;
        this.quantity = quantity;
        this.money = money;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
