package carneleopardo;

import java.util.Objects;

public class Tributo {
    private int codigo;
    private String descricao;
    private double valorTributacao;
    private int anoBase;
    private boolean status;

    public Tributo(int codigo, String descricao, double valorTributacao, int anoBase) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorTributacao = valorTributacao;
        this.anoBase = anoBase;
        this.status = false;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void reajustarTributo(double percentual, int anoBase) {
        this.valorTributacao *= percentual;
        this.anoBase = anoBase;
    }

    public double getValorTributacao() {
        return this.valorTributacao;
    }

    public int getAno() {
        return this.anoBase;
    }

    public void setStatus() {
        this.status = true;
    }

    public boolean getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return String.format("| Tributo: (%d) %s - Valor: R$%.2f; Ano Base: %d |", this.codigo, this.descricao, this.valorTributacao, this.anoBase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Tributo other = (Tributo) obj;
        return codigo == other.codigo;
    }
}
