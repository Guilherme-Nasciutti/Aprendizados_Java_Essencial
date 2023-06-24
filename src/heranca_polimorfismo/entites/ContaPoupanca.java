package herança_polimorfismo.entites;

public class ContaPoupanca extends Conta {

    private Double taxaDeJuros;

    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(Integer numero, String titular, Double saldo, Double taxaDeJuros) {
        super(numero, titular, saldo);
        this.taxaDeJuros = taxaDeJuros;
    }

    public Double getTaxaDeJuros() {
        return taxaDeJuros;
    }

    public void setTaxaDeJuros(Double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }

    public void atualizarSaldo() {
        saldo += saldo * taxaDeJuros;
    }

    @Override
    public void saque(double valor) {
        saldo -= valor;
    }
}
