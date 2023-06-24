package enumeracoes_composicao.application;

import enumeracoes_composicao.entites.Cliente;
import enumeracoes_composicao.entites.ItemPedido;
import enumeracoes_composicao.entites.Pedido;
import enumeracoes_composicao.entites.Produto;
import enumeracoes_composicao.entites.enums.StatusDoPedido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ProgramPedido {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Digite os dados do cliente:");
        System.out.print("Nome: ");
        String nomeCliente = scanner.next();
        System.out.print("Email: ");
        String emailCliente = scanner.next();
        System.out.print("Data de Nascimento (DD/MM/YYYY): ");
        Date dataNascimento = formatoData.parse(scanner.next());
        Cliente cliente = new Cliente(nomeCliente, emailCliente, dataNascimento);

        System.out.println("\nDigite os dados do pedido: ");
        System.out.print("Estado: ");
        StatusDoPedido status = StatusDoPedido.valueOf(scanner.next().toUpperCase());
        Pedido pedido = new Pedido(new Date(), status, cliente);

        System.out.print("\nQuantos itens contem nesse pedido? ");
        int numeroItens = scanner.nextInt();

        for (int i = 1; i <= numeroItens; i++) {
            System.out.println("\nDigite os dados do " + i + "° item: ");
            System.out.print("Nome: ");
            String nomeProduto = scanner.next();
            System.out.print("Preço: ");
            double precoProduto = scanner.nextDouble();
            Produto produto = new Produto(nomeProduto, precoProduto);

            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();

            ItemPedido itemPedido = new ItemPedido(quantidade, precoProduto, produto);
            pedido.addItem(itemPedido);
        }

        System.out.println();
        System.out.println("Resumo do Pedido: ");
        System.out.println(pedido);

        scanner.close();
    }
}
