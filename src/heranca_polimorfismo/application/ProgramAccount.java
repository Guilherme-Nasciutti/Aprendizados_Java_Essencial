package herança_polimorfismo.application;

import herança_polimorfismo.entites.*;

public class ProgramAccount {
    public static void main(String[] args) {

        Conta conta01 = new Conta(101, "Joao", 1000.0);
        conta01.saque(200.0);
        System.out.println(conta01.getSaldo());

        ContaEmpresarial conta02 = new ContaEmpresarial(102, "Ana", 1000.0, 500.0);
        conta02.saque(200.0);
        System.out.println(conta02.getSaldo());

        ContaPoupanca conta03 = new ContaPoupanca(103, "Maria", 1000.0, 0.01);
        conta03.saque(200.0);
        System.out.println(conta03.getSaldo());

        Account account01 = new Account(1001,"Anna",1000.0);
        account01.withdraw(200.0);
        System.out.println(account01.getBalance());

        BussinessAccount account02 = new BussinessAccount(1002,"Bob",1000.0,500.0);
        account02.withdraw(200.0);
        System.out.println(account02.getBalance());

        SavingsAccount account03 = new SavingsAccount(1003,"Alex",1000.0,0.01);
        account03.withdraw(200.0);
        System.out.println(account03.getBalance());
    }
}
