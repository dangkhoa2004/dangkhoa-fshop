/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.controller;

import com.webpage.fshop.config.SecurityManager;
import com.webpage.fshop.model.Account;
import com.webpage.fshop.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 04dkh
 */
@Controller
public class LoginController {

    @Autowired
    public AccountRepository accountRepo;

    Account account = null;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        String textFail = null;
        this.account = accountRepo.findByUsername(username);
        if (this.account == null) {
            textFail = "Đăng nhập thất bại !";
            model.addAttribute("textFail", textFail);
            return "login";
        }
        SecurityManager.login(account);
        return "redirect:/fshop";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityManager.logout();
        return "redirect:/fshop";
    }
}
