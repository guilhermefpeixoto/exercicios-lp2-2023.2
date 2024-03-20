package reparebem;

public class OrdemDeServico {
    private static int idCount;
    private int id;
    private String nome;
    private String telefone;
    private String roupa;
    private Reparo[] reparos;
    private int qtdReparos;
    private double preco;
    private String status;

    public OrdemDeServico(String cliente, String telefone, String roupa) {
        this.id = ++idCount;    
        this.nome = cliente;
        this.telefone = telefone;
        this.roupa = roupa;
        this.reparos = new Reparo[10];
        this.qtdReparos = 0;
        this.preco = 0.0;
        this.status = "Não Iniciada";
    }

    public int getId() {
        return this.id;
    }

    public void setReparo(Reparo reparo) {
        if (this.qtdReparos < 10) {
            this.reparos[this.qtdReparos++] = reparo;
            this.setPreco();
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private void setPreco() {
        this.preco += this.reparos[qtdReparos - 1].getPreco();
    }

    public double getPreco() {
        return this.preco;
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "#" + String.valueOf(this.id) + ";" + "cliente:" + this.nome + ";" + "roupa: " + this.roupa + ";" + "reparos: " + String.valueOf(qtdReparos) + "total: R$" + String.valueOf(preco); 
    }
}
