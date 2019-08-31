package com.example.colorguessgame;

class Color {
    private String name;
    private int image;

    Color(String name, int image){
        this.name=name;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
