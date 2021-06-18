package com.politechnika.Projekt_UDPJEE.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private int number;


    public enum Type {
        STANDARD,
        SUPERIOR,
        APARTAMENT
    }

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Reservation> reservations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}