/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.config;

import com.webpage.fshop.model.Account;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author 04dkh
 */
public class SessionManager {

    public static boolean isLogin = false;
    public static Account account = null;
    public static LocalDateTime sessionStartTime;

    public static void login(Account account) {
        isLogin = true;
        SessionManager.account = account;
        SessionManager.sessionStartTime = LocalDateTime.now();
        if (isStaff()) {
            System.out.println("Đăng nhập với vai trò nhân viên.");
        } else if (isUser()) {
            System.out.println("Đăng nhập với vai trò người dùng.");
        } else {
            System.out.println("Đăng nhập với vai trò không xác định.");
        }
    }

    public static boolean isLogin() {
        return isLogin;
    }

    public static Account isAccount() {
        return SessionManager.account;
    }

    public static boolean isStaff() {
        if (account != null && account.getRole() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isUser() {
        if (account != null && account.getRole() == 2) {
            return true;
        }
        return false;
    }

    public static void logout() {
        isLogin = false;
        SessionManager.account = null;
        SessionManager.sessionStartTime = null;
        System.out.println("Đăng xuất");
    }

    public static long getSessionDuration() {
        if (sessionStartTime == null) {
            return 0;
        }
        Duration duration = Duration.between(sessionStartTime, LocalDateTime.now());
        return duration.getSeconds();
    }

}
