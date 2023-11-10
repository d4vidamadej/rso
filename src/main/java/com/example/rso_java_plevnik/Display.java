package com.example.rso_java_plevnik;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

public class Display {

    private DatePicker datePicker;

    private CheckBox birthdayToggle;
    private TextField leto;
    private LocalDate datum;
    private TextField inputBox;
    private TextField datumBox;
    private Button displayButton;
    private Button deleteButton;
    private Label displayLabel;
    private ListView<Event> listView; // Add ListView for displaying strings
    private ObservableList<Event> items; // Observable list to hold strings
    private Button serialise;
    private Button deserialise;
    private int selectedItem=-1; // Observable list to hold strings

    public Display() {
        EventList eventList= new EventList();
        birthdayToggle = new CheckBox();
        birthdayToggle.setText("Birthday?");
        inputBox = new TextField();
        leto = new TextField();
        leto.setVisible(false);
        datePicker = new DatePicker();

        displayButton = new Button("Add");
        deleteButton = new Button("Delete");
        displayLabel = new Label();
        serialise = new Button("Save");
        deserialise = new Button("Load");
        listView = new ListView<>();
        items = FXCollections.observableArrayList(); // Initialize the observable list
        Serialisable serialisable = new Serialisable();

        displayButton.setOnAction(event -> {
            String ime = inputBox.getText();
            Event e = new Event(1, ime, datum);


            // Add the text to the ListView
            if (birthdayToggle.isSelected()){
                String starost = leto.getText();
                BirthdayEvent be = new BirthdayEvent(1, ime, datum, Integer.parseInt(starost));
                items.add(be);
            }
            else{
                items.add(e);
            }

            inputBox.clear(); // Clear the input box
        });

        deleteButton.setOnAction(event -> {
            if(selectedItem!=-1){
                items.remove(selectedItem);
                selectedItem=-1;
            }
            inputBox.clear(); // Clear the input box
        });

        serialise.setOnAction(event -> {
            try {
                serialisable.serialise(items);
            } catch (IOException e) {
                System.out.println(e);
            }
        });

        deserialise.setOnAction(event ->{
            try {
                items.removeAll();
                items = serialisable.deserialise();
                listView.setItems(items);
            } catch (IOException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
        });

        birthdayToggle.setOnAction((event) -> {
            boolean isChecked = birthdayToggle.isSelected();
            if (isChecked) {
                leto.setVisible(true);
            } else {
                leto.setVisible(false);
            }
        });

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                // get the date picker value
                datum = datePicker.getValue();
                System.out.println(datum);
            }
        };

        datePicker.setOnAction(event);

        // Set the ListView's items to the observable list
        listView.setItems(items);

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                String selectedText = newSelection.toString();
                selectedItem = listView.getSelectionModel().getSelectedIndex();
                System.out.println("Selected item: " + selectedText);
                System.out.println("Selected index: " + selectedItem);
            }
        });
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public CheckBox getBirthdayToggle(){ return birthdayToggle; }

    public TextField getInputBox() {
        return inputBox;
    }

    public TextField getLeto() { return leto; };

    public Button getDisplayButton() {
        return displayButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }
    public Button getSerialise() { return serialise; }
    public Button getDeserialise() { return deserialise; }
    public Label getDisplayLabel() {
        return displayLabel;
    }

    public ListView<Event> getListView() {
        return listView;
    }
}