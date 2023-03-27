package com.shopcart.ShopCart1erParcial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // @NotBlank(message = "Item Name is mandatory")
    @Column(name = "itemName")
    private String itemName;

    // @NotBlank(message = "Item Description is mandatory")
    @Column(name = "itemDescription")
    private String itemDescription;

    @Column(name = "price")
    private float price;

    @Column(name = "quantity")
    private int quantity;

    public Item() {
    }

    public Item(String itemName, String itemDescription, float price, int quantity) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.price = price;
        this.quantity = quantity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}