package com.example.demo.main;


import com.example.demo.gui.guiFreizeitbaeder.FreizeitbaederControl;
import com.example.demo.gui.guiSportstaetten.SportstaettenControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
// Fenster zu Freizeitbaedern
		new FreizeitbaederControl(primaryStage);
// Fenster zu Sportstaettten
		Stage fensterSportstaetten = new Stage();
		new SportstaettenControl(fensterSportstaetten);
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
