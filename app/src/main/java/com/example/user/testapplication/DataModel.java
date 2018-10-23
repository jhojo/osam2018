package com.example.user.testapplication;

public class DataModel {

    String name;
    String phone_number;
    String time;
    String others;

    public DataModel(String name, String phone_number, String time, String others ) {
        this.name=name;
        this.phone_number=phone_number;
        this.time=time;
        this.others=others;

    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public String getTime() {
        return time;
    }

    public String getOthers() {
        return others;
    }

}
