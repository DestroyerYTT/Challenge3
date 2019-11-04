package co.edu.icesi.challenge3.model;

import java.io.Serializable;

public class ItemComplete implements Serializable {
    private String title;
    private int nb_tracks;
    private String picture_small;
    private int fans;
    private String description;
    private Track tracks;

    public ItemComplete(){
    }

    public ItemComplete(String title, int nb_tracks, String picture_small, Integer nb_fans, String description) {
        this.title = title;
        this.nb_tracks = nb_tracks;
        this.picture_small = picture_small;
        this.fans = nb_fans;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getNb_fans() {
        return fans;
    }

    public void setNb_fans(Integer nb_fans) {
        this.fans = nb_fans;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Track getTracks() {
        return tracks;
    }

    public void setTracks(Track tracks) {
        this.tracks = tracks;
    }
}

