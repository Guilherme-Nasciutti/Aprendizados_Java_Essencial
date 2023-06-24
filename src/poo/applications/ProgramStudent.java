package poo.applications;

import poo.entites.Student;

import java.util.Locale;
import java.util.Scanner;

public class ProgramStudent {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        System.out.println("Digite os dados do aluno");
        System.out.print("Nome: ");
        student.name = sc.nextLine();
        System.out.print("Nota 1: ");
        student.grade1 = sc.nextDouble();
        System.out.print("Nota 2: ");
        student.grade2 = sc.nextDouble();
        System.out.print("Nota 3: ");
        student.grade3 = sc.nextDouble();

        System.out.printf("Nota final: %.2f", student.finalGrade());

        if (student.finalGrade() < 60.0) {
            System.out.printf("\nReprovado.\nFaltaram %.2f pontos para a aprovação.", student.missingPoints());
        } else {
            System.out.println("\nAprovado. Parabéns!");
        }


        sc.close();
    }
}
