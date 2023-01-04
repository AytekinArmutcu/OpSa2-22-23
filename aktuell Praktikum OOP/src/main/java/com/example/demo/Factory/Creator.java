package com.example.demo.Factory;

import com.example.demo.Factory.Product;

import java.io.IOException;

public abstract class Creator {
	
	public abstract Product factoryMethod() throws IOException;

}
