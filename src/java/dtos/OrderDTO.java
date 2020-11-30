/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.sql.Timestamp;

/**
 *
 * @author baoph
 */
public class OrderDTO {
    private int orderID;
    private Timestamp orderDate;
    private String phoneNumber, name, address, paymentMethod, email;
    private boolean paymentStatus;

    public OrderDTO() {
    }

    public OrderDTO(int orderID, Timestamp orderDate, String phoneNumber, String name, String address, String paymentMethod, String email, boolean paymentStatus) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.email = email;
        this.paymentStatus = paymentStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    
}
