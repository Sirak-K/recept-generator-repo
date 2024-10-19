package com.example;

public class Kategori {
    private String kategoriNamn;

    public Kategori(String kategoriNamn) {
        this.kategoriNamn = kategoriNamn;
    }

    public String getNamn() {
        return kategoriNamn;
    }

    public void setNamn(String kategoriNamn) {
        this.kategoriNamn = kategoriNamn;
    }

    @Override
    public String toString() {
        return kategoriNamn;
    }
}
