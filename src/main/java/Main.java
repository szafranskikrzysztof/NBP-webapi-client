import exception.IncorrectDateException;
import model.CurrencyTable;
import rest.RestClient;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) throws IOException, IncorrectDateException {


        LocalDate givenDate = LocalDate.now().minus(Period.ofDays(4));
        CurrencyTable currencyTable = RestClient.INSTANCE.getUSDCurrencyTable(givenDate);
        System.out.println(currencyTable.toString());


    }
}
