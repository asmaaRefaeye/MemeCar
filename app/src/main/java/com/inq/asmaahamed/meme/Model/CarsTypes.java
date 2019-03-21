package com.inq.eslamwael74.meme.Model;

/**
 * Created by Omar on 2/1/2018.
 */

public class CarsTypes {

    String carImage;
    String carname;
    String carRef;
    String carsize;
    String carcolors;
    String carprice;

    public CarsTypes(String carImage, String carname, String carRef, String carsize, String carcolors, String carprice) {
        this.carImage = carImage;
        this.carname = carname;
        this.carRef = carRef;
        this.carsize = carsize;
        this.carcolors = carcolors;
        this.carprice = carprice;
    }

    public String getCarImage() {
        return this.carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    public String getCarname() {
        return this.carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getCarRef() {
        return this.carRef;
    }

    public void setCarRef(String carRef) {
        this.carRef = carRef;
    }

    public String getCarsize() {
        return this.carsize;
    }

    public void setCarsize(String carsize) {
        this.carsize = carsize;
    }

    public String getCarcolors() {
        return this.carcolors;
    }

    public void setCarcolors(String carcolors) {
        this.carcolors = carcolors;
    }

    public String getCarprice() {
        return this.carprice;
    }

    public void setCarprice(String carprice) {
        this.carprice = carprice;
    }
}
