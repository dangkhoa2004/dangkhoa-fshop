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

@Controller
public class MainController {
    
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

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/fshop")
    public String shop(Model model) {
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

    @GetMapping("/mouse_list")
    public String staff(Model model) {
        List<Mouse> lstMouse = mouseRepo.findAll();
        model.addAttribute("lstMouse", lstMouse);
        return "listMouse";
    }
    @GetMapping("/mouse_edit/{id}")
    public String editMouse(@PathVariable("id") int id, Model model) {
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

    @PostMapping("/mouse_update/{id}")
    public String updateMouse(@PathVariable("id") int id, @ModelAttribute Mouse ms) {
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
        return "redirect:/mouse_list";
    }
}
