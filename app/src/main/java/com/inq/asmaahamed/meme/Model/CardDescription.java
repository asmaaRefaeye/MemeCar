package com.inq.eslamwael74.meme.Model;

/**
 * Created by Omar on 1/26/2018.
 */

public class CardDescription {

    String image;
    String name;


    public CardDescription(String image, String name) {
        this.image = image;
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
