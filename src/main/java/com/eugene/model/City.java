package com.eugene.model;

import javax.persistence.*;

@Entity
@Table(name = "City")
public class City {

    public City() {
    }

    public City(Long id, String city, String info) {
        this.id = id;
        this.city = city;
        this.info = info;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "info")
    private String info;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
