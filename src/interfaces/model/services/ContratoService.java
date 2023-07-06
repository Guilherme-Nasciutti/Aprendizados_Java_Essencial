package interfaces.model.services;

import interfaces.model.entites.Contrato;
import interfaces.model.entites.Parcelamento;

import java.time.LocalDate;

public class ContratoService {

    private PagamentoOnlineService pagamentoOnlineService;

    public ContratoService(PagamentoOnlineService pagamentoOnlineService) {
        this.pagamentoOnlineService = pagamentoOnlineService;
    }

    public void processamentoContrato(Contrato contrato, int meses) {
        double parcelaBasica = contrato.getValorTotal() / meses;
        for (int i = 1; i <= meses; i++) {
            LocalDate dataVencimento = contrato.getData().plusMonths(i);
            double juros = pagamentoOnlineService.juros(parcelaBasica, i);
            double taxa = pagamentoOnlineService.taxaDePagamento(parcelaBasica + juros);
            double parcela = parcelaBasica + juros + taxa;

            contrato.getParcelamentos().add(new Parcelamento(dataVencimento, parcela));
        }
    }
}
