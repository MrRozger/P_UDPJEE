package com.politechnika.Projekt_UDPJEE.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Maid {

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;


    @OneToMany(mappedBy = "maid", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Room> room;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Set<Room> getRoom() {
        return room;
    }

    public void setRoom(Set<Room> room) {
        this.room = room;
    }
}