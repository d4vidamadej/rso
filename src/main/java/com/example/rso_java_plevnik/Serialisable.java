package com.example.rso_java_plevnik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.time.LocalDate;

public class Serialisable {
    public void serialise(ObservableList<Event> items) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("serialization.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Event item : items) {
            objectOutputStream.writeObject(item);
        }
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public ObservableList<Event> deserialise() throws IOException, ClassNotFoundException{
        FileInputStream fileInputStream = new FileInputStream("serialization.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ObservableList<Event> items = FXCollections.observableArrayList();
        while (true){
            try{
                items.add((Event)objectInputStream.readObject());
            } catch (Exception e){break;}
        }
        objectInputStream.close();
        return items;
    }
}