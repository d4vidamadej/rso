package com.example.rso_java_plevnik;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Event_list{
    private int id;
    private List<Event> events;

    public EventList(int id) {
        this.id = id;
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getEvents() {
        return events;
    }

    public int getId() {
        return id;
    }

    public LocalDate getNextEventDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate closestDate = null;

        for (Event event : events) {
            if (event.getDate().isAfter(currentDate)) {
                if (closestDate == null || event.getDate().isBefore(closestDate)) {
                    closestDate = event.getDate();
                }
            }
        }

        return closestDate;
    }
}