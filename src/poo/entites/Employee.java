package poo.entites;

public class Employee {

    public String name;
    public double grossSalary;
    public double tax;

    public double netSalary() {
        return grossSalary - tax;
    }

    public double increaseSalary(double percentage) {
        return grossSalary += grossSalary * percentage / 100;
    }

    public String toString() {
        return "Funcionário: "
                + name
                + "\nSalário: $"
                + String.format("%.2f" , netSalary());
    }

}
