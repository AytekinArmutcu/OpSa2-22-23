package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FreizeitbadTest {

	Freizeitbad freizeitbad;
	
	@BeforeEach
	void setUp() throws Exception {
		freizeitbad = new Freizeitbad("Stadtbad", "7.00","17.00","25","24");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		freizeitbad = null;
	}

	@Test
	void test() {
		assertTrue(()->freizeitbad.getBeckenlaenge()==25,"Das sollte 25 sein");
	}

}
