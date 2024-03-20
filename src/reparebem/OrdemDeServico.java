package reparebem;

public class OrdemDeServico {
    private static int idCount;
    private int id;
    private String cliente;
    private String telefone;
    private String roupa;
    private Reparo[] reparos;
    private int qtdReparos;
    private String status;

    public OrdemDeServico(String cliente, String telefone, String roupa) {
        this.id = ++idCount;    
        this.cliente = cliente;
        this.telefone = telefone;
        this.roupa = roupa;
        this.reparos = new Reparo[10];
        this.qtdReparos = 0;
        this.status = "Não Iniciada";
    }

    public int getId() {
        return this.id;
    }

    public void setReparo(Reparo reparo) {
        if (this.qtdReparos < 10) {
            this.reparos[this.qtdReparos++] = reparo;
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double calculaPreco() {
        double preco = 0;
        
        if (qtdReparos >= 1) {
            for (int i = 0; i < qtdReparos; i++) {
                preco += this.reparos[i].getPreco();
            }
        }

        return preco; 
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return String.format("#%d; cliente: %s; roupa: %s; reparos: %d; total: R$%.2f", this.id, this.cliente, this.roupa, this.qtdReparos, this.calculaPreco());
    }
}
