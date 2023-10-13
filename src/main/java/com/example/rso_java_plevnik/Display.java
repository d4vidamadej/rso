package com.example.rso_java_plevnik;

package com.example.rso_java_mh;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Display {
    private TextField inputBox;

    private TextField matija;
    private TextField david;
    private TextField luka;
    private Button displayButton;
    private Button deleteButton;
    private Label displayLabel;
    private ListView<String> listView;
    private ObservableList<String> items;
    private int selectedItem=-1;

    public Display() {
        inputBox = new TextField();
        displayButton = new Button("Add");
        deleteButton = new Button("Delete");
        displayLabel = new Label();
        listView = new ListView<>();
        items = FXCollections.observableArrayList(); // Initialize the observable list

        displayButton.setOnAction(event -> {
            String text = inputBox.getText();
            displayLabel.setText(text);
            System.out.println(text);


            items.add(text);
            inputBox.clear();
        });

        deleteButton.setOnAction(event -> {
            if(selectedItem!=-1){
                items.remove(selectedItem);
                selectedItem=-1;
            }
            inputBox.clear();
        });

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

    public TextField getInputBox() {
        return inputBox;
    }

    public Button getDisplayButton() {
        return displayButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Label getDisplayLabel() {
        return displayLabel;
    }

    public ListView<String> getListView() {
        return listView;
    }
}