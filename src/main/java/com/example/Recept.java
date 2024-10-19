package com.example;

import java.util.List;

public class Recept {
    private String receptTitel;
    private List<String> ingredienser;
    private String instruktioner;

    public Recept(String receptTitel, List<String> ingredienser, String instruktioner) {
        this.receptTitel = receptTitel;
        this.ingredienser = ingredienser;
        this.instruktioner = instruktioner;
    }

    public String getReceptTitel() {
        return receptTitel;
    }

    public void setReceptTitel(String receptTitel) {
        this.receptTitel = receptTitel;
    }

    public List<String> getIngredienser() {
        return ingredienser;
    }

    public void setIngredienser(List<String> ingredienser) {
        this.ingredienser = ingredienser;
    }

    public String getInstruktioner() {
        return instruktioner;
    }

    public void setInstruktioner(String instruktioner) {
        this.instruktioner = instruktioner;
    }

    @Override
    public String toString() {
        return "Recept{" +
                "titel='" + receptTitel + '\'' +
                ", ingredienser=" + ingredienser +
                ", instruktioner='" + instruktioner + '\'' +
                '}';
    }
}
