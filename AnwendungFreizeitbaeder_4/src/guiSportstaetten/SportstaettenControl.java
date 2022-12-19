package guiSportstaetten;

import business.FreizeitbaederModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class SportstaettenControl implements Observer {
	
	private FreizeitbaederModel model;
	private SportstaettenView view;
	
	
	public SportstaettenControl(Stage primarystage) {
		this.model = FreizeitbaederModel.getInstance();
		this.view = new SportstaettenView(this , primarystage , model);
		this.model.addObserver(this);
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.view.zeigeFreizeitbaederAn();
	}
	
	

}
