package herança_polimorfismo.entites;

public class ProdutoImportado extends Produto {

    private Double taxaAlfandegaria;

    public ProdutoImportado() {
    }

    public ProdutoImportado(String nome, Double preco, Double taxaAlfandegaria) {
        super(nome, preco);
        this.taxaAlfandegaria = taxaAlfandegaria;
    }

    public Double getTaxaAlfandegaria() {
        return taxaAlfandegaria;
    }

    public void setTaxaAlfandegaria(Double taxaAlfandegaria) {
        this.taxaAlfandegaria = taxaAlfandegaria;
    }

    public Double precoTotal() {
        return getPreco() + taxaAlfandegaria;
    }

    @Override
    public String etiquetaDePreco() {
        return getNome()
                + " R$"
                + String.format("%.2f", precoTotal())
                + " (Taxa Alfandegaria: R$"
                + String.format("%.2f", taxaAlfandegaria)
                + ")";
    }

}
