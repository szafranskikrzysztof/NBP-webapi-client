package ratesChecker;


import exception.IncorrectDateException;
import model.CurrencyTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.RestClient;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ratesCheckerTest {
    private static RestClient restClient = RestClient.INSTANCE;


    @Test
    void firstDateFromCurrencyTableShouldBeStartDate() throws IOException, IncorrectDateException {
        LocalDate startDate = LocalDate.now().minus(Period.ofDays(3));
        CurrencyTable currencyTable = restClient.getUSDCurrencyTable(startDate);
        LocalDate firstDateFromCurrencyTable = currencyTable.getRates().get(0).getEffectiveDate();
        assertEquals(startDate, firstDateFromCurrencyTable);
    }

    @Test
    void currencyTableShouldContainDateForUSD() throws IOException, IncorrectDateException {
        LocalDate startDate = LocalDate.now().minus(Period.ofDays(3));
        CurrencyTable currencyTable = restClient.getUSDCurrencyTable(startDate);
        assertEquals(currencyTable.getCode(), "USD");
    }

    @Test
    void shouldThrowErrorIfDateIsEarlierThan367DayBeforeStartDate() {
        assertThrows(IncorrectDateException.class, () -> restClient.getUSDCurrencyTable(LocalDate.now().minus(Period.ofDays(368))));
    }


}