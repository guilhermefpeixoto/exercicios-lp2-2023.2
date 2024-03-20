import static org.junit.Assert.assertEquals;

import org.junit.Test;

import reparebem.*;

public class ReparoTest {
    
    @Test
    public void reajustarPrecoReparoTest() {
        Reparo reparo = new Reparo("reparo 1", "costura saia", 20.0);
        assertEquals("20.0", String.valueOf(reparo.getPreco()));
        reparo.setPreco(1.2);
        assertEquals("24.0", String.valueOf(reparo.getPreco()));
    }

}
