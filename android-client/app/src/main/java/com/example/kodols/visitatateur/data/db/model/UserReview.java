package com.example.kodols.visitatateur.data.db.model;

public class UserReview {

    private String title;
    private User user;
    private int note;
    private Place place;
    private String description;

    public UserReview(String title, User user, int note, Place place, String description) {
        this.title = title;
        this.user = user;
        this.note = note;
        this.place = place;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
