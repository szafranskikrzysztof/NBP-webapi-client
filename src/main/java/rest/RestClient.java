package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.CurrencyTable;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public class RestClient {

    public static final RestClient INSTANCE = new RestClient();

    private RestClient() {
    }

    public CurrencyTable getExchangeTable(LocalDate startDate, LocalDate endDate, String RestPath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL restPath = new URL(RestPath + startDate.toString() + "/" + endDate.toString());
        return mapper.readValue(restPath, CurrencyTable.class);
    }
}

