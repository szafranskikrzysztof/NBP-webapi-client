package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private BigDecimal askChange;
    private BigDecimal bidChange;

    void setAskChange(BigDecimal askChange) {
        this.askChange = askChange;
    }

    void setBidChange(BigDecimal bidChange) {
        this.bidChange = bidChange;
    }

    @Override
    public String toString() {
        return  effectiveDate + "{" +
                "bid=" + bid +
                ", ask=" + ask +
                ", bid change=" + bidChange +
                ", ask change=" + askChange +
                '}';
    }


}
