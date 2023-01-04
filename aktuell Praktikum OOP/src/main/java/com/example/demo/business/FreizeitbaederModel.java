package com.example.demo.business;

import com.example.demo.Factory.Creator;
import com.example.demo.Factory.CsvCreator;
import com.example.demo.Factory.Product;
import com.example.demo.Factory.TxtCreator;
import com.example.demo.ownUtil.Observable;
import com.example.demo.ownUtil.Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;


public class FreizeitbaederModel implements Observable {

	// speichert temporaer ein Objekt vom Typ Freizeitbad
    private ArrayList <Freizeitbad> freizeitbaeder = new ArrayList<>();
	private static FreizeitbaederModel instance;
	private Vector<Observer>observer = new Vector<Observer>();


	public static FreizeitbaederModel getInstance() {
		if(instance==null)
			instance=new FreizeitbaederModel();
		return instance;
	}

	private FreizeitbaederModel() {
		
	}
	
	public String getueberschrift() {
		return "Verwaltung von Freizeitb�dern";
	}
	
	
	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		Creator creator = new CsvCreator();
		Product writer = creator.factoryMethod();
		for(Freizeitbad freizeitbad : freizeitbaeder)
		writer.fuegeInDateiHinzu(freizeitbad);
		writer.schliesseDatei();
	}
	
	public void schreibeFreizeitbaederInTxtDatei() throws IOException {
		Creator creator = new TxtCreator();
		Product writer = creator.factoryMethod();
		for(Freizeitbad freizeitbad : freizeitbaeder)
			writer.fuegeInDateiHinzu(freizeitbad);
		writer.schliesseDatei();
	}

	public ArrayList<Freizeitbad> getFreizeitbaeder() {
		return freizeitbaeder;
	}

	public void addFreizeitbad(Freizeitbad freizeitbad){
		freizeitbaeder.add(freizeitbad);
		notifyObserver();
	}

	@Override
	public void addObserver(Observer observer) {
		this.observer.addElement(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observer.removeElement(observer);
	}

	@Override
	public void notifyObserver() {
		for(int i=0;i<observer.size();i++){
			this.observer.elementAt(i).update();
		}
	}
}
