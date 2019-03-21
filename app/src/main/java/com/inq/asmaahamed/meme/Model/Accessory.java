package com.inq.eslamwael74.meme.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Eslam Wael on 2/3/2018.
 */

public class Accessory implements Parcelable {

    String name;

    String price;

    String description;

    String image;

    public Accessory(String name, String price, String description, String image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    protected Accessory(Parcel in) {
        name = in.readString();
        price = in.readString();
        description = in.readString();
        image = in.readString();
    }

    public static final Creator<Accessory> CREATOR = new Creator<Accessory>() {
        @Override
        public Accessory createFromParcel(Parcel in) {
            return new Accessory(in);
        }

        @Override
        public Accessory[] newArray(int size) {
            return new Accessory[size];
        }
    };

    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImage() {
        return this.image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(price);
        dest.writeString(description);
        dest.writeString(image);
    }
}
