package vetores_matrizes.listas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Listas {
    public static void main(String[] args) {

        /*Listas não aceitam tipos primitivos nos seus parametros. EX: Integer e não int.
         * A instanciação tem que ser por meio de uma classe que implementa a interface. EX: ArrayList*/
        List<String> lista = new ArrayList<>();

        lista.add("Maria");
        lista.add("Marcos");
        lista.add("João");
        lista.add("José");
        lista.add("Paulo");
        lista.add(2, "Ana"); /*Adiciona elementos conforme a posição indicado*/

        lista.remove("Ana"); /*remove pela comparação do valor passado com o dado da lista*/
        lista.remove(1); /*remove pela posição da lista*/
        lista.removeIf(nome -> nome.charAt(0) == 'P'); /*remove através da função lambda por um predicado*/


        System.out.println(lista.size()); /*.size é para ver o tamanho da lista*/

        for (String nome : lista) {
            System.out.println(nome);
        }
        System.out.println("Posição na lista do nome João: " + lista.indexOf("João"));


        List<String> resultado = lista.stream().filter(nome -> nome.charAt(0) == 'J').collect(Collectors.toList());
        System.out.println(resultado);
    }
}
