package gui;

import java.io.IOException;

import business.FreizeitbaederModel;
import javafx.stage.Stage;

public class FreizeitbaederControl {
	private FreizeitbaederModel model;
	private FreizeitbaederView view;
	
	
	public FreizeitbaederControl(Stage primarystage) {
		this.model = new FreizeitbaederModel();
		this.view = new FreizeitbaederView(this , primarystage , model);
		
	}
	
	void schreibeFreizeitbaederInDatei(String typ)  {
		try {
			if("csv".equals(typ)) {
				model.schreibeFreizeitbaederInCsvDatei();
				view.zeigeInformationsfensterAn("Die Freizeitbäder wurden gespeichert!");
			}
			
			else if("txt".equals(typ)) {
			model.schreibeFreizeitbaederInTxtDatei();
			view.zeigeInformationsfensterAn("Die Freizeitbäder wurden gespeichert!");
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

}
