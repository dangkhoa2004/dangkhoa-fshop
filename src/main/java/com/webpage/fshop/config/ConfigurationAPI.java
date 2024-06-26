/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.config;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author 04dkh
 */
public class ConfigurationAPI {

    public boolean login;
    public String name;
    public String ipv4Address;
    public String ipv6Address;
    public String deviceName;
    public LocalDateTime timestamp;
    public String userRole;
    public long sessionDuration;
    public String browserInfo;
    public String operatingSystem;
    public String appVersion;

    public ConfigurationAPI() {
    }

    public ConfigurationAPI(boolean login, String name, String ipv4Address, String ipv6Address, String deviceName, LocalDateTime timestamp, String userRole, long sessionDuration, String browserInfo, String operatingSystem, String appVersion) {
        this.login = login;
        this.name = name;
        this.ipv4Address = ipv4Address;
        this.ipv6Address = ipv6Address;
        this.deviceName = deviceName;
        this.timestamp = timestamp;
        this.userRole = userRole;
        this.sessionDuration = sessionDuration;
        this.browserInfo = browserInfo;
        this.operatingSystem = operatingSystem;
        this.appVersion = appVersion;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpv4Address() {
        return ipv4Address;
    }

    public void setIpv4Address(String ipv4Address) {
        this.ipv4Address = ipv4Address;
    }

    public String getIpv6Address() {
        return ipv6Address;
    }

    public void setIpv6Address(String ipv6Address) {
        this.ipv6Address = ipv6Address;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public long getSessionDuration() {
        return sessionDuration;
    }

    public void setSessionDuration(long sessionDuration) {
        this.sessionDuration = sessionDuration;
    }

    public String getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(String browserInfo) {
        this.browserInfo = browserInfo;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

}
