package com.example.pritam.meenuapp.models;

public class Model {

    public static final int IMAGE_TYPE2 = 0;
    public static final int IMAGE_TYPE4 = 1;
    public static final int IMAGE_TYPE6 = 2;
    public static final int VIDEO_TYPE = 3;

    public int type;
    public int data;
    public int data2;
    public int data3;
    public int data4;
    public int data5;
    public int data6;
    public String text;

    public Model(int type, String text, int data)
    {
        this.type=type;
        this.data=data;
        this.text=text;
    }

    public Model(int type,  String text, int data, int data2, int data3, int data4, int data5, int data6) {
        this.type = type;
        this.text = text;
        this.data = data;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
        this.data5 = data5;
        this.data6 = data6;
    }
}
