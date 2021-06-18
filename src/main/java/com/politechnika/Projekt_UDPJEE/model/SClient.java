package com.politechnika.Projekt_UDPJEE.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Silver")
public class SClient extends Client {

    @Column(name = "Free_drinks", columnDefinition = "boolean default false")
    private boolean drinks = true;

    public boolean isDrinks() {
        return drinks;
    }

    public void setDrinks(boolean drinks) {
        this.drinks = drinks;
    }


}
