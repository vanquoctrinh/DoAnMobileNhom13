package com.example.bottomnavi.ui.home;

import java.io.Serializable;

public class FoodDomain implements Serializable{
    private String title;
    private String pic;
    private String description;
    private Double money;
    private int numberInCart;

    public FoodDomain(String title, String pic, String description, Double money) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.money = money;
    }

    public FoodDomain(String title, String pic, String description, Double money, int numberInCart) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.money = money;
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
