package com.example.rso_java_plevnik;

import java.time.LocalDate;
import java.io.Serializable;
public class Event implements Serializable{
    protected int id;
    protected String ime;
    protected LocalDate date;
    public Event(int id, String ime, LocalDate date){
        this.id = id;
        this.ime = ime;
        this.date = date;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getIme(){
        return this.ime;
    }

    public void setIme(String ime){
        this.ime = ime;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public String toString(){
        return this.ime + " " + this.date.toString();
    }
}