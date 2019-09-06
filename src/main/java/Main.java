import model.CurrencyTable;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) throws IOException {

        RatesChecker ratesChecker = new RatesChecker();
        LocalDate givenDate = LocalDate.now().minus(Period.ofDays(3));

        CurrencyTable currencyTable = ratesChecker.getUSDCurrencyTable(givenDate);


    }
}
