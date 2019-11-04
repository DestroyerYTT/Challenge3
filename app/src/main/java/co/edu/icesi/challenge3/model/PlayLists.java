package co.edu.icesi.challenge3.model;

import java.util.ArrayList;

public class PlayLists {

    private ArrayList<Item> data;

    public PlayLists() {
        data = new ArrayList<Item>();
    }

    public ArrayList<Item> getData() {
        return data;
    }

    public void setData(ArrayList<Item> data) {
        this.data = data;
    }
}
