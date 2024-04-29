package xabum;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private String cpf;
  private String nome;
  private List<Cupom> cupons;
  private int cuponsUtilizados;

  public Usuario(String cpf, String nome) {
    this.cpf = cpf;
    this.nome = nome;
    this.cupons = new ArrayList<Cupom>();
  }

  public boolean adicionaCupom(Cupom cupom) {
    return this.cupons.add(cupom);
  }

  public Cupom getCupom(int indexCupom) {
    return this.cupons.get(indexCupom);
  }

  public void usaCupom() {
    this.cuponsUtilizados++;
  }

  public int getCuponsUtilizados() {
    return this.cuponsUtilizados;
  }

  public int getQtdCupons() {
    return this.cupons.size();
  }

  @Override
  public String toString() {
    return this.nome + " - " + this.cpf;
  }
}