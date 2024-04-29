package xabum;

public class CupomFreteGratis extends Cupom {
  private double descontoMaximo;

  public CupomFreteGratis(double descontoMaximo) {
    super();
    this.descontoMaximo = descontoMaximo;
  }

  @Override
  public double aplicaCupom(double valorFrete) {
    if (descontoMaximo == 0) {
      return 0.0;
    }
    else {
      return valorFrete -= descontoMaximo;
    }
  } 

  public double getDescontoMaximo() {
    return this.descontoMaximo;
  }

  @Override
  public String toString() {
    String str = "";
    if (descontoMaximo == 0) {
      str = "FreteGratis";
    }
    else {
      str = "Desconto de até R$" + String.valueOf(this.descontoMaximo) + " no Frete"; 
    }

    return str;
  }
}
