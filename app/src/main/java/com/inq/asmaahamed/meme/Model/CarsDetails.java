package com.inq.eslamwael74.meme.Model;

/**
 * Created by Omar on 2/10/2018.
 */

public class CarsDetails {

    String Image;

    public CarsDetails(String image) {
        this.Image = image;
    }

    public String getImage() {
        return this.Image;
    }

    public void setImage(String image) {
        this.Image = image;
    }

    String Name ;

    String Type;

    String Lime;

    String State;

    String Model ;

    String check_state;

    String Payment_method;

    String DateofExamination;

    public CarsDetails(String name, String type, String lime, String state, String model, String check_state, String payment_method, String dateofExamination) {
        this.Name = name;
        this.Type = type;
        this.Lime = lime;
        this.State = state;
        this.Model = model;
        this.check_state = check_state;
        this.Payment_method = payment_method;
        this.DateofExamination = dateofExamination;
    }


    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getType() {
        return this.Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getLime() {
        return this.Lime;
    }

    public void setLime(String lime) {
        this.Lime = lime;
    }

    public String getState() {
        return this.State;
    }

    public void setState(String state) {
        this.State = state;
    }

    public String getModel() {
        return this.Model;
    }

    public void setModel(String model) {
        this.Model = model;
    }

    public String getCheck_state() {
        return this.check_state;
    }

    public void setCheck_state(String check_state) {
        this.check_state = check_state;
    }

    public String getPayment_method() {
        return this.Payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.Payment_method = payment_method;
    }

    public String getDateofExamination() {
        return this.DateofExamination;
    }

    public void setDateofExamination(String dateofExamination) {
        this.DateofExamination = dateofExamination;
    }
}
