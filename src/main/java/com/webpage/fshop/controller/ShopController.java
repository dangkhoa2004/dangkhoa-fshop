/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.controller;

import com.webpage.fshop.model.Battery;
import com.webpage.fshop.model.Brand;
import com.webpage.fshop.model.Color;
import com.webpage.fshop.model.Connect;
import com.webpage.fshop.model.LED;
import com.webpage.fshop.model.Mouse;
import com.webpage.fshop.model.Type;
import com.webpage.fshop.repository.BatteryRepository;
import com.webpage.fshop.repository.BrandRepository;
import com.webpage.fshop.repository.ColorRepository;
import com.webpage.fshop.repository.ConnectRepository;
import com.webpage.fshop.repository.LEDRepository;
import com.webpage.fshop.repository.MouseRepository;
import com.webpage.fshop.repository.TypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 04dkh
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopController {

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

    @GetMapping("/list")
    public String staffShop(Model model) {
        List<Mouse> lstMouse = mouseRepo.findAll();
        model.addAttribute("lstMouse", lstMouse);
        return "staff/shop.html";
    }

    @GetMapping("/add")
    public String addMouse(Model model) {
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
        return "staff/add.html";
    }

    @PostMapping("/store")
    public String storeMouse(Mouse ms) {
        this.mouseRepo.save(ms);
        return "redirect:/shop/list";
    }

    @GetMapping("/edit/{id}")
    public String editMouse(@PathVariable("id") String id, Model model) {
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
        return "staff/edit.html";
    }

    @PostMapping("/update/{id}")
    public String updateMouse(@PathVariable("id") String id, @ModelAttribute Mouse ms) {
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
        return "redirect:/shop/list";
    }

    @GetMapping("delete/{id}")
    public String deleteMouse(@PathVariable("id") String id) {
        this.mouseRepo.deleteById(id);
        return "redirect:/teacher/list";
    }

}
