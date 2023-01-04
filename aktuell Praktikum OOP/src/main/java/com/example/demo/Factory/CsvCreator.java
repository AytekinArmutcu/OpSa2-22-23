package com.example.demo.Factory;

import java.io.IOException;

public class CsvCreator extends Creator{

	@Override
	public Product factoryMethod() throws IOException {
		// TODO Auto-generated method stub
		return new CsvProduct();
	}
	

}
