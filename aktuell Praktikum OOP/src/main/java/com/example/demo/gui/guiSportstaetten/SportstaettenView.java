package com.example.demo.gui.guiSportstaetten;


import com.example.demo.business.Freizeitbad;
import com.example.demo.business.FreizeitbaederModel;
import com.example.demo.business.sporthalle.Sporthalle;
import com.example.demo.business.sporthalle.SporthallenModel;
import com.example.demo.gui.guiFreizeitbaeder.FreizeitbaederControl;
import com.example.demo.ownUtil.MeldungsfensterAnzeiger;
import com.example.demo.ownUtil.PlausiException;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class SportstaettenView {

    // Hier ergaenzen
    private FreizeitbaederModel model;
    private SportstaettenControl control;
    private SporthallenModel sModel;

    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane = new  Pane();
    private Label lblAnzeigeFreizeitbaeder = new Label("Anzeige Freizeitbäder");
    private TextArea txtAnzeigeFreizeitbaeder  = new TextArea();
    private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
    private Label lblAnzeigeSporthalle = new Label("Anzeige Sporthalle");
    private TextArea txtAnzeigeSporthalle = new TextArea();
    private Button btnAnzeigeSporthalle = new Button("Csv - import Anzeige");
    private MenuBar mnbrMenuLeiste  	= new MenuBar();
    private Menu mnExport            	= new Menu("Export");
    private MenuItem mnItmCsvExport 	= new MenuItem("csv-Export");
    private MenuItem mnItmTxtExport 	= new MenuItem("txt-Export");
    private MenuBar mnbrMenuLeiste2 	= new MenuBar();
    private Menu mnImport           	= new Menu("Import");
    private MenuItem mnItmCsvImport 	= new MenuItem("csv-Import - Sporthalle");
    private MenuItem mnItmTxtImport 	= new MenuItem("txt-Import");
    //-------Ende Attribute der grafischen Oberflaeche-------

    public SportstaettenView(SportstaettenControl control, Stage primaryStage , FreizeitbaederModel model,SporthallenModel sporthallenModel){
        Scene scene = new Scene(this.pane, 560, 340);
        primaryStage.setScene(scene);
        primaryStage.setTitle(sporthallenModel.getueberschrift());
        primaryStage.show();
        // Hier ergaenzen
        this.control = control;
        this.model = model;
        this.sModel = sporthallenModel;
        this.initKomponentenFreizeibaeder();
        this.initKomponentenSporthallen();

        this.initListenerFreizeitbaeder();
        this.initListenerSporthallen();
        this.initMenu();
        this.initMenuListener();
    }

    private void initMenuListener() {

        mnItmCsvImport.setOnAction(e-> {
            try {
                zeigeSporthallenAn();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (PlausiException ex) {
                ex.printStackTrace();
            }
        });
        mnItmTxtImport.setOnAction(e-> {
            try {
                zeigeSporthallenAn();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (PlausiException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void initMenu() {
        // Menu
        this.mnbrMenuLeiste.getMenus().addAll(mnExport,mnImport);
        this.mnExport.getItems().add(mnItmCsvExport);
        this.mnExport.getItems().add(mnItmTxtExport);
        this.mnImport.getItems().add(mnItmCsvImport);
        this.mnImport.getItems().add(mnItmTxtImport);
        pane.getChildren().add(mnbrMenuLeiste);


    }

    private void initKomponentenFreizeibaeder(){
        // Label
        Font font = new Font("Arial", 20);
        lblAnzeigeFreizeitbaeder.setLayoutX(310);
        lblAnzeigeFreizeitbaeder.setLayoutY(40);
        lblAnzeigeFreizeitbaeder.setFont(font);
        lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;");
        pane.getChildren().add(lblAnzeigeFreizeitbaeder);
        // Textbereich
        txtAnzeigeFreizeitbaeder.setEditable(false);
        txtAnzeigeFreizeitbaeder.setLayoutX(310);
        txtAnzeigeFreizeitbaeder.setLayoutY(90);
        txtAnzeigeFreizeitbaeder.setPrefWidth(220);
        txtAnzeigeFreizeitbaeder.setPrefHeight(185);
        pane.getChildren().add(txtAnzeigeFreizeitbaeder);
        // Button
        btnAnzeigeFreizeitbaeder.setLayoutX(310);
        btnAnzeigeFreizeitbaeder.setLayoutY(290);
        pane.getChildren().add(btnAnzeigeFreizeitbaeder);
    }

    private void initKomponentenSporthallen(){
        // Label
        Font font = new Font("Arial", 20);
        lblAnzeigeSporthalle.setLayoutX(10);
        lblAnzeigeSporthalle.setLayoutY(40);
        lblAnzeigeSporthalle.setFont(font);
        lblAnzeigeSporthalle.setStyle("-fx-font-weight: bold;");
        pane.getChildren().add(lblAnzeigeSporthalle);
        // Textbereich
        txtAnzeigeSporthalle.setEditable(false);
        txtAnzeigeSporthalle.setLayoutX(10);
        txtAnzeigeSporthalle.setLayoutY(90);
        txtAnzeigeSporthalle.setPrefWidth(220);
        txtAnzeigeSporthalle.setPrefHeight(185);
        pane.getChildren().add(txtAnzeigeSporthalle);
        // Button
        btnAnzeigeSporthalle.setLayoutX(110);
        btnAnzeigeSporthalle.setLayoutY(290);
        pane.getChildren().add(btnAnzeigeSporthalle);
    }

    private void initListenerFreizeitbaeder() {
        btnAnzeigeFreizeitbaeder.setOnAction(e->zeigeFreizeitbaederAn());
    }

    private void initListenerSporthallen() {
        btnAnzeigeSporthalle.setOnAction(e-> {
            try {
                zeigeSporthallenAn();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (PlausiException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void zeigeSporthallenAn() throws IOException, PlausiException {
        sModel.leseSporthallenAusCsvDatei();
        if(sModel.getSporthallen().size() > 0){
            StringBuffer text = new StringBuffer();
            // Ergaenzen: for each – Schleife ueber ArrayList
            for(Sporthalle sh : sModel.getSporthallen())
            {
                text.append(sh.gibSporthalleZurueck(' ') + "\n");
            }
            this.txtAnzeigeSporthalle.setText(text.toString());
        }
        else{
            zeigeInformationsfensterAn(
                    "Bisher wurde kein Sporthalle aufgenommen!");
        }
    }

    public void zeigeFreizeitbaederAn(){
        if(model.getFreizeitbaeder().size() > 0){
            StringBuffer text = new StringBuffer();
            // Ergaenzen: for each – Schleife ueber ArrayList
            for(Freizeitbad fzb : model.getFreizeitbaeder())
            {
                text.append(fzb.gibFreizeitbadZurueck(' ') + "\n");
            }
            this.txtAnzeigeFreizeitbaeder.setText(text.toString());
        }
        else{
            zeigeInformationsfensterAn(
                    "Bisher wurde kein Freizeitbad aufgenommen!");
        }
    }


    private void zeigeInformationsfensterAn(String meldung){
        new MeldungsfensterAnzeiger(Alert.AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
    }

}
