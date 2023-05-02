package com.example.myapplication;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    private String ad;
    private String yas;
    private String diller;
    private String tel;
    private String posta;
    private String gecmis;

    public User() {
    }

    public String getAd() {
        return ad;
    }

    public String getYas() {
        return yas;
    }

    public String getDiller() {
        return diller;
    }

    public String getTel() {
        return tel;
    }

    public String getPosta() {
        return posta;
    }

    public String getGecmis() {
        return gecmis;
    }

    public User(String ad, String yas, String diller, String tel, String posta, String gecmis) {
        this.ad = ad;
        this.diller = diller;
        this.yas = yas;
        this.tel = tel;
        this.posta = posta;
        this.gecmis = gecmis;

    }
}
