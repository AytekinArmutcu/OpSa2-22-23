package Factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class TxtProduct extends Product {

	BufferedWriter aus;
	
	public TxtProduct() throws IOException{
		 aus = new BufferedWriter(new FileWriter("Freizeitbaeder.txt",true));
	}
	
	@Override
	public void fuegeInDateiHinzu(Object obj) throws IOException {
		// TODO Auto-generated method stub
		Freizeitbad freizeitbad = (Freizeitbad)obj;
		aus.write("Daten des Freizeitbades\n");
		aus.write("Name des Freizeitbads: \t\t\t"+ freizeitbad.getName()+ "\n");
		aus.write("Öffnungszeit des Freizeitbads: \t\t"+ freizeitbad.getGeoeffnetVon()+ " -- "+ freizeitbad.getGeoeffnetBis()+ "\n");
		aus.write("Beckenlänge des Freizeitbbads: \t\t"+ freizeitbad.getBeckenlaenge()+ "\n");
		aus.write("Wassertemperatur des Freizeitbbads: \t"+ freizeitbad.getTemperatur()+ "\n");

		aus.newLine();
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		aus.close();
	}

}
