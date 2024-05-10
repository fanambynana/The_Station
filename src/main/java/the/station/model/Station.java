package the.station.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Station {
    private Integer idStation;
    private String stationName;
    private String location;
    private String reference;
}
