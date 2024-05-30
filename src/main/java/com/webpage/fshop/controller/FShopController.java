/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.controller;

import com.webpage.fshop.model.Mouse;
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
    public MouseRepository mouseRepo;

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
    public String buyMouse(@PathVariable("idMouse") int idMouse, Model model) {
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

}
