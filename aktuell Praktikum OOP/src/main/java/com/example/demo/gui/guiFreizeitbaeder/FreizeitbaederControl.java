package com.example.demo.gui.guiFreizeitbaeder;

import java.io.IOException;

import com.example.demo.business.FreizeitbaederModel;
import com.example.demo.ownUtil.Observer;
import javafx.stage.Stage;

public class FreizeitbaederControl implements Observer {

	private FreizeitbaederModel model;
	private FreizeitbaederView view;
	
	
	public FreizeitbaederControl(Stage primarystage) {
		this.model = FreizeitbaederModel.getInstance();
		this.view = new FreizeitbaederView(this , primarystage , model);
		this.model.addObserver(this);
	}
	
	void schreibeFreizeitbaederInDatei(String typ)  {
		try {
			if("csv".equals(typ)) {
				model.schreibeFreizeitbaederInCsvDatei();
				view.zeigeInformationsfensterAn("Die Freizeitb�der wurden gespeichert!");
			}
			
			else if("txt".equals(typ)) {
			model.schreibeFreizeitbaederInTxtDatei();
			view.zeigeInformationsfensterAn("Die Freizeitb�der wurden gespeichert!");
			}
			else {
				view.zeigeInformationsfensterAn("noch nicht implementiert");
			}
		}
		catch(IOException exc) {
			view.zeigeFehlermeldungsfensterAn("Exception", "IOException beim speichern");
			
		}
		catch(Exception exc) {
			view.zeigeFehlermeldungsfensterAn("Speichungsfehler", "Unbekannter Fehler beim Speichern!");
		}
	}

	@Override
	public void update() {
		this.view.zeigeFreizeitbaederAn();
	}
}
