package com.example.przed_kartkowka_formularz;

public class Cars {
    private Integer zdjecie;
    private String nazwa;
    private String opis;


    public Cars(Integer zdjecie, String nazwa, String opis) {
        this.zdjecie = zdjecie;
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public Integer getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(Integer zdjecie) {
        this.zdjecie = zdjecie;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
