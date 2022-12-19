package Factory;

import java.io.IOException;

public abstract class Product {
	
	public abstract void fuegeInDateiHinzu(Object obj) throws IOException;
	
	public abstract void schliesseDatei() throws IOException;
	
}
