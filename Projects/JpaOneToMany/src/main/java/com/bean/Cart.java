package com.bean;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public class Cart {
    private int cartId;
    private String cartName;
    private int totalItems;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> itemList;

    public Cart() {
    }

    public Cart(int cartId, String cartName, int totalItems) {
        this.cartId = cartId;
        this.cartName = cartName;
        this.totalItems = totalItems;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}
