package reparebem;

public class RepareBem {
    private final int MAX_REPAROS = 100;
    private final int MAX_OS = 500;
    private Reparo[] reparos;
    private int qtdReparos;
    private OrdemDeServico[] ordensDeServico;
    private int qtdOs;

    public RepareBem() {
        this.reparos = new Reparo[MAX_REPAROS];
        this.ordensDeServico = new OrdemDeServico[MAX_OS];
    }

    public void cadastrarReparo(String id, String descricao, double preco) {
        if (this.qtdReparos == this.MAX_REPAROS) {
            return;
        }

        for (int i = 0; i < this.qtdReparos; i++) {
           if (this.reparos[i].getId().equals(id)) {
            return;
           }
        }

        Reparo reparo = new Reparo(id, descricao, preco);
        this.reparos[qtdReparos++] = reparo;
    }

    public void reajustarPrecoReparo(String idReparo, double percentual) {
        for (int i = 0; i < this.qtdReparos; i++) {
            if (this.reparos[i].getId().equals(idReparo)) {
                this.reparos[i].setPreco(percentual);
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    public int cadastrarOrdemDeServico(String cliente, String telefone, String roupa) {
        if (this.qtdOs == this.MAX_OS) {
            return -1;
        }

        OrdemDeServico os = new OrdemDeServico(cliente, telefone, roupa);
        this.ordensDeServico[qtdOs++] = os;

        return os.getId();
    }

    public String exibirOrdemDeServico(int idOs) {
        OrdemDeServico os = this.ordensDeServico[idOs - 1];

        if (os != null) {
            return os.toString();
        }

        throw new IllegalArgumentException();
    }
    
    public void incluirReparoOrdemDeServico(int idOS, String idReparo) {
        OrdemDeServico os = this.ordensDeServico[idOS - 1];

        if (os != null) {
            for (int i = 0; i < qtdReparos; i++) {
                if (this.reparos[i].getId().equals(idReparo)) {
                    os.setReparo(this.reparos[i]);
                    return;
                }
            }
        }

        throw new IllegalArgumentException();
    }

    public void mudarStatusOrdemDeServico(int idOS, String status) {
        OrdemDeServico os = this.ordensDeServico[idOS - 1];

        if (os != null) {
            os.setStatus(status);
        }

        throw new IllegalArgumentException();
    }

    public double obterValorOrdemDeServico(int idOS) {
        OrdemDeServico os = this.ordensDeServico[idOS - 1];
        if (os != null) {
            return os.calculaPreco();
        }

        throw new IllegalArgumentException();
    }

    public String listarOrdensDeServico(String status) {
        String oss = "Ordens de Serviço - " + status + "\n\n";

        for (int i = 0; i < qtdOs; i++) {
            if (this.ordensDeServico[i].getStatus().equals(status)) {
                oss += this.ordensDeServico[i].toString() + "\n";
            }
        }

        return oss;
    }

    public String listarOrdensDeServico() {
        String oss = "";

        for (int i = 0; i < qtdOs; i++) {
            if (i == this.qtdOs - 1) {
                oss += this.ordensDeServico[i].toString();
            }
            else {
                oss += this.ordensDeServico[i].toString() + "\n";
            }
        }
        
        return oss;
    }
}