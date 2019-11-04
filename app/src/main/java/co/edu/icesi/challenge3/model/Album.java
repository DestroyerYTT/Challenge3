package co.edu.icesi.challenge3.model;

import java.io.Serializable;

public class Album implements Serializable {

    private String title;
    private String cover_small;

    public Album() {
    }

    public Album(String title, String cover_small) {
        this.title = title;
        this.cover_small = cover_small;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover_small() {
        return cover_small;
    }

    public void setCover_small(String cover_small) {
        this.cover_small = cover_small;
    }
}
