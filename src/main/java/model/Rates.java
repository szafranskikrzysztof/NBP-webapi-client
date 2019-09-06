package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import util.LocalDateDeserializer;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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
