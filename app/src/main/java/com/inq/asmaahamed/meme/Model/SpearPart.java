package com.inq.eslamwael74.meme.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Eslam Wael on 2/3/2018.
 */

public class SpearPart implements Parcelable {

    String name;

    String price;

    String description;

    String image;

    public SpearPart(String name, String price, String description, String image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    protected SpearPart(Parcel in) {
        name = in.readString();
        price = in.readString();
        description = in.readString();
        image = in.readString();
    }

    public static final Creator<SpearPart> CREATOR = new Creator<SpearPart>() {
        @Override
        public SpearPart createFromParcel(Parcel in) {
            return new SpearPart(in);
        }

        @Override
        public SpearPart[] newArray(int size) {
            return new SpearPart[size];
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
