package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import Factory.Creator;
import Factory.CsvCreator;
import Factory.Product;
import Factory.TxtCreator;
import ownUtil.Observable;
import ownUtil.Observer;


public class FreizeitbaederModel implements Observable{
	
    private Freizeitbad freizeitbad;
	private static FreizeitbaederModel instance;
	public Vector <Observer> observers = new Vector<Observer>();
	
	public static FreizeitbaederModel getInstance() {
		if(instance==null)
			instance=new FreizeitbaederModel();
		return instance;
	}
	
	private FreizeitbaederModel() {
		
	}
	
	public String getueberschrift() {
		return "Verwaltung von Freizeitbädern";
	}
	
	
	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		Creator creator = new CsvCreator();
		Product writer = creator.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
	}
	
	public void schreibeFreizeitbaederInTxtDatei() throws IOException {
		Creator creator = new TxtCreator();
		Product writer = creator.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
	}
	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}


	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
		notifyObservers();
	}

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.addElement(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.removeElement(obs);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(int i=0;i<observers.size();i++)
			this.observers.elementAt(i).update();
	}

	


}
