package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import exception.IncorrectDateException;
import model.CurrencyTable;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;

public class RestClient {

    public static final RestClient INSTANCE = new RestClient();

    private RestClient() {
    }


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
        return getExchangeTable(startDate, LocalDate.now(), RestPath.UsdRates);
    }

    private CurrencyTable getExchangeTable(LocalDate startDate, LocalDate endDate, String RestPath) throws IOException, IncorrectDateException {
        validateDates(startDate, endDate);
        ObjectMapper mapper = new ObjectMapper();
        URL restPath = new URL(RestPath + startDate.toString() + "/" + endDate.toString());
        return mapper.readValue(restPath, CurrencyTable.class).calculateDayChange();
    }

    private static void validateDates(LocalDate startDate, LocalDate endDate) throws IncorrectDateException {
        if (startDate.isAfter(endDate)) {
            throw new IncorrectDateException("End date cannot be after start date");
        }
        if (startDate.isBefore(LocalDate.now().minus(Period.ofDays(367)))) {
            throw new IncorrectDateException("Start date cannot be earlier than 367 days before end date");
        }
    }


}

