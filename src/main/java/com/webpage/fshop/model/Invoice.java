/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.*;

/**
 *
 * @author 04dkh
 */
@Entity
@Table(name = "Invoice")
@NamedEntityGraph(name = "Invoice.invoiceMice",
        attributeNodes = @NamedAttributeNode("invoiceMice"))
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "time_create")
    public Time timeCreate;

    @Column(name = "date_create")
    public Date dateCreate;

    @Column(name = "total")
    public double total;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    public Coupon coupon;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<InvoiceMouse> invoiceMice;

    public Invoice() {
    }

    public Invoice(int id, Time timeCreate, Date dateCreate, double total, Coupon coupon, List<InvoiceMouse> invoiceMice) {
        this.id = id;
        this.timeCreate = timeCreate;
        this.dateCreate = dateCreate;
        this.total = total;
        this.coupon = coupon;
        this.invoiceMice = invoiceMice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Time timeCreate) {
        this.timeCreate = timeCreate;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public List<InvoiceMouse> getInvoiceMice() {
        return invoiceMice;
    }

    public void setInvoiceMice(List<InvoiceMouse> invoiceMice) {
        this.invoiceMice = invoiceMice;
    }

}
