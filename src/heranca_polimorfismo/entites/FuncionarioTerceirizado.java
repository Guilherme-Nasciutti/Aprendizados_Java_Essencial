package herança_polimorfismo.entites;

public class FuncionarioTerceirizado extends Funcionario{

    private Double despesasAdicionais;

    public FuncionarioTerceirizado(){
        super();
    }

    public FuncionarioTerceirizado(String nome, Integer horas, Double valorPorHora, Double despesasAdicionais) {
        super(nome, horas, valorPorHora);
        this.despesasAdicionais = despesasAdicionais;
    }

    public Double getDespesasAdicionais() {
        return despesasAdicionais;
    }

    public void setDespesasAdicionais(Double despesasAdicionais) {
        this.despesasAdicionais = despesasAdicionais;
    }

    @Override
    public double pagamento(){
        return super.pagamento() + despesasAdicionais * 1.1;
    }
}
