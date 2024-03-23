package carneleopardo;

import java.util.Objects;

public class Contribuinte {
    private String cpf;
    private String nome;
    private String telefone;
    private int contadorTributo;
    private Tributo[] tributos;

    public Contribuinte(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.tributos = new Tributo[60];
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setTributo(Tributo tributo) {
        if (this.contadorTributo < 60) {
            this.tributos[this.contadorTributo++] = tributo;
        }
    }

    public double totalPagoAno(int ano) {
        double totalPago = 0;
        for (int i = 0; i < this.contadorTributo; i++) {
            if (this.tributos[i].getAno() == ano) {
                totalPago += this.tributos[i].getValorTributacao();
            }
        }

        return totalPago;
    }

    public boolean pagarTributo(int tributo) {
        if (this.contadorTributo > 0) {
            for (int i = 0; i < this.contadorTributo; i++) {
                if (this.tributos[i].getCodigo() == tributo) {
                    this.tributos[i].setStatus();
                    return true;
                }
            }
        }

        return false;
    }

    public String emitirExtrato() {
        String extrato = "";

        if (this.contadorTributo == 0) {
            return "| EXTRATO VAZIO |";
        }

        extrato = "| Pago? " + this.toString() + "\n";

        for (int i = 0; i < this.contadorTributo; i++) {
            if (this.tributos[i].getStatus()) {
                extrato += "| SIM " + this.tributos[i].toString() + "\n";
            }
            else {
                extrato += "| NÃO " + this.tributos[i].toString() + "\n";
            }
        }

        return extrato;
    }

    @Override
    public String toString() {
        return String.format("| Contribuinte: %s - CPF: %s - Contato: %s |", this.nome, this.cpf, this.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Contribuinte other = (Contribuinte) obj;
        return Objects.equals(cpf, other.cpf);
    }
}
