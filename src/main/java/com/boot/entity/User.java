package com.boot.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    public int uId;
    
    private String uName;
    private String uEmail;
    private String uPassword;

    @ManyToMany(mappedBy = "users")
    private Set<Product> products;

    public User() {
        super();
    }

    public User(int uId, String uName, String uEmail, String uPassword) {
        this.uId = uId;
        this.uName = uName;
        this.uEmail = uEmail;
        this.uPassword = uPassword;
    }

    // Getters and setters

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "User [uId=" + uId + ", uName=" + uName + ", uEmail=" + uEmail + ", uPassword=" + uPassword + "]";
    }
}
