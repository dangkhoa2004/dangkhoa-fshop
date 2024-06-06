package com.webpage.fshop.model;

import java.io.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Account")
public class Account implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int id;

  public String username;
  public String password;
  public String avt;
  public String name;
  public String email;
  public String phone;
  public String sex;
  public int status;
  public int role;

  public Account() {
  }

  public Account(int id, String username, String password, String avt, String name, String email,
      String phone, String sex, int status, int role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.avt = avt;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.sex = sex;
    this.status = status;
    this.role = role;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAvt() {
    return avt;
  }

  public void setAvt(String avt) {
    this.avt = avt;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getRole() {
    return role;
  }

  public void setRole(int role) {
    this.role = role;
  }
}
