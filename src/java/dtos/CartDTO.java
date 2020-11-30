/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baoph
 */
public class CartDTO {

    private Map<String, CakeDTO> cart;
    private float total;

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public CartDTO() {
    }

    public CartDTO(Map<String, CakeDTO> cart) {
        this.cart = cart;
    }

    public Map<String, CakeDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, CakeDTO> cart) {
        this.cart = cart;
    }

    public void add(CakeDTO dto) {
        if (cart == null) {
            cart = new HashMap<>();
        }
        if (this.cart.containsKey(String.valueOf(dto.getId()))) {
            int quantity = this.cart.get(String.valueOf(dto.getId())).getCartQuantity();
            dto.setCartQuantity(quantity + 1);
        }
        cart.put(String.valueOf(dto.getId()), dto);
    }

    public void delete(int id) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(String.valueOf(id))) {
            this.cart.remove(String.valueOf(id));
        }
    }

    public void update(int id, int newValue) {
        if (this.cart != null) {
            if (this.cart.containsKey(String.valueOf(id))) {
                this.cart.get(String.valueOf(id)).setCartQuantity(newValue);
            }
        }
    }
}
