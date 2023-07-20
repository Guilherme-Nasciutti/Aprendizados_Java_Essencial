package generics_set_map.application;

import generics_set_map.services.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgramProducts {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        String path = "C:\\temp\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                list.add(Integer.parseInt(line));
                line = br.readLine();
            }
            Integer x = CalculationService.max(list);
            System.out.println("Max: ");
            System.out.println(x);
        } catch (IOException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }
}
