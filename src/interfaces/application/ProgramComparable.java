package interfaces.application;

import interfaces.model.entites.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgramComparable {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        String path = "C:\\temp\\in.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String employeeCsv = br.readLine();
            while (employeeCsv != null) {
                String[] fields = employeeCsv.split(",");
                employees.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                employeeCsv = br.readLine();
            }
            Collections.sort(employees);
            for (Employee employee : employees) {
                System.out.println(employee.getName() + ", $" + employee.getSalary());
            }
        } catch (IOException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }
}
