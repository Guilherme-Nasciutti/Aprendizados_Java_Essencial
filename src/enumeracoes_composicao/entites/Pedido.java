package enumeracoes_composicao.entites;

import enumeracoes_composicao.entites.enums.StatusDoPedido;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {


    private static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date momento;
    private StatusDoPedido status;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Date momento, StatusDoPedido status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public void setStatus(StatusDoPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addItem(ItemPedido item) {
        itens.add(item);
    }

    public void removeItem(ItemPedido item) {
        itens.remove(item);
    }

    public Double total() {
        double soma = 0.0;
        for (ItemPedido item : itens) {
            soma += item.subTotal();
        }
        return soma;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data do pedido: ");
        sb.append(formatoData.format(momento) + "\n");
        sb.append("Status do pedido: ");
        sb.append(status + "\n");
        sb.append(cliente + "\n");
        sb.append("Itens do Pedido: \n");
        for (ItemPedido item : itens) {
            sb.append(item + "\n");
        }
        sb.append(String.format("Total: R$%.2f", total()));
        return sb.toString();
    }
}
