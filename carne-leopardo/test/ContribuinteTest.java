import static org.junit.Assert.assertEquals;

import org.junit.Test;

import carneleopardo.Contribuinte;
import carneleopardo.Tributo;

public class ContribuinteTest {
    
    @Test
    public void totalPagoEmTributosTest() {
        Contribuinte contribuinte = new Contribuinte("123.456.789-10", "José");
        Tributo tributo = new Tributo(1, "IPTU", 50.0, 2024);
        Tributo tributo2 = new Tributo(2, "IPVA", 120.0, 2024);
        Tributo tributo3 = new Tributo(3, "IR", 110.0, 2023);
        contribuinte.setTributo(tributo);
        contribuinte.setTributo(tributo2);
        contribuinte.setTributo(tributo3);
        assertEquals("170,0", String.format("%.1f", contribuinte.totalPagoAno(2024)));
    }
}
