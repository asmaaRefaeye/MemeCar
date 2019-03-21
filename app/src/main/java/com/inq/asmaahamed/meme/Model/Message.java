package com.inq.eslamwael74.meme.Model;

/**
 * Created by Omar on 2/1/2018.
 */

public class Message {

    String MessageUserName;
    String MessageProduct ;
    String MessageDate;

    public Message(String messageUserName, String messageProduct, String messageDate) {
        this.MessageUserName = messageUserName;
        this.MessageProduct = messageProduct;
        this.MessageDate = messageDate;
    }

    public String getMessageUserName() {
        return this.MessageUserName;
    }

    public void setMessageUserName(String messageUserName) {
        this.MessageUserName = messageUserName;
    }

    public String getMessageProduct() {
        return this.MessageProduct;
    }

    public void setMessageProduct(String messageProduct) {
        this.MessageProduct = messageProduct;
    }

    public String getMessageDate() {
        return this.MessageDate;
    }

    public void setMessageDate(String messageDate) {
        this.MessageDate = messageDate;
    }
}
