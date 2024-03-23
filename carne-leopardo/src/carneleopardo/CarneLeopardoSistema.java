package carneleopardo;

public class CarneLeopardoSistema {
    private final int MAX_CONTRIBUINTES = 100;
    private final int MAX_TRIBUTOS = 60;
    private int contadorContribuinte;
    private int contadorTributos;
    private Contribuinte[] contribuintes;
    private Tributo[] tributos;

    public CarneLeopardoSistema() {
        this.contribuintes = new Contribuinte[this.MAX_CONTRIBUINTES];
        this.tributos = new Tributo[this.MAX_TRIBUTOS];
    }

    public String cadastrarContribuinte(String cpf, String nome) {
        if (this.contadorContribuinte != 0) {
            for (int i = 0; i < this.contadorContribuinte; i++) {
                if (this.contribuintes[i].getCpf().equals(cpf)) {
                    throw new IllegalArgumentException("Contribuinte já cadastrado!");
                }
            }
        }

        Contribuinte contribuinte = new Contribuinte(cpf, nome);
        this.contribuintes[contadorContribuinte++] = contribuinte;

        return cpf;
    }

    public String[] listarContribuintes() {
        String[] listaContribuinte = new String[this.contadorContribuinte];

        for (int i = 0; i < this.contadorContribuinte; i++) {
            listaContribuinte[i] = this.contribuintes[i].toString();
        }

        return listaContribuinte;
    }

    public int cadastrarTributo(int codigoTributo, String descricao, double valor, int ano) {
        if (this.contadorTributos != 0) {
            for (int i = 0; i < this.contadorTributos; i++) {
                if (this.tributos[i].getCodigo() == codigoTributo) {
                    throw new IllegalArgumentException("O código já está sendo utilizado por outro tributo!");
                }
            }
        }

        Tributo tributo = new Tributo(codigoTributo, descricao, valor, ano);
        this.tributos[this.contadorTributos++] = tributo;
        
        return codigoTributo;

    }

    public String[] listarTributos() {
        String[] listaTributos = new String[this.contadorTributos];

        for (int i = 0; i < this.contadorTributos; i++) {
            listaTributos[i] = this.tributos[i].toString();
        }

        return listaTributos;
    }

    public double reajustarTributo(int codigoTributo, int ano, double percentual) {
        if (codigoTributo >= 1 && codigoTributo <= 60) {
            for (int i = 0; i < this.contadorTributos; i++) {
                if (this.tributos[i].getCodigo() == codigoTributo) {
                    Tributo tributo = this.tributos[i];

                    if (tributo.getAno() != ano) {
                        tributo.reajustarTributo(percentual, ano);
                        return tributo.getValorTributacao();
                    }
                }
            }
        }

        return 0;
    }

    public String atribuirTributoAoContribuinte(int codigoTributo, String cpfContribuinte) {
        if (codigoTributo >= 1 && codigoTributo <= 60) {
            for (int i = 0; i < this.contadorTributos; i++) {
                if (this.tributos[i].getCodigo() == codigoTributo) {
                    Tributo tributo = this.tributos[i];
                    
                    for (int j = 0; j < this.contadorContribuinte; j++) {
                        if (this.contribuintes[j].getCpf().equals(cpfContribuinte)) {
                            this.contribuintes[j].setTributo(new Tributo(tributo.getCodigo(), tributo.getDescricao(), tributo.getValorTributacao(), tributo.getAno()));
                            return "| TRIBUTO ADICIONADO COM SUCESSO |";
                        }
                    }
                }
            }
        }

        return "| TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO |";
    }

    public String pagarTributo(String cpfContribuinte, int codigoTributo) {
        for (int i = 0; i < this.contadorContribuinte; i++) {
            if (this.contribuintes[i].getCpf().equals(cpfContribuinte)) {
                Contribuinte contribuinte = this.contribuintes[i];

                if (contribuinte.pagarTributo(codigoTributo)) {
                    return "| TRIBUTO PAGO COM SUCESSO |";
                }
            }
        }

        return "| TRIBUTO OU CONTRIBUINTE NÃO ENCONTRADO |";
    }

    public String emitirExtratosDeTributos(String cpfContribuinte) {
        String extrato = "";

        for (int i = 0; i < this.contadorContribuinte; i++) {
            if (this.contribuintes[i].getCpf().equals(cpfContribuinte)) {
                Contribuinte contribuinte = this.contribuintes[i];
                extrato = contribuinte.emitirExtrato();
                break;
            }
        }

        return extrato;
    }

    public double totalPagoEmTributos(String cpfContribuinte, int ano) {
        double totalPago = -1;

        for (int i = 0; i < this.contadorContribuinte; i++) {
            if (this.contribuintes[i].getCpf().equals(cpfContribuinte)) {
                Contribuinte contribuinte = this.contribuintes[i];
                totalPago = contribuinte.totalPagoAno(ano);
                break;          
            }
        }

        return totalPago;
    }
}