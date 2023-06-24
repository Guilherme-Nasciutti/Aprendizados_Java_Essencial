package poo.entites;

public class CurrencyConverter {

    public static double IOF = 0.06;

    public static double dollarToReal(double valor, double precoDollar) {
        return valor * precoDollar * (1.0 + IOF);
    }
}
