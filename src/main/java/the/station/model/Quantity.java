package the.station.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Quantity {
    Integer idQuantity;
    Double value;
    Instant updateDatetime;
    Integer idProduct;
}
