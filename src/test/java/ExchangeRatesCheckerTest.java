import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;

public class ExchangeRatesCheckerTest {




    @Test
    public void shouldWorkd() throws IOException {
        RatesChecker checker = new RatesChecker();
        LocalDate localDate = LocalDate.parse("2019-09-03");
        System.out.println(checker.getUSDCurrencyTable(localDate).toString());
    }
}