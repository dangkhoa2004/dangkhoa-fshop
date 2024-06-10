/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webpage.fshop.config;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 04dkh
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

}
