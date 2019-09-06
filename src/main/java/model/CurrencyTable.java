package model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyTable {
    private String table;
    private String currency;
    private String code;
    private List<Rates> rates;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        rates.forEach(rates -> stringBuilder.append(rates.toString()).append(", "));
        stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
        return stringBuilder.toString();
    }

}
