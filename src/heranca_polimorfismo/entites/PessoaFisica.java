package herança_polimorfismo.entites;

public class PessoaFisica extends Contribuinte {

    private Double despesasComSaude;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, Double rendaAnual, Double despesasComSaude) {
        super(nome, rendaAnual);
        this.despesasComSaude = despesasComSaude;
    }

    public Double getDespesasComSaude() {
        return despesasComSaude;
    }

    public void setDespesasComSaude(Double despesasComSaude) {
        this.despesasComSaude = despesasComSaude;
    }

    @Override
    public Double imposto() {
        if (getRendaAnual() < 20000.00) {
            return getRendaAnual() * 0.15 - despesasComSaude * 0.5;
        } else {
            return getRendaAnual() * 0.25 - despesasComSaude * 0.5;
        }
    }
}