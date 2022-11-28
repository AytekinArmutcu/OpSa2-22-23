package guiFreizeitbaeder;

import java.io.IOException;

import business.FreizeitbaederModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class FreizeitbaederControl implements Observer {
	private FreizeitbaederModel model;
	private FreizeitbaederView view;
	
	
	public FreizeitbaederControl(Stage primarystage) {
		this.model = FreizeitbaederModel.getInstance();
		this.view = new FreizeitbaederView(this , primarystage , model);
	//	this.model.addObserver(this);
		
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.view.zeigeFreizeitbaederAn();
	}

}
