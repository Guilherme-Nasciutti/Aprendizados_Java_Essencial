package interfaces.model.entites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcelamento {

    private static DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate dataDeVencimento;
    private Double quantia;

    public Parcelamento(LocalDate dataDeVencimento, Double quantia) {
        this.dataDeVencimento = dataDeVencimento;
        this.quantia = quantia;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public Double getQuantia() {
        return quantia;
    }

    public void setQuantia(Double quantia) {
        this.quantia = quantia;
    }

    @Override
    public String toString() {
        return dataDeVencimento.format(formatoData) + " - R$" + String.format("%.2f", quantia);
    }

}
