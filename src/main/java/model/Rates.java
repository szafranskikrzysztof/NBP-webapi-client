package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import util.LocalDateDeserializer;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class Rates {
    private String no;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate effectiveDate;
    private BigDecimal bid;
    private BigDecimal ask;


    @Override
    public String toString() {
        return  effectiveDate + "{" +
                "bid=" + bid +
                ", ask=" + ask +
                '}';
    }
}
