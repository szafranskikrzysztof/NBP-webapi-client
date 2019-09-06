import lombok.NoArgsConstructor;
import model.CurrencyTable;
import rest.RestClient;
import rest.RestPath;

import java.io.IOException;
import java.time.LocalDate;


@NoArgsConstructor
public class RatesChecker {


    /**
     * @param startDate is exchange rates are checked starting from this data to current data.
     *                  Due to NBP-web-api rules start day cannot be earlien than 93 before current date.
     * @return CurrencyTable that stores information of bid and ask rates
     * of every single day between given date and current date
     * @throws IOException
     */
    public CurrencyTable getUSDCurrencyTable(LocalDate startDate) throws IOException {
        return RestClient.INSTANCE.getExchangeTable(startDate, LocalDate.now(), RestPath.UsdRates);
    }




}
