package co.edu.icesi.challenge3.model;

import java.io.Serializable;

public class Item implements Serializable {
    long id;
    private String title;
    private User user;
    private int nb_tracks;
    private String picture_small;

    public Item() {
    }

    public Item(long id, String title, User user, int nb_tracks, String picture_small) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.nb_tracks = nb_tracks;
        this.picture_small = picture_small;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(int nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public String getPicture_small() {
        return picture_small;
    }

    public void setPicture_small(String picture_small) {
        this.picture_small = picture_small;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", user=" + user +
                ", nb_tracks=" + nb_tracks +
                ", picture_small='" + picture_small + '\'' +
                '}';
    }
}

