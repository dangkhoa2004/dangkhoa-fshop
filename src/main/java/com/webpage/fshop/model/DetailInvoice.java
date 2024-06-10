/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author 04dkh
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DetailInvoice")
public class DetailInvoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
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

}
