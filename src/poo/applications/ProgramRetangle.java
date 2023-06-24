package poo.applications;

import poo.entites.Retangle;

import java.util.Locale;
import java.util.Scanner;

public class ProgramRetangle {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Retangle retangle = new Retangle();

        System.out.println("Digite os dados do retangulo.");
        System.out.println("Largura: ");
        retangle.width = sc.nextDouble();
        System.out.println("Altura: ");
        retangle.height = sc.nextDouble();

        System.out.println("Area: " + retangle.area());
        System.out.println("Perimeter: " + retangle.perimeter());
        System.out.println("Diagonal: " + retangle.diagonal());

        sc.close();
    }

}
