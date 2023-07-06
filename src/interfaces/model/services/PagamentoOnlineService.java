package interfaces.model.services;

public interface PagamentoOnlineService {

    public Double taxaDePagamento(double quantia);

    public Double juros(double quantia, int meses);
}
