package com.example.abbs.entity;

public class Location {

    private Long id;
    private String name;
    private String address;
    // 필요하다면 위도(latitude)와 경도(longitude) 필드도 추가

    // 기본 생성자
    public Location() {
    }

    // getter, setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}