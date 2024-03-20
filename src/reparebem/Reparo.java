package reparebem;

public class Reparo {
    private String idTextual;
    private String descricao;
    private double preco;

    public Reparo(String id, String descricao, double preco) {
        this.idTextual = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getId() {
        return this.idTextual;
    }

    public void setPreco(double percentual) {
        this.preco = preco * percentual;
    }

    public double getPreco() {
        return this.preco;
    }
}