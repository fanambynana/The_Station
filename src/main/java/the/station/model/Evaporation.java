package the.station.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import the.station.model.Enum.EvaporationPeriod;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Evaporation {
    private Integer idEvaporation;
    private Integer rate;
    private EvaporationPeriod period;
    private LocalDate changeDate;
    private Integer idProduct;
}
