package co.edu.icesi.challenge3.model;

import java.io.Serializable;

public class Song implements Serializable {
    private long id;
    private String title;
    private Artist artist;
    private long time_add;
    private Album album;

    public Song() {
    }

    public Song(long id, String title, Artist artist, long time_add, Album album) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.time_add = time_add;
        this.album = album;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public long getTime_add() {
        return time_add;
    }

    public void setTime_add(long time_add) {
        this.time_add = time_add;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
