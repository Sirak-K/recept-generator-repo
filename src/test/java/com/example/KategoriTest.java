package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KategoriTest {

    @Test
    public void testSkapaKategori() {
        Kategori frukost = new Kategori("Frukost");
        assertEquals("Frukost", frukost.getNamn());
    }

    @Test
    public void testÄndraKategoriNamn() {
        Kategori lunch = new Kategori("Lunch");
        lunch.setNamn("Brunch");
        assertEquals("Brunch", lunch.getNamn());
    }

    @Test
    public void testKategoriToString() {
        Kategori middag = new Kategori("Middag");
        assertEquals("Middag", middag.toString());
    }
}
