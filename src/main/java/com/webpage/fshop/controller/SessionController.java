    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.controller;

import com.webpage.fshop.config.ConfigurationAPI;
import com.webpage.fshop.config.SessionManager;
import com.webpage.fshop.model.Account;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 04dkh
 */
@RestController
public class SessionController {

    @GetMapping("/configurationAPI")
    public ConfigurationAPI getApiSession(HttpServletRequest request) {
        boolean isLogin = SessionManager.isLogin();
        Account account = SessionManager.isAccount();
        if (account == null) {
            return new ConfigurationAPI(false, null, null, null, null, LocalDateTime.now(), null, 0, null, null, "1.0.0");
        }
        String name = account.getName();
        String ipAddress = request.getRemoteAddr();
        String ipv4Address = null;
        String ipv6Address = null;
        String deviceName = request.getHeader("User-Agent");
        LocalDateTime timestamp = LocalDateTime.now();
        String userRole = account.getName();  // Assuming Account class has getRole() method
        long sessionDuration = SessionManager.getSessionDuration();  // Assuming SessionManager has getSessionDuration() method
        String browserInfo = request.getHeader("User-Agent");
        String operatingSystem = getOperatingSystemFromUserAgent(browserInfo);  // You need to implement this method
        String appVersion = "1.0.0";  // or fetch from configuration

        // Check if the IP address is IPv4 or IPv6
        if (ipAddress.contains(":")) {
            ipv6Address = ipAddress;
        } else {
            ipv4Address = ipAddress;
        }

        return new ConfigurationAPI(isLogin, name, ipv4Address, ipv6Address, deviceName, timestamp, userRole, sessionDuration, browserInfo, operatingSystem, appVersion);
    }

    public String getOperatingSystemFromUserAgent(String userAgent) {
        if (userAgent.toLowerCase().contains("windows")) {
            return "Windows";
        } else if (userAgent.toLowerCase().contains("mac")) {
            return "Mac";
        } else if (userAgent.toLowerCase().contains("x11")) {
            return "Unix";
        } else if (userAgent.toLowerCase().contains("android")) {
            return "Android";
        } else if (userAgent.toLowerCase().contains("iphone")) {
            return "iOS";
        } else {
            return "Unknown";
        }
    }
}