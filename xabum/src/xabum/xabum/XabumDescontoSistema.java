package xabum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XabumDescontoSistema {
  private Map<String, Usuario> usuarios;
  private List<Cupom> cupons;

  public XabumDescontoSistema() {
    this.usuarios = new HashMap<String, Usuario>();
    this.cupons = new ArrayList<Cupom>();
  }

  public String criaCupomFreteGratis(double maxDesconto) {
    Cupom cupom = new CupomFreteGratis(maxDesconto);
    this.cupons.add(cupom);
    return "Cupom de Frete Grátis adicionado!";
  }

  public String criaCupomFreteGratis() {
    Cupom cupom = new CupomFreteGratis(0);
    this.cupons.add(cupom);
    return "Cupom de Frete Grátis adicionado!";
  }

  public String criaCupomDescontoFixo(double percentualDesconto, double maxDesconto) {
    Cupom cupom = new CupomDescontoFixo(percentualDesconto, maxDesconto);
    this.cupons.add(cupom);
    return "Cupom de Desconto Fixo adicionado!";
  }

  public String criaCupomDescontoProgressivo() {
    Cupom cupom = new CupomDescontoProgressivo();
    this.cupons.add(cupom);
    return "Cupom de Desconto Progressivo adicionado!";
  }

  public String adicionaUsuario(String cpf, String nome) {
    if (cpf.trim().equals("") || nome.trim().equals("")) {
      throw new IllegalArgumentException("Cpf ou nome vazio!");
    }

    if (cpf == null || nome == null) {
      throw new NullPointerException("Cpf e nome não podem ser nulls");
    }

    Usuario usuario = new Usuario(cpf, nome);
    this.usuarios.put(cpf, usuario);
    return "Usuário adicionado!";
  }

  public String addCupomUsuario(String cpf, int indexCupom) {
    Usuario usuario = this.usuarios.get(cpf);
    Cupom cupom = this.cupons.get(indexCupom);
    usuario.adicionaCupom(cupom);
    this.cupons.remove(indexCupom);
    return "Cupom adicionado ao usuário!";
  }

  public String aplicarDescontoCompra(Compra minhaCompra, int indexCupomUsuario) {
    Usuario usuario = this.usuarios.get(minhaCompra.getCpf());
    Cupom cupom = usuario.getCupom(indexCupomUsuario);
    if (cupom instanceof CupomFreteGratis) {
      minhaCompra.setValorFrete(cupom.aplicaCupom(minhaCompra.getValorFrete()));
    }
    else {
      minhaCompra.setValorTotal(cupom.aplicaCupom(minhaCompra.getValorTotal()));
    }

    usuario.usaCupom();
    return "Desconto aplicado!";
  }

  public String listarCuponsUsuario(String cpf) {
    Usuario usuario = this.usuarios.get(cpf);
    String str = usuario.toString() + "\n\n";
    str += String.valueOf(usuario.getQtdCupons()) + " cupons - " + String.valueOf(usuario.getQtdCupons() - usuario.getCuponsUtilizados()) + " ativos";
    return str;
  }
}