package com.example.rso_java_plevnik;

public class User{
    protected String ime;
    protected String priimek;
    protected String geslo;

    public User(String ime, String priimek, String geslo){
        this.ime = ime;
        this.priimek = priimek;
        this.geslo = geslo;
    }

    public String getIme(){
        return this.ime;
    }

    public void setIme(String ime){
        this.ime = ime;
    }

    public String getPriimek(){
        return this.priimek;
    }

    public void setPriimek(String priimek){
        this.priimek = priimek;
    }

    public String getGeslo(){
        return this.geslo;
    }

    public void setGeslo(String geslo){
        this.geslo = geslo;
    }
}