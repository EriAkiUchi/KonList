package com.KonList.model;

public enum Type {
    TV("TV"),
    OVA("OVA"),
    MOVIE("MOVIE"),
    SPECIAL("SPECIAL"),
    ONA("ONA"),
    MUSIC("MUSIC");

    private String type;

    Type(String type) {
        this.type = type;
    }
}
