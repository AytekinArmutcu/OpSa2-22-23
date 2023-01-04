package com.example.demo.Factory;

import com.example.demo.business.Freizeitbad;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvProduct extends Product {
	BufferedWriter aus;
	
	public CsvProduct() throws IOException{
		 aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv",true));

	}
	@Override
	public void fuegeInDateiHinzu(Object obj) throws IOException {

		Freizeitbad freizeitbad = (Freizeitbad)obj;
		aus.write(freizeitbad.gibFreizeitbadZurueck(';'));
		aus.newLine();
	}

	@Override
	public void schliesseDatei() throws IOException {
		// TODO Auto-generated method stub
		aus.close();
	}

}
