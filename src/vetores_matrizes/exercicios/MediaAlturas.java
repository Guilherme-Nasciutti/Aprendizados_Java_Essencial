package vetores_matrizes.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class MediaAlturas {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("Quantas alturas deseja calcular? ");
        int n = sc.nextInt();
        double[] vetorAltura = new double[n];

        for (int indicador = 0; indicador < n; indicador++) {
            System.out.println("Digite a altura:");
            vetorAltura[indicador] = sc.nextDouble();
        }

        double soma = 0;

        for (int indicador = 0; indicador < n; indicador++) {
            soma += vetorAltura[indicador];
        }

        double mediaAlturas = soma / n;

        System.out.printf("A media das alturas é: %.2f", mediaAlturas);

        sc.close();
    }
}
