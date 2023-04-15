package com.example.manish.cgdoctors;

public class ModalClassHome {

    public int dis_img;
    public String name_h;
    public String name_e;


    public ModalClassHome()
    {}
    public ModalClassHome(int dis_img, String name_h, String name_e) {
        this.dis_img = dis_img;
        this.name_h = name_h;
        this.name_e = name_e;
    }

    public int getDis_img() {
        return dis_img;
    }

    public void setDis_img(int dis_img) {
        this.dis_img = dis_img;
    }

    public String getName_h() {
        return name_h;
    }

    public void setName_h(String name_h) {
        this.name_h = name_h;
    }

    public String getName_e() {
        return name_e;
    }

    public void setName_e(String name_e) {
        this.name_e = name_e;
    }
}
