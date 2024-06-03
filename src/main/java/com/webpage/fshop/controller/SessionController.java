/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.controller;

import com.webpage.fshop.config.ApiSession;
import com.webpage.fshop.config.SessionManager;
import com.webpage.fshop.model.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 04dkh
 */
@RestController
public class SessionController {

    @GetMapping("/session-info")
    public ApiSession getApiSession() {
        boolean isLogin = SessionManager.isLogin();
        Account account = SessionManager.isAccount();
        if (account == null) {
            return new ApiSession(false, null);
        }
        String username = account.getUsername();
        return new ApiSession(isLogin, username);
    }
}
