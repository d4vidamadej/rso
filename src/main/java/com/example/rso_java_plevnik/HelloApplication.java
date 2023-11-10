package com.example.rso_java_plevnik;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Display display = new Display();
        MenuBar menuBar = new MenuBar();
        Menu viewMenu = new Menu("View");
        MenuItem displayItem = new MenuItem("Display View");
        MenuItem inputBoxes = new MenuItem("Input View");

        VBox root = new VBox(10, menuBar, display.getInputBox(), display.getDatePicker(), display.getBirthdayToggle(), display.getLeto(), display.getDisplayButton(), display.getDisplayLabel(),display.getListView(), display.getDeleteButton(), display.getSerialise(), display.getDeserialise());

        displayItem.setOnAction(event -> {
            root.getChildren().set(1, display.getInputBox());
            root.getChildren().set(2, display.getDatePicker());
            root.getChildren().set(3, display.getDisplayButton());
            root.getChildren().set(4, display.getDisplayLabel());
        });

        /*inputBoxes.setOnAction(event -> {
            root.getChildren().set(1, input.getInputLabels());
            root.getChildren().remove(2); // Remove Display button
            root.getChildren().remove(3); // Remove Display label
        });*/

        stage.setScene(new Scene(root, 800, 600));
        stage.setTitle("Text Display");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}