package com.culqi.model;


public class Token {
    private String token;
    private String brand;
    private String creation_dt;
    public Token(Card card){
      this.token="tkn_live_"+ card.getPan()+"-"+ card.getExp_year()+"-"+ card.getExp_month();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token; }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCreation_dt() {
        return creation_dt;
    }

    public void setCreation_dt(String creation_dt) {
        this.creation_dt = creation_dt;
    }
}
