package com.inq.eslamwael74.meme.Model;

/**
 * Created by Omar on 2/4/2018.
 */

public class SearchCar {

    String CarSpeed_hr_txt;

    String Carspeed_Km_txt;

    String CarSpeed_txt;

    String SearchDate_txt;

    String CarDescription_txt;

    String FristCar_img;

    String SecCar_img;

    public String getCarSpeed_hr_txt() {
        return this.CarSpeed_hr_txt;
    }

    public void setCarSpeed_hr_txt(String carSpeed_hr_txt) {
        this.CarSpeed_hr_txt = carSpeed_hr_txt;
    }

    public String getCarspeed_Km_txt() {
        return this.Carspeed_Km_txt;
    }

    public void setCarspeed_Km_txt(String carspeed_Km_txt) {
        this.Carspeed_Km_txt = carspeed_Km_txt;
    }

    public String getCarSpeed_txt() {
        return this.CarSpeed_txt;
    }

    public void setCarSpeed_txt(String carSpeed_txt) {
        this.CarSpeed_txt = carSpeed_txt;
    }

    public String getSearchDate_txt() {
        return this.SearchDate_txt;
    }

    public void setSearchDate_txt(String searchDate_txt) {
        this.SearchDate_txt = searchDate_txt;
    }

    public String getCarDescription_txt() {
        return this.CarDescription_txt;
    }

    public void setCarDescription_txt(String carDescription_txt) {
        this.CarDescription_txt = carDescription_txt;
    }

    public String getFristCar_img() {
        return this.FristCar_img;
    }

    public void setFristCar_img(String fristCar_img) {
        this.FristCar_img = fristCar_img;
    }

    public String getSecCar_img() {
        return this.SecCar_img;
    }

    public void setSecCar_img(String secCar_img) {
        this.SecCar_img = secCar_img;
    }

    public SearchCar(String carSpeed_hr_txt, String carspeed_Km_txt, String carSpeed_txt, String searchDate_txt, String carDescription_txt, String fristCar_img, String secCar_img) {
        this.CarSpeed_hr_txt = carSpeed_hr_txt;
        this.Carspeed_Km_txt = carspeed_Km_txt;
        this.CarSpeed_txt = carSpeed_txt;
        this.SearchDate_txt = searchDate_txt;
        this.CarDescription_txt = carDescription_txt;
        this.FristCar_img = fristCar_img;
        this.SecCar_img = secCar_img;


    }
}
