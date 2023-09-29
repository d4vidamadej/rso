package com.example.rso_java_plevnik;

import java.time.LocalDate;

public class Birthday_event{
    private int age;

    public Birthday_event(int id, String name, LocalDate date, int age) {
        super(id, name, date);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
