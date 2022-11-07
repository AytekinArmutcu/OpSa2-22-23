package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Factory.Creator;
import Factory.CsvCreator;
import Factory.Product;
import Factory.TxtCreator;


public class FreizeitbaederModel {
	   // speichert temporaer ein Objekt vom Typ Freizeitbad
    private Freizeitbad freizeitbad;
	
	
	public FreizeitbaederModel() {
		
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
	}

	


}
