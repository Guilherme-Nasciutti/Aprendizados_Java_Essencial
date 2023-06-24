package herança_polimorfismo.entites;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ProdutoUsado extends Produto {

    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    private LocalDate dataDeFabricacao;

    public ProdutoUsado() {
    }

    public ProdutoUsado(String nome, Double preco, LocalDate dataDeFabricacao) {
        super(nome, preco);
        this.dataDeFabricacao = dataDeFabricacao;
    }

    public LocalDate getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    public void setDataDeFabricacao(LocalDate dataDeFabricacao) {
        this.dataDeFabricacao = dataDeFabricacao;
    }

    @Override
    public String etiquetaDePreco() {
        return getNome()
                + " (Usado) R$"
                + String.format("%.2f", getPreco())
                + " (Data de fabricação: "
                + dataDeFabricacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ")";
    }

}

