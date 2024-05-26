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
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 04dkh
 */
@Controller
@RequestMapping(value = "/fshop")
public class FShopController {

    @Autowired
    private MouseRepository mouseRepo;
    @Autowired
    private BrandRepository brandRepo;

    @Autowired
    private ConnectRepository connectionRepo;

    @Autowired
    private LEDRepository ledRepo;

    @Autowired
    private TypeRepository typeRepo;

    @Autowired
    private BatteryRepository batteryRepo;

    @Autowired
    private ColorRepository colorRepo;

    @GetMapping("/view")
    public String main(Model model) {
        List<Mouse> lstMouse = mouseRepo.findAll();
        model.addAttribute("lstMouse", lstMouse);
        return "home/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login/index";
    }

    @GetMapping("/mouse/buy/{idMouse}")
    public String buyMouse(@PathVariable("idMouse") String idMouse, Model model) {
        Optional<Mouse> optionalMouse = this.mouseRepo.findById(idMouse);
        if (optionalMouse.isPresent()) {
            Mouse mouse = optionalMouse.get();
            model.addAttribute("mouse", mouse);
            return "buy/index";
        } else {
            return "home/index";
        }
    }

    @GetMapping("/category")
    public String category(Model model) {
        List<Mouse> lstMouse = this.mouseRepo.findAll();
        model.addAttribute("lstMouse", lstMouse);
        return "home/category";
    }

    @GetMapping("/staff")
    public String staff(Model model) {
        return "staff/index";
    }

    @GetMapping("/staff/shop")
    public String staffShop(Model model) {
        List<Mouse> lstMouse = mouseRepo.findAll();
        model.addAttribute("lstMouse", lstMouse);
        return "staff/shop";
    }

    @GetMapping("/staff/shop/add")
    public String viewAdd(Model model) {
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

    @PostMapping("/staff/shop/store")
    public String addItem(Model model, @Valid Mouse ms, BindingResult validateResult) {
        if (validateResult.hasErrors()) {
            List<FieldError> listError = validateResult.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError fe : listError) {
                errors.put(fe.getField(), fe.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            model.addAttribute("mouse", ms);
            return "staff/add.html";
        }
        System.out.println(ms.id);
        System.out.println(ms.name);
        this.mouseRepo.save(ms);
        return "redirect:/staff/shop";
    }

    @GetMapping("/staff/report")
    public String staffReport(Model model) {
        return "staff/report";
    }

    @GetMapping("/staff/ticket")
    public String staffTicket(Model model) {
        return "staff/ticket";
    }

    @GetMapping("/staff/user")
    public String staffUser(Model model) {
        return "staff/user";
    }

    @GetMapping("/staff/setting")
    public String staffSetting(Model model) {
        return "staff/setting";
    }

}
