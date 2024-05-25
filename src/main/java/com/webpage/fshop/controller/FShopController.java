/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.controller;

import com.webpage.fshop.model.ImageUrl;
import com.webpage.fshop.model.Mouse;
import com.webpage.fshop.repository.ImageUrlRepository;
import com.webpage.fshop.repository.MouseRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "staff/shop";
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
