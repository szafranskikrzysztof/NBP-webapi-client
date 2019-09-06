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

    public CurrencyTable getExchangeTable(LocalDate startDate, LocalDate endDate, String RestPath) throws IOException, IncorrectDateException {
        validateDates(startDate, endDate);
        ObjectMapper mapper = new ObjectMapper();
        URL restPath = new URL(RestPath + startDate.toString() + "/" + endDate.toString());
        return mapper.readValue(restPath, CurrencyTable.class);
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

