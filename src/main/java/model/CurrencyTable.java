package model;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;


@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CurrencyTable {
    private String table;
    private String currency;
    private String code;
    private ArrayList<Rates> rates;


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        rates.forEach(rates -> stringBuilder.append(rates.toString()).append("\n"));

        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        return stringBuilder.toString();
    }

    public CurrencyTable calculateDayChange() {
        for (int i = 1; i < rates.size(); i++) {
            Rates dayRate = rates.get(i);
            Rates yesterdayRate = rates.get(i-1);
            BigDecimal askChange = dayRate.getAsk().subtract(yesterdayRate.getAsk());
            BigDecimal bidChange = dayRate.getBid().subtract(yesterdayRate.getBid());
            dayRate.setAskChange(askChange);
            dayRate.setBidChange(bidChange);
        }
    return this;
    }


}
