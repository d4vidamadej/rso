package com.example.rso_java_plevnik;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventList {
    protected ArrayList<Event> events;
    protected int id;
    protected double najblizjiEvent;

    public EventList(){
        this.events = new ArrayList<Event>();
        this.id = 0;
        this.najblizjiEvent = 0;
    }

    public void addEvent(Event event){
        this.events.add(event);
    }

    public void removeEvent(Event event){
        this.events.remove(event);
    }

    public ArrayList<Event> getEvents(){
        return this.events;
    }

    public void setEvents(ArrayList<Event> events){
        this.events = events;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public double getNajblizjiEvent(){
        return this.najblizjiEvent;
    }

    public void setNajblizjiEvent(double najblizjiEvent){
        this.najblizjiEvent = najblizjiEvent;
    }
}