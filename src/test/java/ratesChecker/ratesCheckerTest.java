package ratesChecker;


import exception.IncorrectDateException;
import model.CurrencyTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ratesCheckerTest {
    private RatesChecker checker;

    @BeforeEach
    void setUp(){
       checker = new RatesChecker();
    }

    @Test
    void firstDateFromCurrencyTableShouldBeStartDate() throws IOException, IncorrectDateException {
        LocalDate startDate = LocalDate.now().minus(Period.ofDays(3));
        CurrencyTable currencyTable = checker.getUSDCurrencyTable(startDate);
        LocalDate firstDateFromCurrencyTable = currencyTable.getRates().get(0).getEffectiveDate();
        assertEquals(startDate, firstDateFromCurrencyTable);
    }

    @Test
    void currencyTableShouldContainDateForUSD() throws IOException, IncorrectDateException {
        LocalDate startDate = LocalDate.now().minus(Period.ofDays(3));
        CurrencyTable currencyTable = checker.getUSDCurrencyTable(startDate);
        assertEquals(currencyTable.getCode(), "USD");
    }

    @Test
    void shouldThrowErrorIfDateIsEarlierThan367DayBeforeStartDate() {
        assertThrows(IncorrectDateException.class, () -> checker.getUSDCurrencyTable(LocalDate.now().minus(Period.ofDays(368))));
    }


}