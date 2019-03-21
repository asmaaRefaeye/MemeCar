package com.inq.eslamwael74.meme.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by EslamWael74 on 1/24/2018.
 */

public class Car implements Parcelable {

    String name;

    String type;

    String status;

    String lime;

    String model;

    String checkStatus;

    ArrayList<String> images;

    String country;

    String typeOfPay;

    String walkInKm;

    String price;

    String dateOfExamination;

    public Car(String name, String type, String status, String lime, String model, String checkStatus, ArrayList<String> images, String country, String typeOfPay, String walkInKm, String price, String dateOfExamination) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.lime = lime;
        this.model = model;
        this.checkStatus = checkStatus;
        this.images = images;
        this.country = country;
        this.typeOfPay = typeOfPay;
        this.walkInKm = walkInKm;
        this.price = price;
        this.dateOfExamination = dateOfExamination;
    }

    protected Car(Parcel in) {
        name = in.readString();
        type = in.readString();
        status = in.readString();
        lime = in.readString();
        model = in.readString();
        checkStatus = in.readString();
        images = in.createStringArrayList();
        country = in.readString();
        typeOfPay = in.readString();
        walkInKm = in.readString();
        price = in.readString();
        dateOfExamination = in.readString();
    }


    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getStatus() {
        return this.status;
    }

    public String getLime() {
        return this.lime;
    }

    public String getModel() {
        return this.model;
    }

    public String getCheckStatus() {
        return this.checkStatus;
    }

    public ArrayList<String> getImages() {
        return this.images;
    }

    public String getCountry() {
        return this.country;
    }

    public String getTypeOfPay() {
        return this.typeOfPay;
    }

    public String getWalkInKm() {
        return this.walkInKm;
    }

    public String getPrice() {
        return this.price;
    }

    public String getDateOfExamination() {
        return this.dateOfExamination;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(status);
        dest.writeString(lime);
        dest.writeString(model);
        dest.writeString(checkStatus);
        dest.writeStringList(images);
        dest.writeString(country);
        dest.writeString(typeOfPay);
        dest.writeString(walkInKm);
        dest.writeString(price);
        dest.writeString(dateOfExamination);
    }
}
