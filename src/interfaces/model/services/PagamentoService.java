package interfaces.model.services;

public class PagamentoService implements PagamentoOnlineService{

    private static final double JUROS_MENSAL = 0.01;
    private static final double TAXA_PAGAMENTO  = 0.02;

    @Override
    public Double taxaDePagamento(double quantia) {
        return quantia * TAXA_PAGAMENTO ;
    }

    @Override
    public Double juros(double quantia, int meses) {
        return quantia * JUROS_MENSAL * meses;
    }
}
