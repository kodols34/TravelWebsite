package com.example.kodols.visitatateur.data.db.model;

public class Place {

    private String nom;
    private String address;
    private String description;
    private int note;
    private int number;

    public Place(String nom, String address, String description, int note, int number) {
        this.nom = nom;
        this.address = address;
        this.description = description;
        this.note = note;
        this.number = number;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
