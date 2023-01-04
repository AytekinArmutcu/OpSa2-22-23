package com.example.demo.business.sporthalle;

import com.example.demo.business.FreizeitbaederModel;
import com.example.demo.ownUtil.PlausiException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SporthallenModel {

    private ArrayList<Sporthalle> sporthallen = new ArrayList<>();
    private static SporthallenModel instance;

    public static SporthallenModel getInstance() {
        if(instance==null)
            instance=new SporthallenModel();
        return instance;
    }

    private SporthallenModel(){}

    public String getueberschrift() {
        return "Verwaltung von Sporthallen";
    }

    public void leseSporthallenAusCsvDatei()
            throws IOException, PlausiException {
        BufferedReader ein = new BufferedReader(
                new FileReader("Sporthallen.csv"));
        ArrayList<Sporthalle> ergebnis = new ArrayList<>();
        String zeileStr = ein.readLine();
        while(zeileStr != null) {
            String[] zeile = zeileStr.split(";");
            ergebnis.add(
                    new Sporthalle(zeile[0], zeile[1], zeile[2]));
            zeileStr = ein.readLine();
        }
        ein.close();
        this.sporthallen = ergebnis;
    }

    public ArrayList<Sporthalle> getSporthallen() {
        return sporthallen;
    }

    public void setSporthallen(ArrayList<Sporthalle> sporthallen) {
        this.sporthallen = sporthallen;
    }
}

