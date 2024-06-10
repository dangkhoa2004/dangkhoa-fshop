/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.controller;

import com.webpage.fshop.config.SecurityManager;
import com.webpage.fshop.model.Account;
import com.webpage.fshop.model.Battery;
import com.webpage.fshop.model.Brand;
import com.webpage.fshop.model.Color;
import com.webpage.fshop.model.Connect;
import com.webpage.fshop.model.Imageurl;
import com.webpage.fshop.model.Invoice;
import com.webpage.fshop.model.LED;
import com.webpage.fshop.model.Mouse;
import com.webpage.fshop.model.Type;
import com.webpage.fshop.repository.AccountRepository;
import com.webpage.fshop.repository.BatteryRepository;
import com.webpage.fshop.repository.BrandRepository;
import com.webpage.fshop.repository.ColorRepository;
import com.webpage.fshop.repository.ConnectRepository;
import com.webpage.fshop.repository.CouponRepository;
import com.webpage.fshop.repository.FileStorageService;
import com.webpage.fshop.repository.InvoiceMouseRepository;
import com.webpage.fshop.repository.InvoiceRepository;
import com.webpage.fshop.repository.LEDRepository;
import com.webpage.fshop.repository.MouseRepository;
import com.webpage.fshop.repository.TypeRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 04dkh
 */

@Controller
public class StaffController {

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
    public AccountRepository accountRepo;

    @Autowired
    public InvoiceMouseRepository invoicemouseRepo;

    Account account = null;

    @GetMapping("/dashboard")
    public String dashboard() {
//        if (SessionManager.isUser()) {
//            return "redirect:/login";
//        }
        return "dashboard";
    }

    @GetMapping("/mouses")
    public String listMouse(Model model) {
        if (SecurityManager.isUser()) {
            return "redirect:/login";
        }
        List<Mouse> lstMouse = mouseRepo.findAll();
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
        model.addAttribute("lstMouse", lstMouse);
        return "listMouse";
    }

    @GetMapping("/invoices")
    public String listInvoice(Model model) {
        if (SecurityManager.isUser()) {
            return "redirect:/login";
        }
        List<Invoice> lstInvoice = invoiceRepo.findAll();
        model.addAttribute("lstInvoice", lstInvoice);
        return "listInvoice";
    }

    @GetMapping("/mouses/{id}")
    public String editMouse(@PathVariable("id") int id, Model model) {
        if (SecurityManager.isUser()) {
            return "redirect:/login";
        }
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
        return "editMouse";
    }

    @PostMapping("/update/{id}")
    public String updateMouse(@PathVariable("id") int id, @ModelAttribute Mouse ms) {
        if (SecurityManager.isUser()) {
            return "redirect:/login";
        }
        Mouse existMouse = mouseRepo.findById(id).orElseThrow();
        existMouse.setName(ms.getName());
        existMouse.setDescription(ms.getDescription());
        existMouse.setPrice(ms.getPrice());
        existMouse.setSaleprice(ms.getSaleprice());
        existMouse.setBrand(ms.getBrand());
        existMouse.setConnect(ms.getConnect());
        existMouse.setLed(ms.getLed());
        existMouse.setType(ms.getType());
        existMouse.setBattery(ms.getBattery());
        existMouse.setColor(ms.getColor());
        mouseRepo.save(existMouse);
        return "redirect:/mouses";
    }

    @GetMapping("/mouses/add")
    public String addMouse(Model model) {
        if (SecurityManager.isUser()) {
            return "redirect:/login";
        }
        Mouse mouse = new Mouse();
        model.addAttribute("mouse", mouse);
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
        return "addMouse";
    }

    @PostMapping("/store")
    public String storeMouse(Mouse ms, @RequestParam("images") List<MultipartFile> images) {
        if (SecurityManager.isUser()) {
            return "redirect:/login";
        }
        try {
            Mouse savedMouse = this.mouseRepo.save(ms);
            List<Imageurl> imageUrls = new ArrayList<>();
            String folderName = String.valueOf(savedMouse.getId());
            for (MultipartFile image : images) {
                try {
                    fileStorageService.saveFile(image, folderName);
                    Imageurl imageUrl = new Imageurl();
                    imageUrl.setUrl(folderName + "/" + image.getOriginalFilename());
                    imageUrl.setMouse(savedMouse);
                    imageUrls.add(imageUrl);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            savedMouse.setImageUrl(imageUrls);
            this.mouseRepo.save(savedMouse);

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/mouses";
    }

    @GetMapping("delete/{id}")
    public String deleteMouse(@PathVariable("id") int id) {
        if (SecurityManager.isUser()) {
            return "redirect:/login";
        }
        this.mouseRepo.deleteById(id);
        return "redirect:/mouses";
    }
}
