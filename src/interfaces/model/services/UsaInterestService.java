package interfaces.model.services;

public class UsaInterestService implements InterestService {

    private static final double INTEREST_RATE = 1.0;

    @Override
    public double getInterestRate() {
        return INTEREST_RATE;
    }
}
