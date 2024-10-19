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

// Underklasser för olika kategorier
class Frukost extends Kategori {
    public Frukost() {
        super("Frukost");
    }
}

class Lunch extends Kategori {
    public Lunch() {
        super("Lunch");
    }
}

class Middag extends Kategori {
    public Middag() {
        super("Middag");
    }
}
