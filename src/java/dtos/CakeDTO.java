/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Base64;

/**
 *
 * @author baoph
 */
public class CakeDTO {

    private String name, description, category;

    private byte[] image;
    private float price, total;
    private int id, quantity, cartQuantity;
    private Date createDate, expirationDate;
    private boolean status;
    private final SimpleDateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");

    public CakeDTO() {
    }

    public CakeDTO(int id, String name, String description, String category, byte[] image, float price, int quantity, Date createDate, Date expirationDate, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.cartQuantity = 1;
        this.createDate = createDate;
        this.expirationDate = expirationDate;
        this.status = status;
    }

    public float getTotalCost() {
        return cartQuantity * price;
    }
    
    public float getTotal() {
        return total += getTotalCost();
    }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getImgBase64() {
        return new String(Base64.getEncoder().encode(image));
    }

    public String getFormatCreateDate() {
        return dateF.format(createDate);
    }

    public String getFormatExpirationDate() {
        return dateF.format(expirationDate);
    }
}
