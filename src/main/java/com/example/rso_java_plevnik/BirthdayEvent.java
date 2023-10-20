package com.example.rso_java_plevnik;

import java.time.LocalDate;

public class BirthdayEvent extends Event{
    protected int leto;
    public BirthdayEvent(int id, String ime, LocalDate date, int leto) {
        super(id, ime, date);
        this.leto = leto;
    }

    public int getLeto(){
        return this.leto;
    }

    public void setLeto(int leto){
        this.leto = leto;
    }
}
