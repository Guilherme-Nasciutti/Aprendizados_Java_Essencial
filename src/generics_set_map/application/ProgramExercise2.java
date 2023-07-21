package generics_set_map.application;

/*
Exercicio Proposto:

Em um portal de cursos online, cada usuário possui um código único, representado porum número inteiro.

Cada instrutor do portal pode ter vários cursos, sendo que um mesmo aluno pode se matricular em quantos
cursos quiser.Assim, o número total de alunos de um instrutor não é simplesmente a soma dos alunos de todos os cursos
que ele possui, pois pode haver alunos repetidos em mais de um curso.

O instrutor Alex possui três cursos A, B e C, e deseja saber seu número total de alunos.

Seu programa deve ler os alunos dos cursos A, B e C do instrutor Alex, depois mostrar a
quantidade total e alunos dele, conforme exemplo.
*/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProgramExercise2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Integer> courseA = new HashSet<>();
        Set<Integer> courseB = new HashSet<>();
        Set<Integer> courseC = new HashSet<>();

        System.out.print("How many students for course A: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("ID student: ");
            int idStudent = sc.nextInt();
            courseA.add(idStudent);
        }
        System.out.print("\nHow many students for course B: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("ID student: ");
            int idStudent = sc.nextInt();
            courseB.add(idStudent);
        }
        System.out.print("\nHow many students for course C: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("ID student: ");
            int idStudent = sc.nextInt();
            courseC.add(idStudent);
        }

        Set<Integer> total = new HashSet<>(courseA);
        total.addAll(courseB);
        total.addAll(courseC);

        System.out.println("\nTotal students: " + total.size());

        sc.close();
    }
}
