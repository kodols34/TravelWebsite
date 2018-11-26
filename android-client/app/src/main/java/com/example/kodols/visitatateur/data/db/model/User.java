package com.example.kodols.visitatateur.data.db.model;

public class User {
    private String email;
    private String password;
    private String nom;
    private String pseudo;
    private String prenom;
    private String sexe;
    private int age;
    private String phone;
    private String description;

    public User(String email, String password, String nom, String prenom, String sexe, int age, String phone) {
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.age = age;
        this.phone = phone;
    }
}
