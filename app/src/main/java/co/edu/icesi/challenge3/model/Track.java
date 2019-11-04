package co.edu.icesi.challenge3.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Track implements Serializable {
    private ArrayList<Song> data;

    public Track() {
    }

    public Track(ArrayList<Song> data) {
        this.data = data;
    }

    public ArrayList<Song> getData() {
        return data;
    }

    public void setData(ArrayList<Song> data) {
        this.data = data;
    }
}
