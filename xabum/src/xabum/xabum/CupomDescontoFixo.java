package xabum;

public class CupomDescontoFixo extends Cupom {
  private double percentualDesconto;
  private double maxDesconto;

  public CupomDescontoFixo(double percentualDesconto, double maxDesconto) {
    super();
    this.percentualDesconto = percentualDesconto;
    this.maxDesconto = maxDesconto;
  }

  @Override
  public double aplicaCupom(double valorTotal) {
    double desconto = this.percentualDesconto * valorTotal;
    if (desconto > this.maxDesconto) {
      return valorTotal -= this.maxDesconto;
    }
    else {
      return valorTotal -= desconto;
    }
  }

  @Override
  public String toString() {
    return "Desconto Fixo de " + String.valueOf(this.percentualDesconto) + "%,  até no máximo R$" + String.valueOf(this.maxDesconto);
  }
}
