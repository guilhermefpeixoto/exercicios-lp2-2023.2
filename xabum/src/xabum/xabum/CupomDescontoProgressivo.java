package xabum;

public class CupomDescontoProgressivo extends Cupom {
  public CupomDescontoProgressivo() {
    super();
  }

  @Override
  public double aplicaCupom(double valorTotal) {
    double newValorTotal = 0;
    if (valorTotal < 100) {
      newValorTotal =  valorTotal * 0.99;
    }
    else if (valorTotal < 500) {
      newValorTotal = valorTotal * 0.95;
    }
    else {
      newValorTotal = valorTotal * 0.90;
    }
    
    return newValorTotal;
  }

  @Override
  public String toString() {
    return "Desconto Progressivo, 1%, 5% ou 10%";
  }
}
