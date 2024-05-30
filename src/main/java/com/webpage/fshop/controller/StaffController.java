/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 04dkh
 */
//@Controller
@RequestMapping(value = "/staff")
public class StaffController {

    @GetMapping("/staff")
    public String staff(Model model) {
        return "staff/index";
    }

    @GetMapping("/report")
    public String staffReport(Model model) {
        return "staff/report";
    }

    @GetMapping("/ticket")
    public String staffTicket(Model model) {
        return "staff/ticket";
    }

    @GetMapping("/user")
    public String staffUser(Model model) {
        return "staff/user";
    }

    @GetMapping("/setting")
    public String staffSetting(Model model) {
        return "staff/setting";
    }
}
