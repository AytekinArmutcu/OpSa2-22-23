package Factory;

import java.io.IOException;

public class TxtCreator extends Creator {

	@Override
	public Product factoryMethod() throws IOException {
		// TODO Auto-generated method stub
		return new TxtProduct();
	}

}
