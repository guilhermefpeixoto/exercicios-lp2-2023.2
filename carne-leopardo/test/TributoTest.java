import static org.junit.Assert.assertEquals;

import org.junit.Test;

import carneleopardo.Tributo;

public class TributoTest {
    
    @Test
    public void reajustarTributoTest() {
        Tributo tributo = new Tributo(1, "IPTU", 50.0, 2023);
        assertEquals("50,0", String.format("%.1f", tributo.getValorTributacao()));
        tributo.reajustarTributo(1.10, 2024);
        assertEquals("55,0", String.format("%.1f", tributo.getValorTributacao()));
    }
}
