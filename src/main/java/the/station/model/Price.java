package the.station.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Price {
        private Integer idPrice;
        private Double unitPrice;
        private Instant appDate;
        private Integer idProduct;
}
