import static org.junit.Assert.assertEquals;

import org.junit.Test;

import reparebem.*;

public class OrdemDeServicoTest {
    
    @Test
    public void mudarStatusOrdemServicoTest() {
        OrdemDeServico os = new OrdemDeServico("Guilherme", "12345", "camisa");
        assertEquals("Não Iniciada", os.getStatus());
        os.setStatus("Concluído");
        assertEquals("Concluído", os.getStatus());
    }
}
