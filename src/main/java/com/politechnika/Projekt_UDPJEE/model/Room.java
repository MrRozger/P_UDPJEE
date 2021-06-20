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

    @Enumerated(EnumType.STRING)
    private Room.Type type;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Reservation> reservations;

    @ManyToOne(cascade = CascadeType.ALL)
    private Maid maid;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Maid getMaid() {
        return maid;
    }

    public void setMaid(Maid maid) {
        this.maid = maid;
    }

}