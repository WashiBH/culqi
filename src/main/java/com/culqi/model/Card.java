package com.culqi.model;

public class Card {
    private String pan;
    private long exp_year;
    private long exp_month;
    public Card(){

    }
    public Card(String pan, long exp_year, long exp_month){
        this.pan=pan;
        this.exp_year=exp_year;
        this.exp_month=exp_month;
    }
    public String getPan() {
        if(pan.isEmpty()) {
            return null;
        }
        if(pan.length()<6) {
            return null;
        }
        return pan;
    }
    public String getBin(){
        return     pan.substring(0, 6);
    }
    public void setPan(String pan) {


        this.pan = pan;
    }

    public long getExp_year() {
        return exp_year;
    }

    public void setExp_year(long exp_year) {
        this.exp_year = exp_year;
    }

    public long getExp_month() {
        return exp_month;
    }

    public void setExp_month(long exp_month) {
        this.exp_month = exp_month;
    }
}