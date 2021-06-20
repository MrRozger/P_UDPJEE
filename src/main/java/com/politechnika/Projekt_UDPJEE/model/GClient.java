package com.politechnika.Projekt_UDPJEE.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Gold")
public class GClient extends Client {
    @Column(name = "Free_food_drinks", columnDefinition = "boolean default false")
    private boolean food_drinks = true;

    public boolean isFood_drinks() {
        return food_drinks;
    }

    public void setFood_drinks(boolean food_drinks) {
        this.food_drinks = food_drinks;
    }

}
