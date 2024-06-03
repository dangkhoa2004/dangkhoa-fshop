/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.config;

import com.webpage.fshop.model.Account;

/**
 *
 * @author 04dkh
 */
public class SessionManager {

    public static boolean isLogin = false;
    public static Account account = null;

    public static void login(Account account) {
        isLogin = true;
        SessionManager.account = account;
    }

    public static boolean isLogin() {
        return isLogin;
    }

    public static Account isAccount() {
        return SessionManager.account;
    }

    public static void logout() {
        isLogin = false;
        SessionManager.account = null;
    }
}
