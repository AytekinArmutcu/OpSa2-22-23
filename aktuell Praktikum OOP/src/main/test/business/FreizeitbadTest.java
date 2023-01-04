package business;

import com.example.demo.business.Freizeitbad;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class FreizeitbadTest {

    Freizeitbad freizeitbad;

    @BeforeEach
    void setUp() throws Exception{
        this.freizeitbad = new Freizeitbad("stadtbad","7.00","17.00","25","24");
    }

    @AfterEach
    void tearDown() throws Exception{
        this.freizeitbad = null;
    }
    @Test
    void test(){
        assertTrue(()->freizeitbad.getBeckenlaenge() == 25, "Das muss 25 sein");
    }
}
