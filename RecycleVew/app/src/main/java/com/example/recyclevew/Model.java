package com.example.recyclevew;

public class Model {
    private int img;
    private String name;

    //Конструктор
    public Model(int img, String name)
    {
        this.img=img;
        this.name=name;
    }
    public int getImg(){return  img;}
    public void setIMg(int img){this.img=img;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}

}
