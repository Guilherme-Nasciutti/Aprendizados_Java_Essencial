package generics_set_map.application;

/*
Na contagem de votos de uma eleição, são gerados vários registros
de votação contendo o nome do candidato e a quantidade de votos
(formato .csv) que ele obteve em uma urna de votação. Você deve
fazer um programa para ler os registros de votação a partir de um
arquivo, e daí gerar um relatório consolidado com os totais de cada
candidato.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramExerciseMap {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> votos = new LinkedHashMap<>();

        System.out.print("Enter full path file: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String nomeCandidato = fields[0];
                int votosCandidato = Integer.parseInt(fields[1]);

                if (votos.containsKey(nomeCandidato)) {
                    int contageVotos = votos.get(nomeCandidato);
                    votos.put(nomeCandidato, votosCandidato + contageVotos);
                } else {
                    votos.put(nomeCandidato, votosCandidato);
                }
                line = br.readLine();
            }
            for (String key : votos.keySet()) {
                System.out.println(key + ": " + votos.get(key));
            }
        } catch (IOException error) {
            System.out.println("Error: " + error.getMessage());
        }

        System.out.println();

        sc.close();
    }
}