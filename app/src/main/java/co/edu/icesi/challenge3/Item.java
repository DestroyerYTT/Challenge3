package co.edu.icesi.challenge3;

public class Item {

    private String title;
    private String creatorName;
    private int nb_tracks;
    private String picture_small;

    public Item() {
    }

    public Item(String title, String creatorName, int nb_tracks, String picture_small) {
        this.title = title;
        this.creatorName = creatorName;
        this.nb_tracks = nb_tracks;
        this.picture_small = picture_small;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
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
}

