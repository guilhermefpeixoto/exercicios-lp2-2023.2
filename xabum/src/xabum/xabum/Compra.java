package xabum;

public class Compra {
  private int codigoCompra;
  private String cpf;
  private double valorTotal;
  private double valorFrete;

  public Compra(int codigoCompra, String cpf, double valorTotal, double valorFrete) {
    this.codigoCompra = codigoCompra;
    this.cpf = cpf;
    this.valorTotal = valorTotal;
    this.valorFrete = valorFrete;
  }

  public String getCpf() {
    return this.cpf;
  } 

  public double getValorFrete() {
    return this.valorFrete;
  }

  public double getValorTotal() {
    return this.valorTotal;
  }

  public void setValorFrete(double newValorFrete) {
    this.valorFrete = newValorFrete;
  }

  public void setValorTotal(double newValorTotal) {
    this.valorTotal = newValorTotal;
  }
}