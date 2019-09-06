package ratesChecker;

import exception.IncorrectDateException;
import lombok.NoArgsConstructor;
import model.CurrencyTable;
import rest.RestClient;
import rest.RestPath;

import java.io.IOException;
import java.time.LocalDate;


@NoArgsConstructor
public class RatesChecker {
    /**
     * Obtains CurrencyTable from NBP Web API containing
     * information of USD bid and ask rates from given day to current date.
     * @param startDate - not earlier than 367 days
     * before current date, not null
     * @return CurrencyTable that stores information of bid
     * and ask rates of every single day between given date and current date
     * @throws IOException - when connection with web API failed
     * @throws IncorrectDateException - when start date is more than 367 days before end date or
     * end date is before start date
     */
    public CurrencyTable getUSDCurrencyTable(LocalDate startDate) throws IOException, IncorrectDateException {
        return RestClient.INSTANCE.getExchangeTable(startDate, LocalDate.now(), RestPath.UsdRates);
    }




}
