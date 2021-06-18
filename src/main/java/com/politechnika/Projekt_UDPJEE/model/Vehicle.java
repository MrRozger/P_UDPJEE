package com.politechnika.Projekt_UDPJEE.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Vehicle {

    private String model;

    public enum Type {
        SPORT,
        ECO,
        MINI_VAN
    }

    @Enumerated(EnumType.STRING)
    private Type type;

    public void setType(Type type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
