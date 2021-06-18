package com.politechnika.Projekt_UDPJEE.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bronze")
public class BClient extends Client {

    @Column(name = "Discount", columnDefinition = "boolean default false")
    private boolean discount = true;

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }
}