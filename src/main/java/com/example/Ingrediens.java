package com.example;

public class Ingrediens {
    private String ingrediensNamn;
    private String ingrediensMängd;

    public Ingrediens(String ingrediensNamn, String ingrediensMängd) {
        this.ingrediensNamn = ingrediensNamn;
        this.ingrediensMängd = ingrediensMängd;
    }

    // Getters och setters
    public String getIngrediensNamn() {
        return ingrediensNamn;
    }

    public void setIngrediensNamn(String ingrediensNamn) {
        this.ingrediensNamn = ingrediensNamn;
    }

    public String getIngrediensMängd() {
        return ingrediensMängd;
    }

    public void setIngrediensMängd(String ingrediensMängd) {
        this.ingrediensMängd = ingrediensMängd;
    }

    @Override
    public String toString() {
        return ingrediensNamn + ": " + ingrediensMängd;
    }
}
