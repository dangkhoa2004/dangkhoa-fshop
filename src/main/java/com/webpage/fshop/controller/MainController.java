package com.webpage.fshop.controller;

import com.webpage.fshop.model.*;
import com.webpage.fshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    public FileStorageService fileStorageService;
    
    @Autowired
    public InvoiceRepository invoiceRepo;

    // Không cần isLogin
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

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

    // Cần isLogin
    @GetMapping("/mouses")
    public String listMouse(Model model) {
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
        List<Invoice> lstInvoice = invoiceRepo.findAll();
        model.addAttribute("lstInvoice", lstInvoice);
        return "listInvoice";
    }

    @GetMapping("/mouses/{id}")
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

    @PostMapping("/update/{id}")
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
        return "redirect:/mouses";
    }

    @GetMapping("/mouses/add")
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
        return "addMouse";
    }

    @PostMapping("/store")
    public String storeMouse(Mouse ms, @RequestParam("images") List<MultipartFile> images) {
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
        this.mouseRepo.deleteById(id);
        return "redirect:/mouses";
    }
}
