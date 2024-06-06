/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.repository;

import com.webpage.fshop.model.DetailInvoice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 04dkh
 */
@Repository
public interface InvoiceMouseRepository extends JpaRepository<DetailInvoice, Integer> {

    @Query("SELECT im FROM DetailInvoice im WHERE im.invoice.id = :invoice_id")
    List<DetailInvoice> findByInvoiceId(@Param("invoice_id") int invoice_id);
}
