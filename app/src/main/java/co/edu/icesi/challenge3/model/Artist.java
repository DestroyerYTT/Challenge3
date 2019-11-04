package co.edu.icesi.challenge3.model;

import java.io.Serializable;

public class Artist implements Serializable {

    private String name;

    public Artist() {}
    public Artist(String name) {this.name = name;}
    public void setName(String name) {this.name = name;}
    public String getName() {return name;}
}
