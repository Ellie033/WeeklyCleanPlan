package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane pane = new BorderPane();
        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
       // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        new CleanSchedule().printTable();
        // Put things back
        System.out.flush();
        System.setOut(old);

        Text text=new Text(baos.toString());
        pane.setCenter(text);
        Scene scene = new Scene(pane, 400, 400);
        stage.setTitle("CleanPlan");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}