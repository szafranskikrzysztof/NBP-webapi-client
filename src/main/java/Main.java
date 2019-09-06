import exception.IncorrectDateException;
import model.CurrencyTable;
import ratesChecker.RatesChecker;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) throws IOException, IncorrectDateException {

        RatesChecker ratesChecker = new RatesChecker();
        LocalDate givenDate = LocalDate.now().minus(Period.ofDays(3));

        CurrencyTable currencyTable = ratesChecker.getUSDCurrencyTable(givenDate);
        System.out.println(currencyTable.toString());


    }
}
