package interfaces.model.services;

public class BrazilInterestService implements InterestService {

    private static final double INTEREST_RATE = 2.0;

    @Override
    public double getInterestRate() {
        return INTEREST_RATE;
    }
}
