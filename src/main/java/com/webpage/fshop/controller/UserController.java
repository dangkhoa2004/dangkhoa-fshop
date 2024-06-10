package com.webpage.fshop.controller;

import com.webpage.fshop.model.*;
import com.webpage.fshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    public MouseRepository mouseRepo;

    @Autowired
    public BrandRepository brandRepo;

    @Autowired
    public ConnectRepository connectionRepo;

    @Autowired
    public LEDRepository ledRepo;

    @Autowired
    public TypeRepository typeRepo;

    @Autowired
    public BatteryRepository batteryRepo;

    @Autowired
    public ColorRepository colorRepo;

    @Autowired
    public FileStorageService fileStorageService;

    @Autowired
    public InvoiceRepository invoiceRepo;

    @Autowired
    public CouponRepository couponRepo;

    @Autowired
    public InvoiceMouseRepository invoicemouseRepo;

    @GetMapping("/fshop")
    public String fshop(Model model) {
        List<Mouse> lstMouse = mouseRepo.findAll();
        model.addAttribute("lstMouse", lstMouse);
        return "fshop";
    }

    @GetMapping("/category")
    public String category(Model model) {
        List<Mouse> lstMouse = this.mouseRepo.findAll();
        model.addAttribute("lstMouse", lstMouse);
        return "category";
    }

    @GetMapping("/buy/{id}")
    public String buyMouse(@PathVariable("id") int id, Model model) {
        Mouse ms = mouseRepo.findById(id).orElseThrow();
        List<Brand> brands = brandRepo.findAll();
        List<Connect> connects = connectionRepo.findAll();
        List<LED> leds = ledRepo.findAll();
        List<Type> types = typeRepo.findAll();
        List<Battery> batteries = batteryRepo.findAll();
        List<Color> colors = colorRepo.findAll();
        model.addAttribute("brands", brands);
        model.addAttribute("connects", connects);
        model.addAttribute("leds", leds);
        model.addAttribute("types", types);
        model.addAttribute("batteries", batteries);
        model.addAttribute("colors", colors);
        model.addAttribute("mouse", ms);
        return "buyMouse";
    }

    @GetMapping("/trackings")
    public String trackings(Model model) {
        return "trackings";
    }

    @GetMapping("/trackings/{id}")
    public String tracking(@PathVariable("id") int id, Model model) {
        Invoice in = invoiceRepo.findById(id).orElseThrow();
        List<DetailInvoice> inm = invoicemouseRepo.findByInvoiceId(id);
        model.addAttribute("inm", inm);
        model.addAttribute("in", in);
        return "tracking";
    }

    @GetMapping("/carts")
    public String cartMouse(Model model) {
        return "cartMouse";
    }
}
