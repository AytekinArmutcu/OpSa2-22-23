package com.example.demo.gui.guiSportstaetten;

import com.example.demo.business.FreizeitbaederModel;
import com.example.demo.business.sporthalle.SporthallenModel;
import com.example.demo.ownUtil.Observer;
import javafx.stage.Stage;

public class SportstaettenControl implements Observer {

    private FreizeitbaederModel model;
    private SportstaettenView view;
    private SporthallenModel sModel;

    public SportstaettenControl(Stage fensterSportstaetten) {
        this.model = FreizeitbaederModel.getInstance();
        this.sModel = SporthallenModel.getInstance();
        this.view = new SportstaettenView(this , fensterSportstaetten , model,sModel);
        this.model.addObserver(this);

    }

    @Override
    public void update() {
    this.view.zeigeFreizeitbaederAn();
    }
}
